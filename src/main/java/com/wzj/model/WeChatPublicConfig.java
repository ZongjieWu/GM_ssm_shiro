package com.wzj.model;

import javax.persistence.*;

@Table(name = "we_chat_public_config")
public class WeChatPublicConfig {
    /**
     * 公众号相关参数设置
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "app_id")
    private String appId;

    @Column(name = "app_secret")
    private String appSecret;

    /**
     * 访问令牌2小时要刷新一次
     */
    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "add_time")
    private String addTime;

    @Column(name = "modify_time")
    private String modifyTime;

    /**
     * 获取公众号相关参数设置
     *
     * @return id - 公众号相关参数设置
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置公众号相关参数设置
     *
     * @param id 公众号相关参数设置
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return app_id
     */
    public String getAppId() {
        return appId;
    }

    /**
     * @param appId
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    /**
     * @return app_secret
     */
    public String getAppSecret() {
        return appSecret;
    }

    /**
     * @param appSecret
     */
    public void setAppSecret(String appSecret) {
        this.appSecret = appSecret;
    }

    /**
     * 获取访问令牌2小时要刷新一次
     *
     * @return access_token - 访问令牌2小时要刷新一次
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * 设置访问令牌2小时要刷新一次
     *
     * @param accessToken 访问令牌2小时要刷新一次
     */
    public void setAccessToken(String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * @return add_time
     */
    public String getAddTime() {
        return addTime;
    }

    /**
     * @param addTime
     */
    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    /**
     * @return modify_time
     */
    public String getModifyTime() {
        return modifyTime;
    }

    /**
     * @param modifyTime
     */
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}