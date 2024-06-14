package com.sunbat.webhookapi.modules.job.task;

import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sunbat.webhookapi.common.exception.AppException;
import com.sunbat.webhookapi.common.utils.Constant;
import com.sunbat.webhookapi.common.utils.R;
import com.sunbat.webhookapi.common.utils.RedisKeys;
import com.sunbat.webhookapi.common.utils.RedisUtils;
import com.sunbat.webhookapi.modules.webhook.bean.LetterMessageInfoBean;
import com.sunbat.webhookapi.modules.webhook.form.LetterRobotAbstractForm;
import com.sunbat.webhookapi.modules.webhook.form.LetterRobotResultForm;
import com.sunbat.webhookapi.modules.webhook.form.LetterRobotTransmitForm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author: SunYb
 * @date: 2024/6/13 17:34
 * @version: 1.0
 */
@Component
public class ScheduledTasks {

    private static final Logger logger = LoggerFactory.getLogger(ScheduledTasks.class);

    @Autowired
    private RedisUtils redisUtils;

    @Scheduled(cron = "0/30 * * * * ?")
    public void reportCurrentTime() {
        logger.info("定时任务执行：当前时间是 {}", java.time.LocalDateTime.now());
        // 获取set中的所有元素
        Iterable<String> members = redisUtils.getMembersOfSet(RedisKeys.getLetterMessage());
        members.forEach(e -> {
            LetterMessageInfoBean info = JSON.toJavaObject(JSONObject.parseObject(e), LetterMessageInfoBean.class);
            Integer letterType = info.getLetterType();
            String letterInfo = info.getLetterContent();
            if (Constant.LetterType.LETTER_REJECT.getValue().equals(letterType)) {
                String webhookUrl = "http://127.0.0.1:8087/bpm/letters/robot_reject";
                String webhookToken = "9bf92c51-2d32-4c82-83ba-e14756424867";
                LetterRobotResultForm rejectForm = JSON.toJavaObject(JSONObject.parseObject(letterInfo), LetterRobotResultForm.class);
                R r = sendOpsRobtWebhookApi(webhookUrl, webhookToken, rejectForm);
                if (r.get("code").equals(0)) {
                    // 从set中移除元素
                    redisUtils.removeFromSet(RedisKeys.getLetterMessage(), e);
                }
            }
            if (Constant.LetterType.LETTER_AGREE.getValue().equals(letterType)) {

                String webhookUrl = "http://127.0.0.1:8087/bpm/letters/robot_agree";
                String webhookToken = "97843171-acac-4a04-8e53-a724107cae64";
                LetterRobotTransmitForm agreeForm = JSON.toJavaObject(JSONObject.parseObject(letterInfo), LetterRobotTransmitForm.class);
                R r = sendOpsRobtWebhookApi(webhookUrl, webhookToken, agreeForm);
                if (r.get("code").equals(0)) {
                    // 从set中移除元素
                    redisUtils.removeFromSet(RedisKeys.getLetterMessage(), e);
                }
            }
            if (Constant.LetterType.LETTER_RETURN.getValue().equals(letterType)) {
                String webhookUrl = "http://127.0.0.1:8087/bpm/letters/robot_sendback";
                String webhookToken = "82bfc7cd-b105-479b-88a5-2a545eb80a84";
                LetterRobotResultForm returnForm = JSON.toJavaObject(JSONObject.parseObject(letterInfo), LetterRobotResultForm.class);
                R r = sendOpsRobtWebhookApi(webhookUrl, webhookToken, returnForm);
                if (r.get("code").equals(0)) {
                    // 从set中移除元素
                    redisUtils.removeFromSet(RedisKeys.getLetterMessage(), e);
                }
            }
        });

    }


    private R sendOpsRobtWebhookApi(String webhookUrl, String webhookToken, LetterRobotAbstractForm form) {
        logger.info("----------------------- thread start :" + new Date());
        HttpResponse httpResponse = null;
        try {
            httpResponse = HttpUtil.createPost(webhookUrl).header("X-OPS-Token", webhookToken).body(JSONObject.toJSON(form).toString()).execute();
        } catch (Exception e) {
            logger.error("请求OPS平台接口异常：", e);
            throw new AppException("请求OPS平台接口异常");
        }
        JSONObject jsonObject = JSONObject.parseObject(httpResponse.body());

        logger.info(jsonObject.toString());

        return JSON.toJavaObject(jsonObject, R.class);

    }
}
