package com.wzj.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel("用户")
public class User {
    /**
     * id(用户)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("用户ID")
    private Long id;

    /**
     * 微信公众号openId
     */
    @ApiModelProperty("微信公众号openId")
    @Column(name="wechat_public_openid")
    private String wechatPublicOpenid;
    /**
     * 头像
     */
    @ApiModelProperty("头像")
    @Column(name="head_img")
    private String headImg;

    /**
     * 名称
     */
    @ApiModelProperty("名称")
    private String name;

    /**
     * 手机号
     */
    @ApiModelProperty("手机号")
    private String phone;

    /**
     * 邮箱
     */
    @ApiModelProperty("邮箱")
    private String email;

    /**
     * 微信
     */
    @ApiModelProperty("微信")
    @Column(name="we_chat")
    private String weChat;

    /**
     * qq
     */
    @ApiModelProperty("qq")
    private String qq;

    /**
     * 密码
     */
    @ApiModelProperty("密码")
    private String pwd;

    /**
     * 身份证号
     */
    @ApiModelProperty("身份证号")
    @Column(name = "id_card")
    private String idCard;

    /**
     * 身份证反面
     * */
    @Column(name="id_card_reverse")
    private String idCardReverse;

    /**
     * 教师资格证
     */
    @ApiModelProperty("教师资格证")
    @Column(name = "teacher_certification")
    private String teacherCertification;

    /**
     * 个人生活照
     */
    @ApiModelProperty("个人生活照")
    @Column(name = "life_picture")
    private String lifePicture;

    /**
     * 专业
     */
    @ApiModelProperty("专业")
    private String major;

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
     * 工作经验
     */
    @ApiModelProperty("工作经验")
    @Column(name = "work_experience")
    private String workExperience;

    /**
     * 年龄
     */
    @ApiModelProperty("年龄")
    private Integer age;

    /**
     * 期望工资
     */
    @ApiModelProperty("期望工资")
    @Column(name = "expect_money")
    private String expectMoney;

    /**
     * 籍贯
     */
    @ApiModelProperty("籍贯")
    @Column(name = "native_place")
    private String nativePlace;

    /**
     * 工作职位
     */
    @ApiModelProperty("工作职位")
    @Column(name = "job_position")
    private String jobPosition;

    /**
     * 学历
     */
    @ApiModelProperty("学历")
    private String education;

    /**
     * 所在省
     */
    @ApiModelProperty("所在省")
    private String province;

    /**
     * 所在市
     */
    @ApiModelProperty("所在市")
    private String city;

    /**
     * 所在县
     */
    @ApiModelProperty("所在县")
    private String area;

    /**
     * 所在乡镇
     */
    @ApiModelProperty("所在乡镇")
    private String town;

    /**
     * 详细地址
     */
    @ApiModelProperty("详细地址")
    @Column(name = "detail_place")
    private String detailPlace;

    /**
     * 0未审核1审核通过2审核不通过
     */
    @ApiModelProperty("0未审核1审核通过2审核不通过3冻结状态")
    private Integer status;

    /**
     * 0未审核1审核通过2审核不通过
     */
    @ApiModelProperty("异常原因(未通过认证,冻结原因)")
    @Column(name="abnormal_reason")
    private String abnormalReason;

    /**
     * 添加时间
     */
    @ApiModelProperty("添加时间")
    @Column(name = "add_time")
    private String addTime;
    /**
     * 认证时间
     */
    @ApiModelProperty("认证时间")
    @Column(name = "authentication_time")
    private String authenticationTime;
    /**
     * 认证状态
     */
    @ApiModelProperty("认证状态")
    @Column(name = "authentication_status")
    private Integer authenticationStatus;

    /**
     * 修改时间
     */
    @ApiModelProperty("修改时间")
    @Column(name = "modify_time")
    private String modifyTime;

    /**
     * 获取id(用户)
     *
     * @return id - id(用户)
     */
    public Long getId() {
        return id;
    }

    public String getWechatPublicOpenid() {
        return wechatPublicOpenid;
    }

    public void setWechatPublicOpenid(String wechatPublicOpenid) {
        this.wechatPublicOpenid = wechatPublicOpenid;
    }

    /**
     * 设置id(用户)
     *
     * @param id id(用户)
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getAuthenticationTime() {
        return authenticationTime;
    }

    public Integer getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(Integer authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    public void setAuthenticationTime(String authenticationTime) {
        this.authenticationTime = authenticationTime;
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

    public String getIdCardReverse() {
        return idCardReverse;
    }

    public void setIdCardReverse(String idCardReverse) {
        this.idCardReverse = idCardReverse;
    }

    /**
     * 获取手机号
     *
     * @return phone - 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 设置手机号
     *
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * 获取密码
     *
     * @return pwd - 密码
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置密码
     *
     * @param pwd 密码
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getAbnormalReason() {
        return abnormalReason;
    }

    public void setAbnormalReason(String abnormalReason) {
        this.abnormalReason = abnormalReason;
    }

    /**
     * 获取身份证号
     *
     * @return id_card - 身份证号
     */
    public String getIdCard() {
        return idCard;
    }

    public String getWeChat() {
        return weChat;
    }

    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    /**
     * 设置身份证号
     *
     * @param idCard 身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    /**
     * 获取教师资格证
     *
     * @return teacher_certification - 教师资格证
     */
    public String getTeacherCertification() {
        return teacherCertification;
    }

    /**
     * 设置教师资格证
     *
     * @param teacherCertification 教师资格证
     */
    public void setTeacherCertification(String teacherCertification) {
        this.teacherCertification = teacherCertification;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    /**
     * 获取个人生活照
     *
     * @return life_picture - 个人生活照
     */
    public String getLifePicture() {
        return lifePicture;
    }

    /**
     * 设置个人生活照
     *
     * @param lifePicture 个人生活照
     */
    public void setLifePicture(String lifePicture) {
        this.lifePicture = lifePicture;
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
     * 获取工作经验
     *
     * @return work_experience - 工作经验
     */
    public String getWorkExperience() {
        return workExperience;
    }

    /**
     * 设置工作经验
     *
     * @param workExperience 工作经验
     */
    public void setWorkExperience(String workExperience) {
        this.workExperience = workExperience;
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
     * 获取工作职位
     *
     * @return job_position_id - 工作职位
     */
    public String getJobPosition() {
        return jobPosition;
    }

    /**
     * 设置工作职位
     *
     * @param jobPosition 工作职位
     */
    public void setJobPositionId(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    /**
     * 获取学历
     *
     * @return education - 学历
     */
    public String getEducation() {
        return education;
    }

    /**
     * 设置学历
     *
     * @param education 学历
     */
    public void setEducation(String education) {
        this.education = education;
    }

    /**
     * 获取所在省
     *
     * @return province - 所在省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 设置所在省
     *
     * @param province 所在省
     */
    public void setProvince(String province) {
        this.province = province;
    }

    /**
     * 获取所在市
     *
     * @return city - 所在市
     */
    public String getCity() {
        return city;
    }

    /**
     * 设置所在市
     *
     * @param city 所在市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取所在县
     *
     * @return area - 所在县
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置所在县
     *
     * @param area 所在县
     */
    public void setArea(String area) {
        this.area = area;
    }

    /**
     * 获取所在乡镇
     *
     * @return town - 所在乡镇
     */
    public String getTown() {
        return town;
    }

    /**
     * 设置所在乡镇
     *
     * @param town 所在乡镇
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
     * 获取0未审核1审核通过2审核不通过
     *
     * @return status - 0未审核1审核通过2审核不通过
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置0未审核1审核通过2审核不通过
     *
     * @param status 0未审核1审核通过2审核不通过
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