package com.lanhu.work.pojo;

import java.util.Date;

/**
 * 业务文档模板
 * 
 * @author wcyong
 * 
 * @date 2018-08-09
 */
public class BusDocumentTemplate {
    /**
     * 主键
     */
    private Long id;

    /**
     * 业务类型(参考TemplateBusType枚举)
     */
    private String busType;

    /**
     * 标题
     */
    private String subject;

    /**
     * 模板
     */
    private String doc;

    /**
     * 上一次修改时间
     */
    private Date updateTime;

    /**
     * 修改人ID
     */
    private Long updateBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 创建人ID
     */
    private Long createBy;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType == null ? null : busType.trim();
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject == null ? null : subject.trim();
    }

    public String getDoc() {
        return doc;
    }

    public void setDoc(String doc) {
        this.doc = doc == null ? null : doc.trim();
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }
}