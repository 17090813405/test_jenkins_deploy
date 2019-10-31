package com.example.demo.log.event;

import com.example.demo.log.BaseRequest;
import lombok.Data;

import java.util.List;

/**
 * @author daizhichao
 * @date 2018/12/17
 */
@Data
public class EventRequest extends BaseRequest {
    public List<Event> events;
    public String eventJsonStr;
    public String beginDate;
    public String channel;
    public String appVersion;
    public String ua;
    public String deviceId;
    public String website;
    public String currUrl;
    public String refUrl;
    public String ov;
    public String bsv;
}
