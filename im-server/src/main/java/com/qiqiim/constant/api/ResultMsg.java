package com.qiqiim.constant.api;

import java.util.HashMap;
import java.util.Map;

/**
 * 
 * @ClassName: ResultMsg
 * @Description: 相应数据包
 * @author 曹友安
 * @date 2017年12月27日 下午3:27:58
 */
public class ResultMsg {
    private int errorNo = 0; // 错误代码
    private String errorMsg; // 异常消息
    private Map<String, String> data = new HashMap<>(); // 封装数据包

    public ResultMsg() {
        super();
    }

    public ResultMsg(int errorNo, String errorMsg) {
        this.errorNo = errorNo;
        this.errorMsg = errorMsg;
    }

    public int getErrorNo() {
        return errorNo;
    }

    public void setErrorNo(int errorNo) {
        this.errorNo = errorNo;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public Map<String, String> getData() {
        return data;
    }

    public void setData(Map<String, String> data) {
        this.data.putAll(data);
    }

}
