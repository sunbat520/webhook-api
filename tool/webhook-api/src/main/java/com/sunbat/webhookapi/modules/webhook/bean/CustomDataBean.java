package com.sunbat.webhookapi.modules.webhook.bean;

/**
 * @author: SunYb
 * @date: 2024/6/12 16:20
 * @version: 1.0
 */
public class CustomDataBean {
    /**
     * 标签
     */
    private String key;
    /**
     * 标签
     */
    private String label;
    /**
     * 值
     */
    private String value;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
