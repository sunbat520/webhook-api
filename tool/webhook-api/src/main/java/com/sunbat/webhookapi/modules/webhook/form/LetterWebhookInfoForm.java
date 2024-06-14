package com.sunbat.webhookapi.modules.webhook.form;

import com.sunbat.webhookapi.modules.webhook.bean.CustomDataBean;

import java.util.List;

/**
 * 流程webhook入参信息
 * @author: SunYb
 * @date: 2024/6/12 16:18
 * @version: 1.0
 */
public class LetterWebhookInfoForm {
    /**
     * 流程ID
     */
    private Long letterId;
    /**
     * 流程Guid
     */
    private String letterGuid;
    /**
     * 流程Guid
     */
    private String letterNumber;
    /**
     * 流程类型
     */
    private Integer letterType;
    /**
     * 流程名称
     */
    private String letterName;
    /**
     * 流程状态
     */
    private Integer letterStatus;
    /**
     * 流程模板Id
     */
    private Long letterTemplateId;
    /**
     * 流程模板名称
     */
    private String templateName;
    /**
     * 备注
     */
    private String remarks;
    /**
     * 流程申请人ID
     */
    private Long creatorId;
    /**
     * 流程申请人
     */
    private String creatorName;
    /**
     *当前节点信息
     */
    private LetterAtNodeInfoForm node;
    /**
     *流程内容信息
     */
    private List<CustomDataBean> contentList;

    public Long getLetterId() {
        return letterId;
    }

    public void setLetterId(Long letterId) {
        this.letterId = letterId;
    }

    public String getLetterGuid() {
        return letterGuid;
    }

    public void setLetterGuid(String letterGuid) {
        this.letterGuid = letterGuid;
    }

    public String getLetterNumber() {
        return letterNumber;
    }

    public void setLetterNumber(String letterNumber) {
        this.letterNumber = letterNumber;
    }

    public Integer getLetterType() {
        return letterType;
    }

    public void setLetterType(Integer letterType) {
        this.letterType = letterType;
    }

    public String getLetterName() {
        return letterName;
    }

    public void setLetterName(String letterName) {
        this.letterName = letterName;
    }

    public Integer getLetterStatus() {
        return letterStatus;
    }

    public void setLetterStatus(Integer letterStatus) {
        this.letterStatus = letterStatus;
    }

    public Long getLetterTemplateId() {
        return letterTemplateId;
    }

    public void setLetterTemplateId(Long letterTemplateId) {
        this.letterTemplateId = letterTemplateId;
    }

    public String getTemplateName() {
        return templateName;
    }

    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Long getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Long creatorId) {
        this.creatorId = creatorId;
    }

    public String getCreatorName() {
        return creatorName;
    }

    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName;
    }

    public LetterAtNodeInfoForm getNode() {
        return node;
    }

    public void setNode(LetterAtNodeInfoForm node) {
        this.node = node;
    }

    public List<CustomDataBean> getContentList() {
        return contentList;
    }

    public void setContentList(List<CustomDataBean> contentList) {
        this.contentList = contentList;
    }
}
