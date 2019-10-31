package com.example.demo.log;

import com.example.demo.log.duration.DurationRequest;
import com.example.demo.log.duration.ReadInfo;
import com.example.demo.log.event.Event;
import com.example.demo.log.event.EventRequest;
import com.example.demo.log.utils.DateUtil;
import com.google.gson.Gson;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author daizhichao
 * @date 2018/12/15
 */
@Slf4j
public class AnalysisLogFile {

    public static final int EVENT = 0;
    public static final int DURATION = 1;

    //每页时长上限
    public static final long MAXTIME = 600L;

    public static void main(String[] args) throws Exception {
        log.info("start deal log file");
        Date beginDate = new Date();
//        dealLogFile("C:/Users/xykj/Desktop/事件日志.log", "C:/Users/xykj/Desktop/事件日志_format.log", EVENT);
        dealLogFile("C:/Users/xykj/Desktop/时长日志1.log", "C:/Users/xykj/Desktop/时长日志1_format.log", DURATION);
        log.info("finish deal log file");
        Date endDate = new Date();
        log.info("deal log file use time : {}", endDate.getTime() - beginDate.getTime());
        return;
    }

    private static void dealLogFile(String readFilePath, String writeFilePath, int type) throws IOException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Path readFPath = Paths.get(readFilePath);
        if (!Files.exists(readFPath)) {
            return;
        }
        BufferedReader bufferedReader = Files.newBufferedReader(readFPath);
        Path writeFPath = Paths.get(writeFilePath);
        //创建文件
        if (!Files.exists(writeFPath)) {
            try {
                Files.createFile(writeFPath);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        BufferedWriter bufferedWriter = Files.newBufferedWriter(writeFPath);
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            String[] split = line.split(" ");
            //获取ip
            String ip = split[0];
            //获取时间
            String date = split[3];
            //获取uri
            String uri = split[6];
            int index = uri.indexOf("?");
            String paramsStr = uri.substring(index + 1);
            String[] paramToValues = paramsStr.split("&");
            //反射获取BaseRequest信息
            Class<BaseRequest> baseRequestClass = BaseRequest.class;
            Constructor<BaseRequest> constructor = baseRequestClass.getConstructor();
            Object baseRequestObject = constructor.newInstance();
            for (int i = 0; i < paramToValues.length; i++) {
                String[] paramToValue = paramToValues[i].split("=");
                String param = paramToValue[0];
                Field declaredField = baseRequestClass.getDeclaredField(param);
                declaredField.setAccessible(true);
                declaredField.set(baseRequestObject, paramToValue.length > 1 ? paramToValue[1] : "");
            }
            //获取requestBody
            String replace = split[13].replace("\\\"", "\"");
            if (EVENT == type) {
                dealEvent(bufferedWriter, ip, baseRequestObject, replace);
            }
            if (DURATION == type) {
                dealDuration(bufferedWriter, ip, date, baseRequestObject, replace);
            }
        }
        bufferedReader.close();
        bufferedWriter.close();
    }

    private static void dealEvent(BufferedWriter bufferedWriter, String ip, Object baseRequestObject, String replace) throws IllegalAccessException, IOException {
        EventRequest eventRequest = new Gson()
                .fromJson(new JsonParser()
                        .parse(replace), new TypeToken<EventRequest>() {
                }
                        .getType());
        BeanUtils.copyProperties(baseRequestObject, eventRequest);
        List<Event> eventList = eventRequest.getEvents();
        eventRequest.setEventJsonStr(new Gson().toJson(eventList));
        eventRequest.setIp(ip);
        //对象写文件
        StringBuffer stringBuffer = new StringBuffer();
        Class<EventRequest> eventRequestClass = EventRequest.class;
        Field[] declaredFields = eventRequestClass.getFields();
        for (Field field : declaredFields) {
            if (field.getName() != "events") {
                field.setAccessible(true);
                Object o = field.get(eventRequest);
                stringBuffer.append(o).append(" ");
            }
        }
        bufferedWriter.write(stringBuffer.toString());
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }

    private static void dealDuration(BufferedWriter bufferedWriter, String ip, String date, Object baseRequestObject, String replace) throws IllegalAccessException, IOException {
        DurationRequest durationRequest = new Gson()
                .fromJson(new JsonParser()
                        .parse(replace), new TypeToken<DurationRequest>() {
                }
                        .getType());
        BeanUtils.copyProperties(baseRequestObject, durationRequest);
        //处理readInfoList
        List<ReadInfo> readInfoList = durationRequest.getReadInfos();
        if (!CollectionUtils.isEmpty(readInfoList)) {
            Long useTime = readInfoList
                    .stream()
                    .map(ReadInfo::getTime)
                    .collect(Collectors.toList())
                    .stream()
                    .map(time -> {
                        if (time > MAXTIME) {
                            time = MAXTIME;
                        }
                        return time;
                    })
                    .reduce((a, b) -> a + b)
                    .orElse(0L);
            durationRequest.setUseTime(useTime);
            durationRequest.setReadInfoJsonStr(new Gson().toJson(readInfoList));
        }
        durationRequest.setIp(ip);
        durationRequest.setRequestTime(DateUtil.formatDate(date));
        //对象写文件
        StringBuffer stringBuffer = new StringBuffer();
        Class<DurationRequest> durationRequestClass = DurationRequest.class;
        Field[] declaredFields = durationRequestClass.getFields();
        for (Field field : declaredFields) {
            if (field.getName() != "readInfos") {
                field.setAccessible(true);
                Object o = field.get(durationRequest);
                stringBuffer.append(o).append(" ");
            }
        }
        bufferedWriter.write(stringBuffer.toString());
        bufferedWriter.newLine();
        bufferedWriter.flush();
    }
}
