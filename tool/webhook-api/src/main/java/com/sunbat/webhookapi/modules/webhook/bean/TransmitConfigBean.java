package com.sunbat.webhookapi.modules.webhook.bean;


import org.hibernate.validator.constraints.Range;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author: SunYb
 * @date: 2024/6/12 16:25
 * @version: 1.0
 */
public class TransmitConfigBean {
    /**
     * 节点Id
     */
    @NotNull(message = "节点ID不能为空")
    private Long letterFlowNodeId;
    /**
     * 操作按钮名称
     */
    private String btnName;
    /**
     * 传递类型  1，上一步处理人；2，拟稿人；3，自定义；4，指定人；5，指定标签；6，指定机器人;
     */
    @Range(message = "传递类型参数错误", min = 1, max = 6)
    private Integer transType;
    /**
     * 是否单选
     */
    @Range(message = "是否单选错误", min = 1, max = 2)
    private Integer hasRadio;
    /**
     * 默认用户ID集合
     */
    private String transSysUserIds;
    /**
     * 默认用户标签
     */
    private String transSysUserRoles;
    /**
     * 默认机器人ID集合
     */
    private String transRobotIds;
    /**
     * 抄送类型 0， 默认值； 1，上一步处理人；2，拟稿人；3，自定义；4，指定人；5，指定标签；
     */
    @Range(message = "抄送类型参数错误", min = 0, max = 5)
    private Integer copyType;
    /**
     * 抄送默认用户ID集合
     */
    private String copySysUserIds;
    /**
     * 抄送默认用户标签
     */
    private String copySysUserRoles;
    /**
     * 签批类型  1，会签；2，或签；
     */
    @Range(message = "签批类型参数错误", min = 1, max = 2)
    private Integer signType;
    /**
     * 是否发送短信  1，是；2，否；
     */
    @Range(message = "是否发送短信参数错误", min = 1, max = 2)
    private Integer hasTransSms;
    /**
     * 是否发送企业微信消息  1，是；2，否；
     */
    @Range(message = "是否发送企业微信消息参数错误", min = 1, max = 2)
    private Integer hasTransWxMessage;
    /**
     * 是否发送企讯微信消息  1，是；2，否；
     */
    @Range(message = "是否发送企讯消息参数错误", min = 1, max = 2)
    private Integer hasTransQixun;
    /**
     * 是否发送i国网消息  1，是；2，否；
     */
    @Range(message = "是否发送i国网消息参数错误", min = 1, max = 2)
    private Integer hasTransIscMessage;
    /**
     * 是否发送邮件消息  1，是；2，否；
     */
    @Range(message = "是否发送邮件消息参数错误", min = 1, max = 2)
    private Integer hasTransEmail;
    /**
     * 是否发送企业微信任务卡  1，是；2，否；
     */
    @Range(message = "是否发送企业微信任务卡参数错误", min = 1, max = 2)
    private Integer hasTransWxTaskcard;
    /**
     * 抄送是否发送短信  1，是；2，否；
     */
    @Range(message = "抄送是否发送短信参数错误", min = 1, max = 2)
    private Integer hasCopySms;
    /**
     * 抄送是否发送企业微信消息  1，是；2，否；
     */
    @Range(message = "抄送是否发送企业微信消息参数错误", min = 1, max = 2)
    private Integer hasCopyWxMessage;

    /**
     * 是否发送企讯微信消息  1，是；2，否；
     */
    @Range(message = "抄送是否发送企讯消息参数错误", min = 1, max = 2)
    private Integer hasCopyQixun;
    /**
     * 抄送是否发送i国网消息 1，是；2，否；
     */
    @Range(message = "抄送是否发送i国网消息参数错误", min = 1, max = 2)
    private Integer hasCopyIscMessage;
    /**
     * 是否发送邮件消息  1，是；2，否；
     */
    @Range(message = "抄送是否发送邮件参数错误", min = 1, max = 2)
    private Integer hasCopyEmail;
    @Valid
    private List<ConditionBean> conditions;

    private String sourceAnchor;

    private String targetAnchor;

    private Integer hasCopyConfirm;

    public Integer getHasTransIscMessage() {
        return hasTransIscMessage;
    }

    public void setHasTransIscMessage(Integer hasTransIscMessage) {
        this.hasTransIscMessage = hasTransIscMessage;
    }

    public Integer getHasCopyIscMessage() {
        return hasCopyIscMessage;
    }

    public void setHasCopyIscMessage(Integer hasCopyIscMessage) {
        this.hasCopyIscMessage = hasCopyIscMessage;
    }

    public Integer getHasTransQixun() {
        return hasTransQixun;
    }

    public void setHasTransQixun(Integer hasTransQixun) {
        this.hasTransQixun = hasTransQixun;
    }

    public Integer getHasCopyQixun() {
        return hasCopyQixun;
    }

    public void setHasCopyQixun(Integer hasCopyQixun) {
        this.hasCopyQixun = hasCopyQixun;
    }

    public Integer getHasTransEmail() {
        return hasTransEmail;
    }

    public void setHasTransEmail(Integer hasTransEmail) {
        this.hasTransEmail = hasTransEmail;
    }

    public Integer getHasCopyEmail() {
        return hasCopyEmail;
    }

    public void setHasCopyEmail(Integer hasCopyEmail) {
        this.hasCopyEmail = hasCopyEmail;
    }

    public Long getLetterFlowNodeId() {
        return letterFlowNodeId;
    }

    public void setLetterFlowNodeId(Long letterFlowNodeId) {
        this.letterFlowNodeId = letterFlowNodeId;
    }

    public String getBtnName() {
        return btnName;
    }

    public void setBtnName(String btnName) {
        this.btnName = btnName;
    }

    public Integer getTransType() {
        return transType;
    }

    public void setTransType(Integer transType) {
        this.transType = transType;
    }

    public Integer getHasRadio() {
        return hasRadio;
    }

    public void setHasRadio(Integer hasRadio) {
        this.hasRadio = hasRadio;
    }

    public String getTransSysUserIds() {
        return transSysUserIds;
    }

    public void setTransSysUserIds(String transSysUserIds) {
        this.transSysUserIds = transSysUserIds;
    }

    public String getTransSysUserRoles() {
        return transSysUserRoles;
    }

    public void setTransSysUserRoles(String transSysUserRoles) {
        this.transSysUserRoles = transSysUserRoles;
    }

    public String getTransRobotIds() {
        return transRobotIds;
    }

    public void setTransRobotIds(String transRobotIds) {
        this.transRobotIds = transRobotIds;
    }

    public Integer getCopyType() {
        return copyType;
    }

    public void setCopyType(Integer copyType) {
        this.copyType = copyType;
    }

    public String getCopySysUserIds() {
        return copySysUserIds;
    }

    public void setCopySysUserIds(String copySysUserIds) {
        this.copySysUserIds = copySysUserIds;
    }

    public String getCopySysUserRoles() {
        return copySysUserRoles;
    }

    public void setCopySysUserRoles(String copySysUserRoles) {
        this.copySysUserRoles = copySysUserRoles;
    }

    public Integer getSignType() {
        return signType;
    }

    public void setSignType(Integer signType) {
        this.signType = signType;
    }

    public Integer getHasTransSms() {
        return hasTransSms;
    }

    public void setHasTransSms(Integer hasTransSms) {
        this.hasTransSms = hasTransSms;
    }

    public Integer getHasTransWxMessage() {
        return hasTransWxMessage;
    }

    public void setHasTransWxMessage(Integer hasTransWxMessage) {
        this.hasTransWxMessage = hasTransWxMessage;
    }

    public Integer getHasTransWxTaskcard() {
        return hasTransWxTaskcard;
    }

    public void setHasTransWxTaskcard(Integer hasTransWxTaskcard) {
        this.hasTransWxTaskcard = hasTransWxTaskcard;
    }

    public Integer getHasCopySms() {
        return hasCopySms;
    }

    public void setHasCopySms(Integer hasCopySms) {
        this.hasCopySms = hasCopySms;
    }

    public Integer getHasCopyWxMessage() {
        return hasCopyWxMessage;
    }

    public void setHasCopyWxMessage(Integer hasCopyWxMessage) {
        this.hasCopyWxMessage = hasCopyWxMessage;
    }

    public List<ConditionBean> getConditions() {
        return conditions;
    }

    public void setConditions(List<ConditionBean> conditions) {
        this.conditions = conditions;
    }

    public String getSourceAnchor() {
        return sourceAnchor;
    }

    public void setSourceAnchor(String sourceAnchor) {
        this.sourceAnchor = sourceAnchor;
    }

    public String getTargetAnchor() {
        return targetAnchor;
    }

    public void setTargetAnchor(String targetAnchor) {
        this.targetAnchor = targetAnchor;
    }

    public Integer getHasCopyConfirm() {
        return hasCopyConfirm;
    }

    public void setHasCopyConfirm(Integer hasCopyConfirm) {
        this.hasCopyConfirm = hasCopyConfirm;
    }
}
