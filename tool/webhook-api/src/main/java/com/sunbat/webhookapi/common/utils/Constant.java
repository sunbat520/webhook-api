package com.sunbat.webhookapi.common.utils;

/**
 * 全局字典
 *
 * @author: SunYb
 * @date: 2024/6/13 16:21
 * @version: 1.0
 */
public class Constant {

    public static final String ROBOT_EVENT_KEY = "Robot";

    /**
     * 流程类型
     *
     * @author: SunYb
     * @date: 2024/6/13 16:21
     * @version: 1.0
     */
    public enum LetterType {
        /**
         * 流程拒绝
         */
        LETTER_REJECT(1),
        /**
         * 流程同意
         */
        LETTER_AGREE(2),

        /**
         * 流程退回
         */
        LETTER_RETURN(3);

        private Integer value;

        LetterType(Integer value) {
            this.value = value;
        }

        public Integer getValue() {
            return value;
        }
    }
}
