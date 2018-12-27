package com.qiqiim.constant.api;
/**
 * 返回字符串数据
 * @author  leihua
 * @date [2016年3月21日 上午9:13:27]
 * @version   1.0
 */
public class ResultCodeDataStr extends ResultCode {
	private String data;
	
	public ResultCodeDataStr(){
		this.data="";
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}
	
	public static ResultCodeDataStr SUCCESS(){
		ResultCodeDataStr rc = new ResultCodeDataStr();
		rc.setCode("200");
		rc.setMsg("success");
		rc.setData("true");
		return rc;			
	}

	public static ResultCodeDataStr SUCCESS(String data){
		ResultCodeDataStr rc = new ResultCodeDataStr();
		rc.setCode("200");
		rc.setMsg("success");
		rc.setData(data);
		return rc;			
	}
	
	public static ResultCodeDataStr ERROR(){
		ResultCodeDataStr rc = new ResultCodeDataStr();
		rc.setCode("404");
		rc.setMsg("error");
		rc.setData("false");
		return rc;			
	}

	public static ResultCodeDataStr ERROR(String msg){
		ResultCodeDataStr rc = new ResultCodeDataStr();
		rc.setCode("404");
		rc.setMsg(msg);
		rc.setData("false");
		return rc;			
	}
	
	public static ResultCodeDataStr INFO(String code,String msg,String data){
		ResultCodeDataStr rc = new ResultCodeDataStr();
		rc.setCode(code);
		rc.setMsg(msg);
		rc.setData(data);
		return rc;			
	}
	
}
