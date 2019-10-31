package com.example.demo.log.event;

import lombok.Data;

import java.util.List;

/**
 * @author daizhichao
 * @date 2018/12/17
 */
@Data
public class Event {
    private String eventId;
    private List<EventAttr> eventAttrs;
    private String eventDate;
}
