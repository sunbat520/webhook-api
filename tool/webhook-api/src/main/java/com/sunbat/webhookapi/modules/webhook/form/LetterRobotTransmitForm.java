package com.sunbat.webhookapi.modules.webhook.form;

/**
 * 流程同意入参
 * @author: SunYb
 * @date: 2024/6/12 16:55
 * @version: 1.0
 */
public class LetterRobotTransmitForm extends LetterRobotAbstractForm{

    /**
     * 要传递节点的ID
     */
    private Long letterFlowNodeId;

    /**
     * 意见
     */
    private String ideaContent;

    /**
     * 审批意见的附件
     */
    private String ideaAttachments;

    public Long getLetterFlowNodeId() {
        return letterFlowNodeId;
    }

    public void setLetterFlowNodeId(Long letterFlowNodeId) {
        this.letterFlowNodeId = letterFlowNodeId;
    }

    public String getIdeaContent() {
        return ideaContent;
    }

    public void setIdeaContent(String ideaContent) {
        this.ideaContent = ideaContent;
    }

    public String getIdeaAttachments() {
        return ideaAttachments;
    }

    public void setIdeaAttachments(String ideaAttachments) {
        this.ideaAttachments = ideaAttachments;
    }
}
