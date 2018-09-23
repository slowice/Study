package com.lanhu.work.vo;

import javax.validation.constraints.NotNull;

public class FrontCommentListPageVo {
	

    /**
     * 评论专题ID
     */
    @NotNull(message = "000001,为空")
    private Long commentTopicId;
    
    
    /**
     * 父评论id
     */
    private Long commentCommentid=0l;
    
    
    /**
     * 0:待审核1:审核通过2:审核不通过
     */
    private Integer commentState=1;
    
    
	
	@NotNull(message = "000001,pageNum为空")
	private Integer pageNum;
	
	
	@NotNull(message = "000001,pageSize为空")
	private Integer pageSize;


	public Long getCommentTopicId() {
		return commentTopicId;
	}


	public void setCommentTopicId(Long commentTopicId) {
		this.commentTopicId = commentTopicId;
	}


	public Long getCommentCommentid() {
		return commentCommentid;
	}


	public void setCommentCommentid(Long commentCommentid) {
		this.commentCommentid = commentCommentid;
	}


	public Integer getCommentState() {
		return commentState;
	}


	public void setCommentState(Integer commentState) {
		this.commentState = commentState;
	}


	public Integer getPageNum() {
		return pageNum;
	}


	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}


	public Integer getPageSize() {
		return pageSize;
	}


	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
    
    
    
    


}
