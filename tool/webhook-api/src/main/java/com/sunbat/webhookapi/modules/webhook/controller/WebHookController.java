package com.sunbat.webhookapi.modules.webhook.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.alibaba.fastjson.JSONObject;
import com.sunbat.webhookapi.common.exception.AppException;
import com.sunbat.webhookapi.common.utils.Constant;
import com.sunbat.webhookapi.common.utils.R;
import com.sunbat.webhookapi.common.utils.RedisKeys;
import com.sunbat.webhookapi.common.utils.RedisUtils;
import com.sunbat.webhookapi.common.utils.ValidatorUtils;
import com.sunbat.webhookapi.modules.webhook.bean.LetterMessageInfoBean;
import com.sunbat.webhookapi.modules.webhook.bean.TransmitConfigBean;
import com.sunbat.webhookapi.modules.webhook.form.LetterRobotResultForm;
import com.sunbat.webhookapi.modules.webhook.form.LetterRobotTransmitForm;
import com.sunbat.webhookapi.modules.webhook.form.LetterWebhookRobotForm;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * 机器人webhook
 *
 * @author: SunYb
 * @date: 2024/6/12 15:58
 * @version: 1.0
 */
@RestController
@RequestMapping("/webhook")
public class WebHookController {
    Logger logger = LoggerFactory.getLogger(this.getClass());

    private final String ROBOT_AGREE_KEY = "97843171-acac-4a04-8e53-a724107cae64";
    private final String ROBOT_REJECT_KEY = "9bf92c51-2d32-4c82-83ba-e14756424867";
    private final String ROBOT_RETURN_KEY = "82bfc7cd-b105-479b-88a5-2a545eb80a84";


    @Autowired
    private RedisUtils redisUtils;

    /**
     * 机器人同意流程webhook
     *
     * @param request
     * @param form
     * @return
     */
    @PostMapping("/letters/robot_agree")
    public R lettersRobotAgree(HttpServletRequest request, @RequestBody LetterWebhookRobotForm form) {
        ValidatorUtils.validateEntity(form);
        String token = request.getHeader("X-OPS-Token");
        if (StringUtils.isEmpty(token)) {
            throw new AppException("token为空");
        }
        if (!ROBOT_AGREE_KEY.equals(token)) {
            throw new AppException("X-OPS-Token错误");
        }
        String event = request.getHeader("X-OPS-Event");
        if (!Constant.ROBOT_EVENT_KEY.equals(event)) {
            throw new AppException("X-OPS-Token错误");
        }

        LetterMessageInfoBean infoBean = new LetterMessageInfoBean();
        infoBean.setLetterType(Constant.LetterType.LETTER_AGREE.getValue());
        LetterRobotTransmitForm agreeForm = new LetterRobotTransmitForm();
        agreeForm.setLetterGuid(form.getLetterGuid());
        agreeForm.setAtNodeId(form.getNode().getLetterFlowNodeId());
        List<TransmitConfigBean> transmitConfigList = form.getTransmitConfigList();
        if (CollectionUtil.isNotEmpty(transmitConfigList)) {
            agreeForm.setLetterFlowNodeId(transmitConfigList.get(0).getLetterFlowNodeId());
        }
        agreeForm.setIdeaContent("机器人同意");
        agreeForm.setIdeaAttachments("https://pics7.baidu.com/feed/f3d3572c11dfa9ec63b6b68826abd00d908fc11b.jpeg@f_auto?token=a5b172543738b7e20905603a8e383d38");
        infoBean.setLetterContent(JSONObject.toJSON(agreeForm).toString());
        redisUtils.addToSet(RedisKeys.getLetterMessage(), JSONObject.toJSON(infoBean).toString());


        return R.ok().put("errcode", 0);
    }

    /**
     * 机器人拒绝流程webhook
     *
     * @param request
     * @param form
     * @return
     */
    @PostMapping("/letters/robot_reject")
    public R lettersRobotReject(HttpServletRequest request, @RequestBody LetterWebhookRobotForm form) {

        ValidatorUtils.validateEntity(form);
        String token = request.getHeader("X-OPS-Token");
        if (StringUtils.isEmpty(token)) {
            throw new AppException("token为空");
        }
        if (!ROBOT_REJECT_KEY.equals(token)) {
            throw new AppException("X-OPS-Token错误");
        }
        String event = request.getHeader("X-OPS-Event");
        if (!Constant.ROBOT_EVENT_KEY.equals(event)) {
            throw new AppException("X-OPS-Token错误");
        }

        LetterMessageInfoBean infoBean = new LetterMessageInfoBean();
        infoBean.setLetterType(Constant.LetterType.LETTER_REJECT.getValue());
        LetterRobotResultForm rejectForm = new LetterRobotResultForm();
        rejectForm.setLetterGuid(form.getLetterGuid());
        rejectForm.setAtNodeId(form.getNode().getLetterFlowNodeId());
        rejectForm.setIdeaContent("机器人拒绝");
        rejectForm.setIdeaAttachments("https://pics7.baidu.com/feed/f3d3572c11dfa9ec63b6b68826abd00d908fc11b.jpeg@f_auto?token=a5b172543738b7e20905603a8e383d38");
        infoBean.setLetterContent(JSONObject.toJSON(rejectForm).toString());
        redisUtils.addToSet(RedisKeys.getLetterMessage(), JSONObject.toJSON(infoBean).toString());


        return R.ok().put("errcode", 0);
    }

    /**
     * 机器人退回上一步流程webhook
     *
     * @param request
     * @param form
     * @return
     */
    @PostMapping("/letters/robot_return")
    public R lettersRobotReturn(HttpServletRequest request, @RequestBody LetterWebhookRobotForm form) {

        ValidatorUtils.validateEntity(form);
        String token = request.getHeader("X-OPS-Token");
        if (StringUtils.isEmpty(token)) {
            throw new AppException("token为空");
        }
        if (!ROBOT_RETURN_KEY.equals(token)) {
            throw new AppException("X-OPS-Token错误");
        }
        String event = request.getHeader("X-OPS-Event");
        if (!Constant.ROBOT_EVENT_KEY.equals(event)) {
            throw new AppException("X-OPS-Token错误");
        }

        LetterMessageInfoBean infoBean = new LetterMessageInfoBean();
        infoBean.setLetterType(Constant.LetterType.LETTER_RETURN.getValue());

        LetterRobotResultForm returnForm = new LetterRobotResultForm();
        returnForm.setLetterGuid(form.getLetterGuid());
        returnForm.setAtNodeId(form.getNode().getLetterFlowNodeId());
        returnForm.setIdeaContent("机器人退回");
        returnForm.setIdeaAttachments("https://pics7.baidu.com/feed/f3d3572c11dfa9ec63b6b68826abd00d908fc11b.jpeg@f_auto?token=a5b172543738b7e20905603a8e383d38");
        infoBean.setLetterContent(JSONObject.toJSON(returnForm).toString());
        redisUtils.addToSet(RedisKeys.getLetterMessage(), JSONObject.toJSON(infoBean).toString());

        return R.ok().put("errcode", 0);
    }


}