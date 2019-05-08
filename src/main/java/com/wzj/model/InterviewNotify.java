package com.wzj.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel("面试通知")
@Table(name = "interview_notify")
public class InterviewNotify {
    /**
     * 面试通知
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("面试通知")
    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    @Column(name = "user_id")
    private Long userId;

    /**
     * 职位id
     */
    @ApiModelProperty("职位id")
    @Column(name = "issue_job_id")
    private Long issueJobId;

    /**
     * 职位名称
     */
    @ApiModelProperty("职位名称")
    @Column(name = "job_name")
    private String jobName;

    /**
     * 公司名称
     */
    @ApiModelProperty("公司名称")
    @Column(name = "enterprise_name")
    private String enterpriseName;

    /**
     * 通知内容
     */
    @ApiModelProperty("通知内容")
    private String content;

    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")
    @Column(name = "concat_phone")
    private String concatPhone;

    /**
     * 面试时间
     */
    @ApiModelProperty("面试时间")
    @Column(name = "interview_time")
    private String interviewTime;
    /**
     * 面试时间
     */
    @ApiModelProperty("面试时间")
    @Column(name = "status")
    private Integer status;

    /**
     * 添加时间
     */
    @ApiModelProperty("添加时间")
    @Column(name = "add_time")
    private String addTime;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @Column(name = "modify_time")
    private String modifyTime;

    /**
     * 获取面试通知
     *
     * @return id - 面试通知
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置面试通知
     *
     * @param id 面试通知
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取用户id
     *
     * @return user_id - 用户id
     */
    public Long getUserId() {
        return userId;
    }

    /**
     * 设置用户id
     *
     * @param userId 用户id
     */
    public void setUserId(Long userId) {
        this.userId = userId;
    }

    /**
     * 获取职位id
     *
     * @return issue_job_id - 职位id
     */
    public Long getIssueJobId() {
        return issueJobId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 设置职位id
     *
     * @param issueJobId 职位id
     */
    public void setIssueJobId(Long issueJobId) {
        this.issueJobId = issueJobId;
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
     * 获取公司名称
     *
     * @return enterprise_name - 公司名称
     */
    public String getEnterpriseName() {
        return enterpriseName;
    }

    /**
     * 设置公司名称
     *
     * @param enterpriseName 公司名称
     */
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    /**
     * 获取通知内容
     *
     * @return content - 通知内容
     */
    public String getContent() {
        return content;
    }

    /**
     * 设置通知内容
     *
     * @param content 通知内容
     */
    public void setContent(String content) {
        this.content = content;
    }

    /**
     * 获取联系电话
     *
     * @return concat_phone - 联系电话
     */
    public String getConcatPhone() {
        return concatPhone;
    }

    /**
     * 设置联系电话
     *
     * @param concatPhone 联系电话
     */
    public void setConcatPhone(String concatPhone) {
        this.concatPhone = concatPhone;
    }

    /**
     * 获取面试时间
     *
     * @return interview_time - 面试时间
     */
    public String getInterviewTime() {
        return interviewTime;
    }

    /**
     * 设置面试时间
     *
     * @param interviewTime 面试时间
     */
    public void setInterviewTime(String interviewTime) {
        this.interviewTime = interviewTime;
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