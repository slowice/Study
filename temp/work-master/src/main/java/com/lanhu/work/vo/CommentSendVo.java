package com.lanhu.work.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

public class CommentSendVo {
	
	 /**
     * 父评论id
     */
    private Long commentCommentid=0l;

    /**
     * 评论的内容
     */
    @NotBlank(message = "000001,为空")
    @Length(max = 2000, message = "000002,过长")
    private String commentContent;


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
    @Length(max = 100, message = "000002,过长")
    private String commentUserName;



    /**
     * 评论类目ID
     */
    private Long commentCategoryId;

    /**
     * 评论专题ID
     */
    @NotNull(message = "000001,为空")
    private Long commentTopicId;

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
		this.commentContent = commentContent;
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
		this.commentUserName = commentUserName;
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

   
    
    

}
