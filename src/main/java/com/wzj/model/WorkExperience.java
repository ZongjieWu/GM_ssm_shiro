package com.wzj.model;

import javax.persistence.*;

@Table(name = "work_experience")
public class WorkExperience {
    /**
     * 工作经验
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
     * 企业名称
     */
    @Column(name = "enterprise_name")
    private String enterpriseName;

    /**
     * 企业类型id
     */
    @Column(name = "enterprise_type_id")
    private Long enterpriseTypeId;

    /**
     * 开始时间
     */
    @Column(name = "start_time")
    private String startTime;

    /**
     * 结束时间
     */
    @Column(name = "end_time")
    private String endTime;

    /**
     * 职位类型
     */
    @Column(name = "job_type")
    private Long jobType;

    /**
     * 职位名称
     */
    @Column(name = "job_name")
    private String jobName;

    /**
     * 部门
     */
    private String department;

    /**
     * 工作内容
     */
    @Column(name = "work_content")
    private String workContent;

    /**
     * 工作业绩
     */
    private String performance;

    /**
     * 技能
     */
    private String skill;

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
     * 结束时间
     */
    @Column(name = "modify_time")
    private String modifyTime;

    /**
     * 获取工作经验
     *
     * @return id - 工作经验
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置工作经验
     *
     * @param id 工作经验
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

    public String getEnterpriseName() {
        return enterpriseName;
    }

    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public Long getEnterpriseTypeId() {
        return enterpriseTypeId;
    }

    public void setEnterpriseTypeId(Long enterpriseTypeId) {
        this.enterpriseTypeId = enterpriseTypeId;
    }

    /**
     * 获取开始时间
     *
     * @return start_time - 开始时间
     */
    public String getStartTime() {
        return startTime;
    }

    /**
     * 设置开始时间
     *
     * @param startTime 开始时间
     */
    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    /**
     * 获取结束时间
     *
     * @return end_time - 结束时间
     */
    public String getEndTime() {
        return endTime;
    }

    /**
     * 设置结束时间
     *
     * @param endTime 结束时间
     */
    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    /**
     * 获取职位类型
     *
     * @return job_type - 职位类型
     */
    public Long getJobType() {
        return jobType;
    }

    /**
     * 设置职位类型
     *
     * @param jobType 职位类型
     */
    public void setJobType(Long jobType) {
        this.jobType = jobType;
    }

    /**
     * 获取职位名称
     *
     * @return job_name - 职位名称
     */
    public String getJobName() {
        return jobName;
    }

    /**
     * 设置职位名称
     *
     * @param jobName 职位名称
     */
    public void setJobName(String jobName) {
        this.jobName = jobName;
    }

    /**
     * 获取部门
     *
     * @return department - 部门
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 设置部门
     *
     * @param department 部门
     */
    public void setDepartment(String department) {
        this.department = department;
    }

    /**
     * 获取工作内容
     *
     * @return work_content - 工作内容
     */
    public String getWorkContent() {
        return workContent;
    }

    /**
     * 设置工作内容
     *
     * @param workContent 工作内容
     */
    public void setWorkContent(String workContent) {
        this.workContent = workContent;
    }

    /**
     * 获取工作业绩
     *
     * @return performance - 工作业绩
     */
    public String getPerformance() {
        return performance;
    }

    /**
     * 设置工作业绩
     *
     * @param performance 工作业绩
     */
    public void setPerformance(String performance) {
        this.performance = performance;
    }

    /**
     * 获取技能
     *
     * @return skill - 技能
     */
    public String getSkill() {
        return skill;
    }

    /**
     * 设置技能
     *
     * @param skill 技能
     */
    public void setSkill(String skill) {
        this.skill = skill;
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

    /**
     * 获取结束时间
     *
     * @return modify_time - 结束时间
     */
    public String getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置结束时间
     *
     * @param modifyTime 结束时间
     */
    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }
}