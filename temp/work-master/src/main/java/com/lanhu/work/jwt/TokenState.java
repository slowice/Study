package com.lanhu.work.jwt;

/**
 * 枚举，定义token的三种状态
 * @author running@vip.163.com
 *
 */
 public enum TokenState {  
	 /**
	  * 过期
	  */
	EXPIRED("EXPIRED","token 过期"),
	/**
	 * 无效(token不合法)
	 */
	INVALID("INVALID","token 不合法"), 
	/**
	 * 有效的
	 */
	VALID("VALID","token 合法");  
	
    private String  state;  
    
    private String msg;
      
    private TokenState(String state,String msg) {  
        this.state = state;  
        this.msg = msg;
    }
    
    /**
     * 根据状态字符串获取token状态枚举对象
     * @param tokenState
     * @return
     */
    public static TokenState getTokenState(String tokenState){
    	TokenState[] states=TokenState.values();
    	TokenState ts=null;
    	for (TokenState state : states) {
			if(state.toString().equals(tokenState)){
				ts=state;
				break;
			}
		}
    	return ts;
    }
    public String toString() {
    	return this.state;
    }
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
    
	
	
}  
