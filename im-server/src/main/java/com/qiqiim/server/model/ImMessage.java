package com.qiqiim.server.model;

public class ImMessage {

    private String version;//接口版本号
    private String deviceId;//设备uuid
    private Integer cmd;//请求接口命令字  1绑定  2心跳   3上线   4下线
    private String sender;//发送人
    private String receiver;//接收人
    private String groupId;//用户组编号
    private Integer msgtype;//请求1，应答2，通知3，响应4  format
    private Integer flag;//1 rsa加密 2aes加密
    private String platform;//mobile-ios mobile-android pc-windows pc-mac
    private String platformVersion;//客户端版本号
    private String token;//客户端凭证
    private String appKey;//客户端key
    private String timeStamp;//时间戳
    private String sign;//签名
    private ImMessageBody messageBody;//请求数据

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public Integer getCmd() {
        return cmd;
    }

    public void setCmd(Integer cmd) {
        this.cmd = cmd;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }

    public Integer getMsgtype() {
        return msgtype;
    }

    public void setMsgtype(Integer msgtype) {
        this.msgtype = msgtype;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    public String getPlatform() {
        return platform;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public String getPlatformVersion() {
        return platformVersion;
    }

    public void setPlatformVersion(String platformVersion) {
        this.platformVersion = platformVersion;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getAppKey() {
        return appKey;
    }

    public void setAppKey(String appKey) {
        this.appKey = appKey;
    }

    public String getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(String timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getSign() {
        return sign;
    }

    public void setSign(String sign) {
        this.sign = sign;
    }

    public ImMessageBody getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(ImMessageBody messageBody) {
        this.messageBody = messageBody;
    }
}
