package com.lanhu.work.pojo;

import java.util.Date;

/**
 * 评论表
 * 
 * @author wcyong
 * 
 * @date 2018-08-09
 */
public class Comment {
    /**
     * 评论id（主键）
     */
    private Long commentId;

    /**
     * 父评论id
     */
    private Long commentCommentid;

    /**
     * 评论的内容
     */
    private String commentContent;

    /**
     * 评论时发布的图片，可上传多张图片(2张）,多张图片以json格式存放图片地址
     */
    private String commentPicture;

    /**
     * 评论时间
     */
    private Date commentTime;

    /**
     * 评论的类型：1 匿名，2 公开，默认为公开
     */
    private Integer commentType;

    /**
     * 评论者id，默认为非会员用户（即游客）
     */
    private Long commentUserId;

    /**
     * 评论用户名称
     */
    private String commentUserName;

    /**
     * 评价打分（-1至5分）
     */
    private Integer commentPoints;

    /**
     * 评论类目ID
     */
    private Long commentCategoryId;

    /**
     * 评论专题ID
     */
    private Long commentTopicId;

    /**
     * 0:待审核1:审核通过2:审核不通过
     */
    private Integer commentState;

    /**
     * 评论审核人
     */
    private Long commentAuditBy;

    /**
     * 评论审核时间
     */
    private Date commentAuditTime;

    /**
     * 备注
     */
    private String commentRemark;

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public Long getCommentCommentid() {
        return commentCommentid;
    }

    public void setCommentCommentid(Long commentCommentid) {
        this.commentCommentid = commentCommentid;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public String getCommentPicture() {
        return commentPicture;
    }

    public void setCommentPicture(String commentPicture) {
        this.commentPicture = commentPicture == null ? null : commentPicture.trim();
    }

    public Date getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(Date commentTime) {
        this.commentTime = commentTime;
    }

    public Integer getCommentType() {
        return commentType;
    }

    public void setCommentType(Integer commentType) {
        this.commentType = commentType;
    }

    public Long getCommentUserId() {
        return commentUserId;
    }

    public void setCommentUserId(Long commentUserId) {
        this.commentUserId = commentUserId;
    }

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName == null ? null : commentUserName.trim();
    }

    public Integer getCommentPoints() {
        return commentPoints;
    }

    public void setCommentPoints(Integer commentPoints) {
        this.commentPoints = commentPoints;
    }

    public Long getCommentCategoryId() {
        return commentCategoryId;
    }

    public void setCommentCategoryId(Long commentCategoryId) {
        this.commentCategoryId = commentCategoryId;
    }

    public Long getCommentTopicId() {
        return commentTopicId;
    }

    public void setCommentTopicId(Long commentTopicId) {
        this.commentTopicId = commentTopicId;
    }

    public Integer getCommentState() {
        return commentState;
    }

    public void setCommentState(Integer commentState) {
        this.commentState = commentState;
    }

    public Long getCommentAuditBy() {
        return commentAuditBy;
    }

    public void setCommentAuditBy(Long commentAuditBy) {
        this.commentAuditBy = commentAuditBy;
    }

    public Date getCommentAuditTime() {
        return commentAuditTime;
    }

    public void setCommentAuditTime(Date commentAuditTime) {
        this.commentAuditTime = commentAuditTime;
    }

    public String getCommentRemark() {
        return commentRemark;
    }

    public void setCommentRemark(String commentRemark) {
        this.commentRemark = commentRemark == null ? null : commentRemark.trim();
    }
}