package com.sunbat.webhookapi.modules.webhook.form;

import javax.validation.constraints.NotNull;

/**
 * 流程信息基类
 * @author: SunYb
 * @date: 2024/6/12 16:59
 * @version: 1.0
 */
public class LetterRobotAbstractForm {

    /**
     * 流程Guid
     */
    @NotNull(message = "流程Guid不能为null")
    private String letterGuid;

    /**
     * 流程当前节点id
     */
    @NotNull(message = "流程当前节点不能为null")
    private Long atNodeId;


    public String getLetterGuid() {
        return letterGuid;
    }

    public void setLetterGuid(String letterGuid) {
        this.letterGuid = letterGuid;
    }

    public Long getAtNodeId() {
        return atNodeId;
    }

    public void setAtNodeId(Long atNodeId) {
        this.atNodeId = atNodeId;
    }
}
