package com.wzj.model;

import javax.persistence.*;

public class Enterprise {
    /**
     * id(企业)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 企业名称
     */
    private String name;

    /**
     * logo
     */
    private String logo;

    /**
     * 电话
     */
    private String phone;

    /**
     * 密码
     */
    private String pwd;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 微信
     */
    @Column(name = "we_chat")
    private String weChat;

    /**
     * QQ
     */
    private String qq;

    /**
     * 营业执照
     */
    @Column(name = "business_license")
    private String businessLicense;

    /**
     * 办学资质
     */
    @Column(name = "teacher_aptitude")
    private String teacherAptitude;

    /**
     * 法人身份证
     */
    @Column(name = "legal_id_card")
    private String legalIdCard;
   /**
     * 法人身份证反面
     */
    @Column(name = "legal_id_card_reverse")
    private String legalIdCardReverse;

    /**
     * 打款凭证
     */
    @Column(name = "remit_authentication")
    private String remitAuthentication;

    /**
     * 企业简介
     */
    private String intro;

    /**
     * 上班时间
     */
    @Column(name = "work_time")
    private String workTime;

    /**
     * 0无休息1单休2双休
     */
    @Column(name = "single_double_cease")
    private Integer singleDoubleCease;

    /**
     * 企业类型(行业)
     */
    @Column(name = "enterprise_type")
    private String enterpriseType;

    /**
     * 企业性质
     */
    private String quality;

    /**
     * 企业的规模
     */
    private String scale;

    /**
     * 省
     */
    private String province;

    /**
     * 市
     */
    private String city;

    /**
     * 县
     */
    private String area;

    /**
     * 所在乡镇
     */
    private String town;

    /**
     * 详细地址
     */
    @Column(name = "detail_place")
    private String detailPlace;

    /**
     * 员工数量
     */
    @Column(name = "employee_number")
    private Integer employeeNumber;

    /**
     * 注册资金(单位万)
     */
    @Column(name = "register_money")
    private Integer registerMoney;

    /**
     * 精度
     */
    private String lng;

    /**
     * 纬度
     */
    private String lat;

    /**
     * 服务类型
     */
    @Column(name = "service_type")
    private String serviceType;

    /**
     * 认证状态
     * */
    @Column(name = "authentication_status")
    private Integer authenticationStatus;
    /**
     * (0未认证1认证通过2认证不通过3冻结)
     */
    private Integer status;

    /**
     * 服务终止时间
     */
    @Column(name = "service_end_time")
    private String serviceEndTime;

    /**
     * 认证时间
     */
    @Column(name = "authentication_time")
    private String authenticationTime;

    /**
     * 成立日期
     */
    @Column(name = "setup_time")
    private String setupTime;

    /**
     * 注册日期
     */
    @Column(name = "register_time")
    private String registerTime;

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
     * 获取id(企业)
     *
     * @return id - id(企业)
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id(企业)
     *
     * @param id id(企业)
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取企业名称
     *
     * @return name - 企业名称
     */
    public String getName() {
        return name;
    }

    /**
     * 设置企业名称
     *
     * @param name 企业名称
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取logo
     *
     * @return logo - logo
     */
    public String getLogo() {
        return logo;
    }

    public Integer getAuthenticationStatus() {
        return authenticationStatus;
    }

    public void setAuthenticationStatus(Integer authenticationStatus) {
        this.authenticationStatus = authenticationStatus;
    }

    /**
     * 设置logo
     *
     * @param logo logo
     */
    public void setLogo(String logo) {
        this.logo = logo;
    }

    /**
     * 获取电话
     *
     * @return phone - 电话
     */
    public String getPhone() {
        return phone;
    }

    public String getLegalIdCardReverse() {
        return legalIdCardReverse;
    }

    public void setLegalIdCardReverse(String legalIdCardReverse) {
        this.legalIdCardReverse = legalIdCardReverse;
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
     * 获取微信
     *
     * @return we_chat - 微信
     */
    public String getWeChat() {
        return weChat;
    }

    /**
     * 设置微信
     *
     * @param weChat 微信
     */
    public void setWeChat(String weChat) {
        this.weChat = weChat;
    }

    /**
     * 获取QQ
     *
     * @return qq - QQ
     */
    public String getQq() {
        return qq;
    }

    /**
     * 设置QQ
     *
     * @param qq QQ
     */
    public void setQq(String qq) {
        this.qq = qq;
    }

    /**
     * 获取营业执照
     *
     * @return business_license - 营业执照
     */
    public String getBusinessLicense() {
        return businessLicense;
    }

    /**
     * 设置营业执照
     *
     * @param businessLicense 营业执照
     */
    public void setBusinessLicense(String businessLicense) {
        this.businessLicense = businessLicense;
    }

    /**
     * 获取办学资质
     *
     * @return teacher_aptitude - 办学资质
     */
    public String getTeacherAptitude() {
        return teacherAptitude;
    }

    /**
     * 设置办学资质
     *
     * @param teacherAptitude 办学资质
     */
    public void setTeacherAptitude(String teacherAptitude) {
        this.teacherAptitude = teacherAptitude;
    }

    /**
     * 获取法人身份证
     *
     * @return legal_id_card - 法人身份证
     */
    public String getLegalIdCard() {
        return legalIdCard;
    }

    /**
     * 设置法人身份证
     *
     * @param legalIdCard 法人身份证
     */
    public void setLegalIdCard(String legalIdCard) {
        this.legalIdCard = legalIdCard;
    }

    /**
     * 获取打款凭证
     *
     * @return remit_authentication - 打款凭证
     */
    public String getRemitAuthentication() {
        return remitAuthentication;
    }

    /**
     * 设置打款凭证
     *
     * @param remitAuthentication 打款凭证
     */
    public void setRemitAuthentication(String remitAuthentication) {
        this.remitAuthentication = remitAuthentication;
    }

    /**
     * 获取企业简介
     *
     * @return intro - 企业简介
     */
    public String getIntro() {
        return intro;
    }

    /**
     * 设置企业简介
     *
     * @param intro 企业简介
     */
    public void setIntro(String intro) {
        this.intro = intro;
    }

    /**
     * 获取上班时间
     *
     * @return work_time - 上班时间
     */
    public String getWorkTime() {
        return workTime;
    }

    /**
     * 设置上班时间
     *
     * @param workTime 上班时间
     */
    public void setWorkTime(String workTime) {
        this.workTime = workTime;
    }

    /**
     * 获取0无休息1单休2双休
     *
     * @return single_double_cease - 0无休息1单休2双休
     */
    public Integer getSingleDoubleCease() {
        return singleDoubleCease;
    }

    /**
     * 设置0无休息1单休2双休
     *
     * @param singleDoubleCease 0无休息1单休2双休
     */
    public void setSingleDoubleCease(Integer singleDoubleCease) {
        this.singleDoubleCease = singleDoubleCease;
    }

    /**
     * 获取企业类型(行业)
     *
     * @return enterprise_type - 企业类型(行业)
     */
    public String getEnterpriseType() {
        return enterpriseType;
    }

    /**
     * 设置企业类型(行业)
     *
     * @param enterpriseType 企业类型(行业)
     */
    public void setEnterpriseType(String enterpriseType) {
        this.enterpriseType = enterpriseType;
    }

    /**
     * 获取企业性质
     *
     * @return quality - 企业性质
     */
    public String getQuality() {
        return quality;
    }

    /**
     * 设置企业性质
     *
     * @param quality 企业性质
     */
    public void setQuality(String quality) {
        this.quality = quality;
    }

    /**
     * 获取企业的规模
     *
     * @return scale - 企业的规模
     */
    public String getScale() {
        return scale;
    }

    /**
     * 设置企业的规模
     *
     * @param scale 企业的规模
     */
    public void setScale(String scale) {
        this.scale = scale;
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

    /**
     * 设置市
     *
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 获取县
     *
     * @return area - 县
     */
    public String getArea() {
        return area;
    }

    /**
     * 设置县
     *
     * @param area 县
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
     * 获取员工数量
     *
     * @return employee_number - 员工数量
     */
    public Integer getEmployeeNumber() {
        return employeeNumber;
    }

    /**
     * 设置员工数量
     *
     * @param employeeNumber 员工数量
     */
    public void setEmployeeNumber(Integer employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    /**
     * 获取注册资金(单位万)
     *
     * @return register_money - 注册资金(单位万)
     */
    public Integer getRegisterMoney() {
        return registerMoney;
    }

    /**
     * 设置注册资金(单位万)
     *
     * @param registerMoney 注册资金(单位万)
     */
    public void setRegisterMoney(Integer registerMoney) {
        this.registerMoney = registerMoney;
    }

    /**
     * 获取精度
     *
     * @return lng - 精度
     */
    public String getLng() {
        return lng;
    }

    public String getServiceType() {
        return serviceType;
    }

    public void setServiceType(String serviceType) {
        this.serviceType = serviceType;
    }

    public String getServiceEndTime() {
        return serviceEndTime;
    }

    public void setServiceEndTime(String serviceEndTime) {
        this.serviceEndTime = serviceEndTime;
    }

    /**
     * 设置精度
     *
     * @param lng 精度
     */
    public void setLng(String lng) {
        this.lng = lng;
    }

    /**
     * 获取纬度
     *
     * @return lat - 纬度
     */
    public String getLat() {
        return lat;
    }

    /**
     * 设置纬度
     *
     * @param lat 纬度
     */
    public void setLat(String lat) {
        this.lat = lat;
    }

    /**
     * 获取(0未认证1认证通过2认证不通过3冻结)
     *
     * @return status - (0未认证1认证通过2认证不通过3冻结)
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 设置(0未认证1认证通过2认证不通过3冻结)
     *
     * @param status (0未认证1认证通过2认证不通过3冻结)
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 获取认证时间
     *
     * @return authentication_time - 认证时间
     */
    public String getAuthenticationTime() {
        return authenticationTime;
    }

    /**
     * 设置认证时间
     *
     * @param authenticationTime 认证时间
     */
    public void setAuthenticationTime(String authenticationTime) {
        this.authenticationTime = authenticationTime;
    }

    /**
     * 获取成立日期
     *
     * @return setup_time - 成立日期
     */
    public String getSetupTime() {
        return setupTime;
    }

    /**
     * 设置成立日期
     *
     * @param setupTime 成立日期
     */
    public void setSetupTime(String setupTime) {
        this.setupTime = setupTime;
    }

    /**
     * 获取注册日期
     *
     * @return register_time - 注册日期
     */
    public String getRegisterTime() {
        return registerTime;
    }

    /**
     * 设置注册日期
     *
     * @param registerTime 注册日期
     */
    public void setRegisterTime(String registerTime) {
        this.registerTime = registerTime;
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