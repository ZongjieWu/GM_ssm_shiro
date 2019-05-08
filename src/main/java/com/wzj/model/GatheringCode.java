package com.wzj.model;

import javax.persistence.*;

@Table(name = "gathering_code")
public class GatheringCode {
    /**
     * 收款码
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 收款码图片
     */
    private String img;

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
     * 获取收款码
     *
     * @return id - 收款码
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置收款码
     *
     * @param id 收款码
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取收款码图片
     *
     * @return img - 收款码图片
     */
    public String getImg() {
        return img;
    }

    /**
     * 设置收款码图片
     *
     * @param img 收款码图片
     */
    public void setImg(String img) {
        this.img = img;
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