package com.lanhu.work.pojo;

/**
 * 专题流程信息表
 * 
 * @author wcyong
 * 
 * @date 2018-08-09
 */
public class TopicFlows {
    private Long id;

    /**
     * 流程类型
     */
    private String flowType;

    /**
     * 流程信息
     */
    private String flowInfo;

    /**
     * 排序
     */
    private Integer orderNum;

    /**
     * 专题ID
     */
    private Long topicId;

    /**
     * 类目ID
     */
    private Long categoryId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFlowType() {
        return flowType;
    }

    public void setFlowType(String flowType) {
        this.flowType = flowType == null ? null : flowType.trim();
    }

    public String getFlowInfo() {
        return flowInfo;
    }

    public void setFlowInfo(String flowInfo) {
        this.flowInfo = flowInfo == null ? null : flowInfo.trim();
    }

    public Integer getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
    }

    public Long getTopicId() {
        return topicId;
    }

    public void setTopicId(Long topicId) {
        this.topicId = topicId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }
}