package com.wzj.model;

import javax.persistence.*;

@Table(name = "send_resume")
public class SendResume {
    /**
     * 投递简历
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    /**
     * 用户id
     */
    @Column(name = "uid")
    private Long uid;

    /**
     * 公司id
     */
    @Column(name = "issue_job_id")
    private Long issueJobId;

    /**
     * 用户简历id
     */
    @Column(name = "user_resume_id")
    private Long userResumeId;

    /**
     * 0未查看1已查看2发送邀请3不合适
     */
    private Integer status;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private String addTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private String modifyTime;

    /**
     * 获取投递简历
     *
     * @return id - 投递简历
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置投递简历
     *
     * @param id 投递简历
     */
    public void setId(Long id) {
        this.id = id;
    }

    public Long getIssueJobId() {
        return issueJobId;
    }

    public void setIssueJobId(Long issueJobId) {
        this.issueJobId = issueJobId;
    }

    /**
     * 获取用户简历id
     *
     * @return user_resume_id - 用户简历id
     */
    public Long getUserResumeId() {
        return userResumeId;
    }

    /**
     * 设置用户简历id
     *
     * @param userResumeId 用户简历id
     */
    public void setUserResumeId(Long userResumeId) {
        this.userResumeId = userResumeId;
    }

    public Long getUid() {
        return uid;
    }

    public void setUid(Long uid) {
        this.uid = uid;
    }

    /**
     * 获取0未查看1已查看2发送邀请3不合适
     *
     * @return status - 0未查看1已查看2发送邀请3不合适
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0未查看1已查看2发送邀请3不合适
     *
     * @param status 0未查看1已查看2发送邀请3不合适
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public String getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(String addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public String getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}