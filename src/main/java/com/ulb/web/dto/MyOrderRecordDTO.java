package com.ulb.web.dto;

import java.util.List;

/**
 * Created by wangpeng on 25/07/2017.
 */
public class MyOrderRecordDTO {

    private List<OrderRecordDTO> list;

    private List<OrderRecordDTO> list1;

    private List<OrderRecordDTO> list2;

    private DingDingConfigDTO config;

    private String title;

    private String flag;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<OrderRecordDTO> getList() {
        return list;
    }

    public void setList(List<OrderRecordDTO> list) {
        this.list = list;
    }

    public List<OrderRecordDTO> getList1() {
        return list1;
    }

    public void setList1(List<OrderRecordDTO> list1) {
        this.list1 = list1;
    }

    public List<OrderRecordDTO> getList2() {
        return list2;
    }

    public void setList2(List<OrderRecordDTO> list2) {
        this.list2 = list2;
    }

    public DingDingConfigDTO getConfig() {
        return config;
    }

    public void setConfig(DingDingConfigDTO config) {
        this.config = config;
    }

    public String getFlag() {
        return flag;
    }

    public void setFlag(String flag) {
        this.flag = flag;
    }
}
