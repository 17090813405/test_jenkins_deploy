package com.example.demo.apple;

import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

/**
 * @author daizhichao
 * @date 2018/12/7
 */
@RestController
@RequestMapping("/appStoreApi")
public class AppStoreApi {

    /**
     * 购买凭证验证地址
     */
    private static final String certificateUrl = "https://buy.itunes.apple.com/verifyReceipt";

    /**
     * 测试的购买凭证验证地址
     */
    private static final String certificateUrlTest = "https://sandbox.itunes.apple.com/verifyReceipt";

    /**
     * 连续支付公共密钥
     */
    private static final String secretKey = "cd59bfa0dec943349364f01c6953bb12";

    /**
     * 接收iOS端发过来的购买凭证
     *
     * @param receipt
     * @param chooseEnv
     * @param isContinuous
     * @return
     */
    @RequestMapping("/setIapCertificate")
    public IapVerifyDto setIapCertificate(String receipt, boolean chooseEnv, boolean isContinuous) {



        return checkCertificate(receipt, chooseEnv, isContinuous);
    }

    /**
     * 验证凭证
     *
     * @param receipt
     * @param chooseEnv
     * @param isContinuous
     * @return
     */
    public IapVerifyDto checkCertificate(String receipt, boolean chooseEnv, boolean isContinuous) {
        IapVerifyDto iapVerifyDto = new IapVerifyDto();
        receipt = receipt.replaceAll(" ", "+");
        String url = chooseEnv ? certificateUrl : certificateUrlTest;
        String result = sendHttpsCoon(url, receipt, isContinuous);
        if (StringUtils.isNotEmpty(result)) {
            iapVerifyDto = new Gson()
                    .fromJson(new JsonParser()
                            .parse(result), new TypeToken<IapVerifyDto>() {
                    }
                            .getType());
        }
        return iapVerifyDto;
    }

    /**
     * 发送请求
     *
     * @param url
     * @param code
     * @return
     */
    private String sendHttpsCoon(String url, String code, boolean isContinuous) {
        if (url.isEmpty()) {
            return null;
        }
        try {
            //设置SSLContext
            SSLContext ssl = SSLContext.getInstance("SSL");
            ssl.init(null, new TrustManager[]{myX509TrustManager}, null);

            //打开连接
            HttpsURLConnection conn = (HttpsURLConnection) new URL(url).openConnection();
            //设置套接工厂
            conn.setSSLSocketFactory(ssl.getSocketFactory());
            //加入数据
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setRequestProperty("Content-type", "application/json");

            JSONObject obj = new JSONObject();
            obj.put("receipt-data", code);
            if (isContinuous) {
                obj.put("password", secretKey);
            }

            BufferedOutputStream buffOutStr = new BufferedOutputStream(conn.getOutputStream());
            buffOutStr.write(obj.toString().getBytes());
            buffOutStr.flush();
            buffOutStr.close();

            //获取输入流
            BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

            String line = null;
            StringBuffer sb = new StringBuffer();
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
            return sb.toString();

        } catch (Exception e) {
            return null;
        }
    }

    /**
     * 重写X509TrustManager
     */
    private static TrustManager myX509TrustManager = new X509TrustManager() {

        @Override
        public X509Certificate[] getAcceptedIssuers() {
            return null;
        }

        @Override
        public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }

        @Override
        public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {

        }
    };
}
