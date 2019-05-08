package com.wzj.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel("发布职位")
@Table(name = "issue_job")
public class IssueJob {
    /**
     * 发布招聘
     */
    @ApiModelProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 企业logo
     */
    @ApiModelProperty("企业logo")
    @Column(name = "enterprise_logo")
    private String enterpriseLogo;
    /**
     * 企业id
     */
    @ApiModelProperty("企业id")
    @Column(name = "enterprise_id")
    private Long enterpriseId;

    /**
     * 企业名称
     */
    @ApiModelProperty("企业名称")
    @Column(name = "enterprise_name")
    private String enterpriseName;

    /**
     * 联系人
     */
    @ApiModelProperty("联系人")
    @Column(name = "contact_name")
    private String contactName;

    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")
    @Column(name = "contact_phone")
    private String contactPhone;

    /**
     * 联系微信
     */
    @ApiModelProperty("联系微信")
    @Column(name = "contact_wechat")
    private String contactWechat;

    /**
     * 联系qq
     */
    @ApiModelProperty("联系qq")
    @Column(name = "contact_qq")
    private String contactQq;

    /**
     * 联系邮箱
     */
    @ApiModelProperty("联系邮箱")
    @Column(name = "contact_email")
    private String contactEmail;

    /**
     * 职位名称
     */
    @ApiModelProperty("职位名称")
    @Column(name = "job_name")
    private String jobName;

    /**
     * 职业工资
     */
    @ApiModelProperty("职业工资")
    @Column(name = "job_money")
    private String jobMoney;

    /**
     * 工作地点
     */
    @ApiModelProperty("工作地点")
    @Column(name = "work_place")
    private String workPlace;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private String age;

    /**
     * 工龄
     */
    @ApiModelProperty("工龄")
    @Column(name = "work_age")
    private String workAge;

    /**
     * 学历
     */
    @ApiModelProperty("学历")
    private String edu;

    /**
     * 职位详情
     */
    @ApiModelProperty("职位详情")
    @Column(name = "job_detail")
    private String jobDetail;

    /**
     * 职业技能
     */
    @ApiModelProperty("职业技能")
    private String skill;

    /**
     * 备注
     */
    @ApiModelProperty("备注")
    private String remark;

    /**
     * 状态0开启(在招)1开启(急招)2停招
     */
    @ApiModelProperty("状态0开启(在招)1开启(急招)2停招")
    private Integer status;

    /**
     * 添加时间
     */
    @ApiModelProperty("添加时间")
    @Column(name = "add_time")
    private String addTime;

    /**
     * 结束时间
     */
    @ApiModelProperty("结束时间")
    @Column(name = "modify_time")
    private String modifyTime;

    /**
     * 获取发布招聘
     *
     * @return id - 发布招聘
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置发布招聘
     *
     * @param id 发布招聘
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getEnterpriseLogo() {
        return enterpriseLogo;
    }

    public void setEnterpriseLogo(String enterpriseLogo) {
        this.enterpriseLogo = enterpriseLogo;
    }

    /**
     * 获取企业id
     *
     * @return enterprise_id - 企业id
     */
    public Long getEnterpriseId() {
        return enterpriseId;
    }

    /**
     * 设置企业id
     *
     * @param enterpriseId 企业id
     */
    public void setEnterpriseId(Long enterpriseId) {
        this.enterpriseId = enterpriseId;
    }

    /**
     * 获取企业名称
     *
     * @return enterprise_name - 企业名称
     */
    public String getEnterpriseName() {
        return enterpriseName;
    }

    /**
     * 设置企业名称
     *
     * @param enterpriseName 企业名称
     */
    public void setEnterpriseName(String enterpriseName) {
        this.enterpriseName = enterpriseName;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    /**
     * 获取联系人
     *
     * @return contact_name - 联系人
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * 设置联系人
     *
     * @param contactName 联系人
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * 获取联系电话
     *
     * @return contact_phone - 联系电话
     */
    public String getContactPhone() {
        return contactPhone;
    }

    /**
     * 设置联系电话
     *
     * @param contactPhone 联系电话
     */
    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }

    /**
     * 获取联系微信
     *
     * @return contact_wechat - 联系微信
     */
    public String getContactWechat() {
        return contactWechat;
    }

    /**
     * 设置联系微信
     *
     * @param contactWechat 联系微信
     */
    public void setContactWechat(String contactWechat) {
        this.contactWechat = contactWechat;
    }

    /**
     * 获取联系qq
     *
     * @return contact_qq - 联系qq
     */
    public String getContactQq() {
        return contactQq;
    }

    /**
     * 设置联系qq
     *
     * @param contactQq 联系qq
     */
    public void setContactQq(String contactQq) {
        this.contactQq = contactQq;
    }

    /**
     * 获取联系邮箱
     *
     * @return contact_email - 联系邮箱
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * 设置联系邮箱
     *
     * @param contactEmail 联系邮箱
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
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
     * 获取职业工资
     *
     * @return job_money - 职业工资
     */
    public String getJobMoney() {
        return jobMoney;
    }

    /**
     * 设置职业工资
     *
     * @param jobMoney 职业工资
     */
    public void setJobMoney(String jobMoney) {
        this.jobMoney = jobMoney;
    }

    /**
     * 获取工作地点
     *
     * @return work_place - 工作地点
     */
    public String getWorkPlace() {
        return workPlace;
    }

    /**
     * 设置工作地点
     *
     * @param workPlace 工作地点
     */
    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }


    /**
     * 获取工龄
     *
     * @return work_age - 工龄
     */
    public String getWorkAge() {
        return workAge;
    }


    /**
     * 设置工龄
     *
     * @param workAge 工龄
     */
    public void setWorkAge(String workAge) {
        this.workAge = workAge;
    }

    /**
     * 获取学历
     *
     * @return edu - 学历
     */
    public String getEdu() {
        return edu;
    }

    /**
     * 设置学历
     *
     * @param edu 学历
     */
    public void setEdu(String edu) {
        this.edu = edu;
    }

    /**
     * 获取职位详情
     *
     * @return job_detail - 职位详情
     */
    public String getJobDetail() {
        return jobDetail;
    }

    /**
     * 设置职位详情
     *
     * @param jobDetail 职位详情
     */
    public void setJobDetail(String jobDetail) {
        this.jobDetail = jobDetail;
    }

    /**
     * 获取职业技能
     *
     * @return skill - 职业技能
     */
    public String getSkill() {
        return skill;
    }

    /**
     * 设置职业技能
     *
     * @param skill 职业技能
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
     * 获取状态0开启(在招)1开启(急招)2停招
     *
     * @return status - 状态0开启(在招)1开启(急招)2停招
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置状态0开启(在招)1开启(急招)2停招
     *
     * @param status 状态0开启(在招)1开启(急招)2停招
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