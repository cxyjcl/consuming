package cn.whpu.management.dto;

import cn.whpu.management.entity.Authority;

import java.io.Serializable;
import java.util.List;

/**
 * Created by cbjcl on 2016/12/6.
 */
public class Consumer implements Serializable {

    private int id;
    private String key;
    private String userName;
    private String realName;
    private String characterName;
    private List<Authority> authorities;
    private String department;
    private int status;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getCharacterName() {
        return characterName;
    }

    public void setCharacterName(String characterName) {
        this.characterName = characterName;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Consumer{" +
                "id=" + id +
                ", key='" + key + '\'' +
                ", userName='" + userName + '\'' +
                ", realName='" + realName + '\'' +
                ", characterName='" + characterName + '\'' +
                ", authorities=" + authorities +
                ", department='" + department + '\'' +
                ", status=" + status +
                '}';
    }
}
