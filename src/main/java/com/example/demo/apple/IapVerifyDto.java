package com.example.demo.apple;

import lombok.Data;

/**
 * @author daizhichao
 * @date 2018/12/7
 */
@Data
public class IapVerifyDto {
    private String status;
    private String environment;
    private Receipt receipt;
}
