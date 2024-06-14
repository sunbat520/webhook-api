package com.sunbat.webhookapi.modules.webhook.bean;

/**
 * @author: SunYb
 * @date: 2024/6/12 16:25
 * @version: 1.0
 */
public class AppOrderRecycleHostInfoBean {
    /**
     * 主机ID
     */
    private Long hostId;
    /**
     * 主机Guid
     */
    private String hostGuid;
    /**
     * 主机类型
     */
    private Integer hostType;
    /**
     * 主机名称
     */
    private String hostName;
    /**
     * 数据中心
     */
    private String dataCenter;
    /**
     * 区域
     */
    private String region;
    /**
     * 管理IP
     */
    private String mgtIp;

    public Long getHostId() {
        return hostId;
    }

    public void setHostId(Long hostId) {
        this.hostId = hostId;
    }

    public String getHostGuid() {
        return hostGuid;
    }

    public void setHostGuid(String hostGuid) {
        this.hostGuid = hostGuid;
    }

    public Integer getHostType() {
        return hostType;
    }

    public void setHostType(Integer hostType) {
        this.hostType = hostType;
    }

    public String getHostName() {
        return hostName;
    }

    public void setHostName(String hostName) {
        this.hostName = hostName;
    }

    public String getDataCenter() {
        return dataCenter;
    }

    public void setDataCenter(String dataCenter) {
        this.dataCenter = dataCenter;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getMgtIp() {
        return mgtIp;
    }

    public void setMgtIp(String mgtIp) {
        this.mgtIp = mgtIp;
    }
}
