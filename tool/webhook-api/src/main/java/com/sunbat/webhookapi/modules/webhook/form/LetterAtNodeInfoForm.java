package com.sunbat.webhookapi.modules.webhook.form;

/**
 * @author: SunYb
 * @date: 2024/6/12 16:19
 * @version: 1.0
 */
public class LetterAtNodeInfoForm {
    /**
     * 节点ID
     */
    private Long letterFlowNodeId;
    /**
     * 节点名称
     */
    private String nodeName;
    /**
     * 记录ID
     */
    private Long letterLogId;
    /**
     * 日志类型
     */
    private Integer logType;
    /**
     * 签批类型
     */
    private Integer signType;
    /**
     * 处理人ID
     */
    private Long handlerId;
    /**
     * 处理人
     */
    private String handlerName;

    public Long getLetterFlowNodeId() {
        return letterFlowNodeId;
    }

    public void setLetterFlowNodeId(Long letterFlowNodeId) {
        this.letterFlowNodeId = letterFlowNodeId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName;
    }

    public Long getLetterLogId() {
        return letterLogId;
    }

    public void setLetterLogId(Long letterLogId) {
        this.letterLogId = letterLogId;
    }

    public Integer getLogType() {
        return logType;
    }

    public void setLogType(Integer logType) {
        this.logType = logType;
    }

    public Integer getSignType() {
        return signType;
    }

    public void setSignType(Integer signType) {
        this.signType = signType;
    }

    public Long getHandlerId() {
        return handlerId;
    }

    public void setHandlerId(Long handlerId) {
        this.handlerId = handlerId;
    }

    public String getHandlerName() {
        return handlerName;
    }

    public void setHandlerName(String handlerName) {
        this.handlerName = handlerName;
    }
}
