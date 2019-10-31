package com.example.demo.log.duration;

import com.example.demo.log.BaseRequest;
import lombok.Data;

import java.util.List;

/**
 * @author daizhichao
 * @date 2018/12/18
 */
@Data
public class DurationRequest extends BaseRequest {
    public String actionId;
    public Long date;
    public Long ut;
    public Long tt;
    public String type;
    public String ri;
    public String rt;
    public List<ReadInfo> readInfos;
    public String readInfoJsonStr;
    public Long useTime;
    public Long totalTime;
    public String requestTime;
}
