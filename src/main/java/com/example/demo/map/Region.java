package com.example.demo.map;

import java.util.Date;

/**
 * @author daizhichao
 * @date 2019/1/7 10:15
 */
public class Region {
    private Integer id;

    /**
     * 父节点
     */
    private Integer parentId;

    /**
     * 区域级别：1：（国家）2：（省、直辖市）3：（市级）4：（区县）
     */
    private Integer regionLevel;

    /**
     * 区域排序号
     */
    private Integer regionOrder;

    /**
     * 区域上级关联列表
     */
    private String regionUnion;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 区域编码
     */
    private String regionCode;

    /**
     * 区域名称
     */
    private String regionName;

    /**
     * 区域名称英文
     */
    private String regionNameEn;

    /**
     * 区域简称英文
     */
    private String regionShortnameEn;

    /**
     * @return id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取父节点
     *
     * @return parentId - 父节点
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 设置父节点
     *
     * @param parentId 父节点
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取区域级别：1：（国家）2：（省、直辖市）3：（市级）4：（区县）
     *
     * @return regionLevel - 区域级别：1：（国家）2：（省、直辖市）3：（市级）4：（区县）
     */
    public Integer getRegionLevel() {
        return regionLevel;
    }

    /**
     * 设置区域级别：1：（国家）2：（省、直辖市）3：（市级）4：（区县）
     *
     * @param regionLevel 区域级别：1：（国家）2：（省、直辖市）3：（市级）4：（区县）
     */
    public void setRegionLevel(Integer regionLevel) {
        this.regionLevel = regionLevel;
    }

    /**
     * 获取区域排序号
     *
     * @return regionOrder - 区域排序号
     */
    public Integer getRegionOrder() {
        return regionOrder;
    }

    /**
     * 设置区域排序号
     *
     * @param regionOrder 区域排序号
     */
    public void setRegionOrder(Integer regionOrder) {
        this.regionOrder = regionOrder;
    }

    /**
     * 获取区域上级关联列表
     *
     * @return regionUnion - 区域上级关联列表
     */
    public String getRegionUnion() {
        return regionUnion;
    }

    /**
     * 设置区域上级关联列表
     *
     * @param regionUnion 区域上级关联列表
     */
    public void setRegionUnion(String regionUnion) {
        this.regionUnion = regionUnion;
    }

    /**
     * 获取创建时间
     *
     * @return createTime - 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 设置创建时间
     *
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 获取更新时间
     *
     * @return updateTime - 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 设置更新时间
     *
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 获取区域编码
     *
     * @return regionCode - 区域编码
     */
    public String getRegionCode() {
        return regionCode;
    }

    /**
     * 设置区域编码
     *
     * @param regionCode 区域编码
     */
    public void setRegionCode(String regionCode) {
        this.regionCode = regionCode;
    }

    /**
     * 获取区域名称
     *
     * @return regionName - 区域名称
     */
    public String getRegionName() {
        return regionName;
    }

    /**
     * 设置区域名称
     *
     * @param regionName 区域名称
     */
    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    /**
     * 获取区域名称英文
     *
     * @return regionNameEn - 区域名称英文
     */
    public String getRegionNameEn() {
        return regionNameEn;
    }

    /**
     * 设置区域名称英文
     *
     * @param regionNameEn 区域名称英文
     */
    public void setRegionNameEn(String regionNameEn) {
        this.regionNameEn = regionNameEn;
    }

    /**
     * 获取区域简称英文
     *
     * @return regionShortnameEn - 区域简称英文
     */
    public String getRegionShortnameEn() {
        return regionShortnameEn;
    }

    /**
     * 设置区域简称英文
     *
     * @param regionShortnameEn 区域简称英文
     */
    public void setRegionShortnameEn(String regionShortnameEn) {
        this.regionShortnameEn = regionShortnameEn;
    }
}