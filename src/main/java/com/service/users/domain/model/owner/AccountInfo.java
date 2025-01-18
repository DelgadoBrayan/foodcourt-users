package com.service.users.domain.model.owner;

public class AccountInfo {
    private String password;
    private Long roleId;

    public AccountInfo(String password, Long roleId) {
        this.password = password;
        this.roleId = roleId;
    }
    
    public AccountInfo() {}

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    @Override
    public String toString() {
        return "AccountInfo [password=" + password + ", roleId=" + roleId + "]";
    }

    
    
}
