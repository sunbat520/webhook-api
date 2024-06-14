package com.sunbat.webhookapi.modules.webhook.bean;

/**
 * 流程REDIS缓存
 *
 * @author: SunYb
 * @date: 2024/6/13 16:20
 * @version: 1.0
 */
public class LetterMessageInfoBean {

    /**
     * 流程类型
     */
    private Integer letterType;
    /**
     * 流程信息
     */
    private String letterContent;

    public Integer getLetterType() {
        return letterType;
    }

    public void setLetterType(Integer letterType) {
        this.letterType = letterType;
    }

    public String getLetterContent() {
        return letterContent;
    }

    public void setLetterContent(String letterContent) {
        this.letterContent = letterContent;
    }
}
