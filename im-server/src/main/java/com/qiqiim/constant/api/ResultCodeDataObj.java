package com.qiqiim.constant.api;
/**
 * 返回对象数据
 * @author  leihua
 * @date [2016年3月21日 上午9:14:40]
 * @version   1.0
 */
public class ResultCodeDataObj extends ResultCode {
	public Object data;

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public static ResultCodeDataObj SUCCESS(Object obj){
		ResultCodeDataObj rc = new ResultCodeDataObj();
		rc.setCode("200");
		rc.setMsg("success");
		rc.setData(obj);
		return rc;			
	}
	
	public static ResultCodeDataObj ERROR(Object obj){
		ResultCodeDataObj rc = new ResultCodeDataObj();
		rc.setCode("404");
		rc.setMsg("error");
		rc.setData(obj);
		return rc;			
	}

	public static ResultCodeDataObj ERROR(String msg,Object obj){
		ResultCodeDataObj rc = new ResultCodeDataObj();
		rc.setCode("404");
		rc.setMsg(msg);
		rc.setData(obj);
		return rc;			
	}
	
	public static ResultCodeDataObj INFO(String code,String msg,Object obj){
		ResultCodeDataObj rc = new ResultCodeDataObj();
		rc.setCode(code);
		rc.setMsg(msg);
		rc.setData(obj);
		return rc;			
	}
	
}
