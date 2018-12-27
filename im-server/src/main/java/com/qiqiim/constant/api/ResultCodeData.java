package com.qiqiim.constant.api;

public class ResultCodeData  extends ResultCode{
	public Object result;

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}
	public static ResultCodeData SUCCESS(Object obj){
		ResultCodeData rc = new ResultCodeData();
		rc.setCode("1");
		rc.setMsg("success");
		rc.setResult(obj);
		return rc;			
	}
	
	public static ResultCodeData ERROR(Object obj){
		ResultCodeData rc = new ResultCodeData();
		rc.setCode("2");
		rc.setMsg("error");
		rc.setResult(obj);
		return rc;			
	}

	public static ResultCodeData ERROR(String msg,Object obj){
		ResultCodeData rc = new ResultCodeData();
		rc.setCode("2");
		rc.setMsg(msg);
		rc.setResult(obj);
		return rc;			
	}
	
	public static ResultCodeData INFO(String code,String msg,Object obj){
		ResultCodeData rc = new ResultCodeData();
		rc.setCode(code);
		rc.setMsg(msg);
		rc.setResult(obj);
		return rc;			
	}
}
