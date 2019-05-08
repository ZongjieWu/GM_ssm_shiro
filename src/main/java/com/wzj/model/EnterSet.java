package com.wzj.model;

import java.util.Date;
import javax.persistence.*;

@Table(name = "enter_set")
public class EnterSet {
    /**
     * 入驻设置
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 入驻类型
     */
    private String type;

    /**
     * 入驻费用
     */
    private String money;

    /**
     * 添加时间
     */
    @Column(name = "add_time")
    private Date addTime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    private Date modifyTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取入驻类型
     *
     * @return type - 入驻类型
     */
    public String getType() {
        return type;
    }

    /**
     * 设置入驻类型
     *
     * @param type 入驻类型
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * 获取入驻费用
     *
     * @return money - 入驻费用
     */
    public String getMoney() {
        return money;
    }

    /**
     * 设置入驻费用
     *
     * @param money 入驻费用
     */
    public void setMoney(String money) {
        this.money = money;
    }

    /**
     * 获取添加时间
     *
     * @return add_time - 添加时间
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * 设置添加时间
     *
     * @param addTime 添加时间
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * 获取修改时间
     *
     * @return modify_time - 修改时间
     */
    public Date getModifyTime() {
        return modifyTime;
    }

    /**
     * 设置修改时间
     *
     * @param modifyTime 修改时间
     */
    public void setModifyTime(Date modifyTime) {
        this.modifyTime = modifyTime;
    }
}