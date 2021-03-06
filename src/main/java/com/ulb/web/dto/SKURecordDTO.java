package com.ulb.web.dto;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by wangpeng on 25/07/2017.
 */
public class SKURecordDTO {

    private String rid;

    private String name;

    private BigDecimal price;

    private String unit;

    private String content;

    private String imgUrl;

    private String usefulTime;

    private DingDingConfigDTO config;

    private String cityCode;

    private String priceFormat;

    public String getRid() {
        return rid;
    }

    public void setRid(String rid) {
        this.rid = rid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getUsefulTime() {
        return usefulTime;
    }

    public void setUsefulTime(String usefulTime) {
        this.usefulTime = usefulTime;
    }

    public DingDingConfigDTO getConfig() {
        return config;
    }

    public void setConfig(DingDingConfigDTO config) {
        this.config = config;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getPriceFormat() {
        return priceFormat;
    }

    public void setPriceFormat(String priceFormat) {
        this.priceFormat = priceFormat;
    }
}
