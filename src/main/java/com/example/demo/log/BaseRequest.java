package com.example.demo.log;

import lombok.Data;

/**
 * @author daizhichao
 * @date 2018/12/18
 */
@Data
public class BaseRequest {
    public String userId;
    public String platform;
    public String network;
    public String tk;
    public String appId;
    public String sdk;
    public String ip;
}
