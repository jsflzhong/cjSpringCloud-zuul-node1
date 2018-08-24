package com.michael.springBoot.domain;

import javax.persistence.*;

@Table(name = "t_s_base_user")
public class TSBaseUser {
    /**
     * ID
     */
    @Id
    @Column(name = "ID")
    private String id;

    /**
     * 同步流程
     */
    @Column(name = "activitiSync")
    private Short activitisync;

    /**
     * 浏览器
     */
    private String browser;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实名字
     */
    private String realname;

    /**
     * 有效状态
     */
    private Short status;

    /**
     * 用户KEY
     */
    private String userkey;

    /**
     * 用户账号
     */
    private String username;

    /**
     * 部门ID
     */
    private String departid;

    /**
     * 删除状态
     */
    @Column(name = "delete_flag")
    private Short deleteFlag;

    /**
     * NC的人员编码
     */
    @Column(name = "nc_code")
    private String ncCode;

    /**
     * 用户的头像对应的t_s_fileinfo表的id
     */
    @Column(name = "portrait_id")
    private String portraitId;

    /**
     * 工号
     */
    @Column(name = "job_number")
    private String jobNumber;

    /**
     * 签名
     */
    private byte[] signature;

    /**
     * 获取ID
     *
     * @return ID - ID
     */
    public String getId() {
        return id;
    }

    /**
     * 设置ID
     *
     * @param id ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 获取同步流程
     *
     * @return activitiSync - 同步流程
     */
    public Short getActivitisync() {
        return activitisync;
    }

    /**
     * 设置同步流程
     *
     * @param activitisync 同步流程
     */
    public void setActivitisync(Short activitisync) {
        this.activitisync = activitisync;
    }

    /**
     * 获取浏览器
     *
     * @return browser - 浏览器
     */
    public String getBrowser() {
        return browser;
    }

    /**
     * 设置浏览器
     *
     * @param browser 浏览器
     */
    public void setBrowser(String browser) {
        this.browser = browser == null ? null : browser.trim();
    }

    /**
     * 获取密码
     *
     * @return password - 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置密码
     *
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 获取真实名字
     *
     * @return realname - 真实名字
     */
    public String getRealname() {
        return realname;
    }

    /**
     * 设置真实名字
     *
     * @param realname 真实名字
     */
    public void setRealname(String realname) {
        this.realname = realname == null ? null : realname.trim();
    }

    /**
     * 获取有效状态
     *
     * @return status - 有效状态
     */
    public Short getStatus() {
        return status;
    }

    /**
     * 设置有效状态
     *
     * @param status 有效状态
     */
    public void setStatus(Short status) {
        this.status = status;
    }

    /**
     * 获取用户KEY
     *
     * @return userkey - 用户KEY
     */
    public String getUserkey() {
        return userkey;
    }

    /**
     * 设置用户KEY
     *
     * @param userkey 用户KEY
     */
    public void setUserkey(String userkey) {
        this.userkey = userkey == null ? null : userkey.trim();
    }

    /**
     * 获取用户账号
     *
     * @return username - 用户账号
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置用户账号
     *
     * @param username 用户账号
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 获取部门ID
     *
     * @return departid - 部门ID
     */
    public String getDepartid() {
        return departid;
    }

    /**
     * 设置部门ID
     *
     * @param departid 部门ID
     */
    public void setDepartid(String departid) {
        this.departid = departid == null ? null : departid.trim();
    }

    /**
     * 获取删除状态
     *
     * @return delete_flag - 删除状态
     */
    public Short getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 设置删除状态
     *
     * @param deleteFlag 删除状态
     */
    public void setDeleteFlag(Short deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 获取NC的人员编码
     *
     * @return nc_code - NC的人员编码
     */
    public String getNcCode() {
        return ncCode;
    }

    /**
     * 设置NC的人员编码
     *
     * @param ncCode NC的人员编码
     */
    public void setNcCode(String ncCode) {
        this.ncCode = ncCode == null ? null : ncCode.trim();
    }

    /**
     * 获取用户的头像对应的t_s_fileinfo表的id
     *
     * @return portrait_id - 用户的头像对应的t_s_fileinfo表的id
     */
    public String getPortraitId() {
        return portraitId;
    }

    /**
     * 设置用户的头像对应的t_s_fileinfo表的id
     *
     * @param portraitId 用户的头像对应的t_s_fileinfo表的id
     */
    public void setPortraitId(String portraitId) {
        this.portraitId = portraitId == null ? null : portraitId.trim();
    }

    /**
     * 获取工号
     *
     * @return job_number - 工号
     */
    public String getJobNumber() {
        return jobNumber;
    }

    /**
     * 设置工号
     *
     * @param jobNumber 工号
     */
    public void setJobNumber(String jobNumber) {
        this.jobNumber = jobNumber == null ? null : jobNumber.trim();
    }

    /**
     * 获取签名
     *
     * @return signature - 签名
     */
    public byte[] getSignature() {
        return signature;
    }

    /**
     * 设置签名
     *
     * @param signature 签名
     */
    public void setSignature(byte[] signature) {
        this.signature = signature;
    }
}