package com.example.demo.apple;

import lombok.Data;

/**
 * @author daizhichao
 * @date 2018/12/8
 */
@Data
public class InApp {
    private String quantity;
    private String product_id;
    private String transaction_id;
    private String original_transaction_id;
    private String purchase_date;
    private String purchase_date_ms;
    private String purchase_date_pst;
    private String original_purchase_date;
    private String original_purchase_date_ms;
    private String original_purchase_date_pst;
    private String is_trial_period;
}
