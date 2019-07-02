package com.wzj.model;

import javax.persistence.*;

public class Sessions {
    /**
     * session表
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "session_id")
    private String sessionId;

    private String session;

    @Column(name = "add_time")
    private String addTime;

    @Column(name = "modify_time")
    private String modifyTime;

    /**
     * 获取session表
     *
     * @return id - session表
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置session表
     *
     * @param id session表
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return session_id
     */
    public String getSessionId() {
        return sessionId;
    }

    /**
     * @param sessionId
     */
    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    /**
     * @return session
     */
    public String getSession() {
        return session;
    }

    /**
     * @param session
     */
    public void setSession(String session) {
        this.session = session;
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