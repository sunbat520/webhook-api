package com.sunbat.webhookapi.modules.webhook.bean;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author: SunYb
 * @date: 2024/6/12 16:27
 * @version: 1.0
 */
public class ConditionBean {
    @NotBlank(message = "运算符不可为空")
    private String centerFields;

    private String conditionOperator;

    @NotBlank(message = "运算符左侧字段不可为空")
    private String leftFields;

    @NotBlank(message = "运算符左侧字段名不可为空")
    private String leftFieldsName;

    @NotNull(message = "运算符右侧字段数组不可为空")
    @Size(min = 1, message = "运算符右侧字段数组不可为空")
    private List<String> rightFields;

    @NotNull(message = "运算符右侧字段名数组不可为空")
    @Size(min = 1, message = "运算符右侧字段名数组不可为空")
    private List<String> rightFieldsName;

    public String getCenterFields() {
        return centerFields;
    }

    public void setCenterFields(String centerFields) {
        this.centerFields = centerFields;
    }

    public String getConditionOperator() {
        return conditionOperator;
    }

    public void setConditionOperator(String conditionOperator) {
        this.conditionOperator = conditionOperator;
    }

    public String getLeftFields() {
        return leftFields;
    }

    public void setLeftFields(String leftFields) {
        this.leftFields = leftFields;
    }

    public String getLeftFieldsName() {
        return leftFieldsName;
    }

    public void setLeftFieldsName(String leftFieldsName) {
        this.leftFieldsName = leftFieldsName;
    }

    public List<String> getRightFields() {
        return rightFields;
    }

    public void setRightFields(List<String> rightFields) {
        this.rightFields = rightFields;
    }

    public List<String> getRightFieldsName() {
        return rightFieldsName;
    }

    public void setRightFieldsName(List<String> rightFieldsName) {
        this.rightFieldsName = rightFieldsName;
    }
}
