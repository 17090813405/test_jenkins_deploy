package com.example.demo.apple;

import lombok.Data;

import java.util.List;

/**
 * @author daizhichao
 * @date 2018/12/7
 */
@Data
public class Receipt {
    private String receipt_type;
    private String adam_id;
    private String app_item_id;
    private String bundle_id;
    private String application_version;
    private String download_id;
    private String version_external_identifier;
    private String receipt_creation_date;
    private String receipt_creation_date_ms;
    private String receipt_creation_date_pst;
    private String request_date;
    private String request_date_ms;
    private String request_date_pst;
    private String original_purchase_date;
    private String original_purchase_date_ms;
    private String original_purchase_date_pst;
    private String original_application_version;
    private List<InApp> in_app;
}
