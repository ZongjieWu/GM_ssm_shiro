package com.wzj.model;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;

@ApiModel("职位类型")
@Table(name = "job_type")
public class JobType {
    /**
     * id(工作职位)
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty("ID")
    private Long id;

    /**
     * 名称
     */
    @ApiModelProperty("职位名称")
    private String name;

    /**
     * 父级id(0为一级分类)
     */
    @ApiModelProperty("父级ID")
    private Long pid;

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
     * 获取id(工作职位)
     *
     * @return id - id(工作职位)
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id(工作职位)
     *
     * @param id id(工作职位)
     */
    public void setId(Long id) {
        this.id = id;
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
     * 获取父级id(0为一级分类)
     *
     * @return pid - 父级id(0为一级分类)
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置父级id(0为一级分类)
     *
     * @param pid 父级id(0为一级分类)
     */
    public void setPid(Long pid) {
        this.pid = pid;
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