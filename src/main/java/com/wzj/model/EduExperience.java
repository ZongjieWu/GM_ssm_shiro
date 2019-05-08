package com.wzj.model;

import javax.persistence.*;

@Table(name = "edu_experience")
public class EduExperience {
    /**
     * 教育经历
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 用户简历id
     */
    @Column(name = "user_resume_id")
    private Long userResumeId;

    /**
     * 开始时间
     */
    @Column(name="start_time")
    private String startTime;

    /**
     * 结束时间
     */
    @Column(name="end_time")
    private String endTime;

    /**
     * 名称
     */
    private String name;

    /**
     * 学历
     */
    @Column(name = "edu_background")
    private String eduBackground;

    /**
     * 专业
     */
    private String major;

    /**
     * 备注
     */
    private String remark;

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
     * 获取教育经历
     *
     * @return id - 教育经历
     */
    public Long getId() {
        return id;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 设置教育经历
     *
     * @param id 教育经历
     */
    public void setId(Long id) {
        this.id = id;
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





    /**
     * 获取名称
     *
     * @return name - 名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置名称
     *
     * @param name 名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取学历
     *
     * @return edu_background - 学历
     */
    public String getEduBackground() {
        return eduBackground;
    }

    /**
     * 设置学历
     *
     * @param eduBackground 学历
     */
    public void setEduBackground(String eduBackground) {
        this.eduBackground = eduBackground;
    }

    /**
     * 获取专业
     *
     * @return major - 专业
     */
    public String getMajor() {
        return major;
    }

    /**
     * 设置专业
     *
     * @param major 专业
     */
    public void setMajor(String major) {
        this.major = major;
    }

    /**
     * 获取备注
     *
     * @return remark - 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 设置备注
     *
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark;
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

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}