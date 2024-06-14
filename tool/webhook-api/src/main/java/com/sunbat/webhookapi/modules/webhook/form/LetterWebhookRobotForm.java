package com.sunbat.webhookapi.modules.webhook.form;

import com.sunbat.webhookapi.modules.webhook.bean.AppOrderRecycleHostInfoBean;
import com.sunbat.webhookapi.modules.webhook.bean.TransmitConfigBean;

import java.util.List;

/**
 * @author: SunYb
 * @date: 2024/6/12 16:23
 * @version: 1.0
 */
public class LetterWebhookRobotForm extends LetterWebhookInfoForm {
    /**
     * 传递配置
     */
    private List<TransmitConfigBean> transmitConfigList;

    private List<AppOrderRecycleHostInfoBean> appOrderRecycleHosts;

    public List<TransmitConfigBean> getTransmitConfigList() {
        return transmitConfigList;
    }

    public void setTransmitConfigList(List<TransmitConfigBean> transmitConfigList) {
        this.transmitConfigList = transmitConfigList;
    }

    public List<AppOrderRecycleHostInfoBean> getAppOrderRecycleHosts() {
        return appOrderRecycleHosts;
    }

    public void setAppOrderRecycleHosts(List<AppOrderRecycleHostInfoBean> appOrderRecycleHosts) {
        this.appOrderRecycleHosts = appOrderRecycleHosts;
    }
}
