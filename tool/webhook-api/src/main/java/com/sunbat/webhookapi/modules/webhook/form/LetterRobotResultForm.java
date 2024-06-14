package com.sunbat.webhookapi.modules.webhook.form;

import org.hibernate.validator.constraints.Length;

/**
 * 流程退回上一步入参
 *
 * @author: SunYb
 * @date: 2024/6/12 16:55
 * @version: 1.0
 */
public class LetterRobotResultForm extends LetterRobotAbstractForm {

    @Length(max = 200, message = "意见内容字符长度范围：0~200")
    private String ideaContent;

    /**
     * 审批意见的附件
     */
    @Length(max = 50000, message = "富文本内容字符长度范围：0~20000")
    private String ideaAttachments;

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
