package com.wzj.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import java.util.List;

@ApiModel("用户简历")
@Table(name = "user_resume")
public class UserResume {
    /**
     * 简历
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("ID")
    private Long id;

    /**
     * 用户id
     */
    @ApiModelProperty("用户id")
    @Column(name = "user_id")
    private Long userId;

    /**
     * 用户头像
     */
    @ApiModelProperty("用户头像")
    @Column(name = "head_img")
    private String headImg;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 性别0男1女
     */
    @ApiModelProperty("性别0男1女")
    private Integer sex;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;

    /**
     * 工龄
     */
    @ApiModelProperty("工龄")
    @Column(name = "work_age")
    private String workAge;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * qq
     * */
    private String qq;

    /**
     * 微信
     * */
    @Column(name = "we_chat")
    private String weChat;


    /**
     * 期望工资
     */
    @ApiModelProperty("期望工资")
    @Column(name = "expect_money")
    private String expectMoney;

    /**
     * 电话
     */
    @ApiModelProperty("电话")
    private String phone;

    /**
     * 求职状态0(离职-随时到岗)1(在职-月内到岗)2(在职-考虑机会)3(在职-暂不考虑)
     */
    @ApiModelProperty("求职状态0(离职-随时到岗)1(在职-月内到岗)2(在职-考虑机会)3(在职-暂不考虑)")
    @Column(name = "find_job_status")
    private Integer findJobStatus;

    /**
     * 婚姻状态0未婚1已婚
     */
    @ApiModelProperty("婚姻状态0未婚1已婚")
    @Column(name = "marriage_status")
    private Integer marriageStatus;

    /**
     * 籍贯
     */
    @ApiModelProperty("籍贯")
    @Column(name = "native_place")
    private String nativePlace;


    /**
     * 学历
     */
    @ApiModelProperty("民族")
    @Column(name = "nation")
    private String nation;
    /**
     * 简历类型
     */
    @ApiModelProperty("简历类型")
    @Column(name = "type")
    private Integer type;
    /**
     * 目标职
     */
    @ApiModelProperty("目标职")
    @Column(name = "job_type")
    private String jobType;

    /**
     * 工作类型
     */
    @ApiModelProperty("工作类型")
    @Column(name = "work_type")
    private Integer workType;

    /**
     * 省
     */
    @ApiModelProperty("省")
    private String province;

    /**
     * 市
     */
    @ApiModelProperty("市")
    private String city;

    /**
     * 目标区域(县)
     */
    @ApiModelProperty("目标区域(县)")
    private String area;

    /**
     * 乡镇
     */
    @ApiModelProperty("乡镇")
    private String town;

    /**
     * 详细地址
     */
    @ApiModelProperty("详细地址")
    @Column(name = "detail_place")
    private String detailPlace;

    /***
     * 当前省
     * */
    @Column(name="now_province")
    private String nowProvince;

    /***
     * 当前市
     * */
    @Column(name="now_city")
    private String nowCity;
    /***
     * 当前区或县
     * */
    @Column(name="now_area")
    private String nowArea;

    /**
     * 学历
     */
    @ApiModelProperty("学历")
    private Integer education;

    /**
     * 毕业学校
     */
    @ApiModelProperty("毕业学校")
    @Column(name = "graduate_school")
    private String graduateSchool;

   /**
     * 专业
     */
    @ApiModelProperty("专业")
    private String major;


    /**
     * 职业技能
     */
    @ApiModelProperty("职业技能")
    @Column(name = "job_skill")
    private String jobSkill;


    /**
     * 自我评价
     */
    @ApiModelProperty("自我评价")
    @Column(name = "self_appraise")
    private String selfAppraise;

    /**
     * 0关闭1开启
     */
    @ApiModelProperty("0关闭1开启")
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

    @Transient
    private List<EduExperience> eduExperienceList;
    @Transient
    private List<WorkExperience> workExperienceList;

    /**
     * 获取简历
     *
     * @return id - 简历
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置简历
     *
     * @param id 简历
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public List<EduExperience> getEduExperienceList() {
        return eduExperienceList;
    }

    public void setEduExperienceList(List<EduExperience> eduExperienceList) {
        this.eduExperienceList = eduExperienceList;
    }

    public List<WorkExperience> getWorkExperienceList() {
        return workExperienceList;
    }

    public void setWorkExperienceList(List<WorkExperience> workExperienceList) {
        this.workExperienceList = workExperienceList;
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

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getGraduateSchool() {
        return graduateSchool;
    }

    public void setGraduateSchool(String graduateSchool) {
        this.graduateSchool = graduateSchool;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getNowProvince() {
        return nowProvince;
    }

    public void setNowProvince(String nowProvince) {
        this.nowProvince = nowProvince;
    }

    public String getNowCity() {
        return nowCity;
    }

    public void setNowCity(String nowCity) {
        this.nowCity = nowCity;
    }

    public String getNowArea() {
        return nowArea;
    }

    public void setNowArea(String nowArea) {
        this.nowArea = nowArea;
    }

    /**
     * 获取用户头像
     *
     * @return head_img - 用户头像
     */
    public String getHeadImg() {
        return headImg;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getWorkType() {
        return workType;
    }

    public void setWorkType(Integer workType) {
        this.workType = workType;
    }

    /**
     * 设置用户头像
     *
     * @param headImg 用户头像
     */
    public void setHeadImg(String headImg) {
        this.headImg = headImg;
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
     * 获取性别0男1女
     *
     * @return sex - 性别0男1女
     */
    public Integer getSex() {
        return sex;
    }

    /**
     * 设置性别0男1女
     *
     * @param sex 性别0男1女
     */
    public void setSex(Integer sex) {
        this.sex = sex;
    }

    /**
     * 获取年龄
     *
     * @return age - 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 设置年龄
     *
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
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
     * 获取邮箱
     *
     * @return email - 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置邮箱
     *
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取期望工资
     *
     * @return expect_money - 期望工资
     */
    public String getExpectMoney() {
        return expectMoney;
    }

    /**
     * 设置期望工资
     *
     * @param expectMoney 期望工资
     */
    public void setExpectMoney(String expectMoney) {
        this.expectMoney = expectMoney;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置电话
     *
     * @param phone 电话
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取求职状态0(离职-随时到岗)1(在职-月内到岗)2(在职-考虑机会)3(在职-暂不考虑)
     *
     * @return find_job_status - 求职状态0(离职-随时到岗)1(在职-月内到岗)2(在职-考虑机会)3(在职-暂不考虑)
     */
    public Integer getFindJobStatus() {
        return findJobStatus;
    }

    /**
     * 设置求职状态0(离职-随时到岗)1(在职-月内到岗)2(在职-考虑机会)3(在职-暂不考虑)
     *
     * @param findJobStatus 求职状态0(离职-随时到岗)1(在职-月内到岗)2(在职-考虑机会)3(在职-暂不考虑)
     */
    public void setFindJobStatus(Integer findJobStatus) {
        this.findJobStatus = findJobStatus;
    }

    /**
     * 获取婚姻状态0未婚1已婚
     *
     * @return marriage_status - 婚姻状态0未婚1已婚
     */
    public Integer getMarriageStatus() {
        return marriageStatus;
    }

    /**
     * 设置婚姻状态0未婚1已婚
     *
     * @param marriageStatus 婚姻状态0未婚1已婚
     */
    public void setMarriageStatus(Integer marriageStatus) {
        this.marriageStatus = marriageStatus;
    }

    /**
     * 获取籍贯
     *
     * @return native_place - 籍贯
     */
    public String getNativePlace() {
        return nativePlace;
    }

    /**
     * 设置籍贯
     *
     * @param nativePlace 籍贯
     */
    public void setNativePlace(String nativePlace) {
        this.nativePlace = nativePlace;
    }

    /**
     * 获取目标职
     *
     * @return job_type - 目标职
     */
    public String getJobType() {
        return jobType;
    }

    /**
     * 设置目标职
     *
     * @param jobType 目标职
     */
    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    /**
     * 获取省
     *
     * @return province - 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置省
     *
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取市
     *
     * @return city - 市
     */
    public String getCity() {
        return city;
    }

    public Integer getEducation() {
        return education;
    }

    public void setEducation(Integer education) {
        this.education = education;
    }

    /**
     * 设置市
     *
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取目标区域(县)
     *
     * @return area - 目标区域(县)
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置目标区域(县)
     *
     * @param area 目标区域(县)
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取乡镇
     *
     * @return town - 乡镇
     */
    public String getTown() {
        return town;
    }

    /**
     * 设置乡镇
     *
     * @param town 乡镇
     */
    public void setTown(String town) {
        this.town = town;
    }

    /**
     * 获取详细地址
     *
     * @return detail_place - 详细地址
     */
    public String getDetailPlace() {
        return detailPlace;
    }

    /**
     * 设置详细地址
     *
     * @param detailPlace 详细地址
     */
    public void setDetailPlace(String detailPlace) {
        this.detailPlace = detailPlace;
    }

    /**
     * 获取职业技能
     *
     * @return job_skill - 职业技能
     */
    public String getJobSkill() {
        return jobSkill;
    }

    /**
     * 设置职业技能
     *
     * @param jobSkill 职业技能
     */
    public void setJobSkill(String jobSkill) {
        this.jobSkill = jobSkill;
    }

    /**
     * 获取自我评价
     *
     * @return self_appraise - 自我评价
     */
    public String getSelfAppraise() {
        return selfAppraise;
    }

    /**
     * 设置自我评价
     *
     * @param selfAppraise 自我评价
     */
    public void setSelfAppraise(String selfAppraise) {
        this.selfAppraise = selfAppraise;
    }

    /**
     * 获取0关闭1开启
     *
     * @return status - 0关闭1开启
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0关闭1开启
     *
     * @param status 0关闭1开启
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