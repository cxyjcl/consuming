package cn.whpu.management.vo;

/**
 * Created by Fiona on 2016/9/28.
 */
public class Forget {

    private String username;
    private String newPassword;
    private String forgetCode;


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getForgetCode() {
        return forgetCode;
    }

    public void setForgetCode(String forgetCode) {
        this.forgetCode = forgetCode;
    }

    @Override
    public String toString() {
        return "Forget{" +
                "username='" + username + '\'' +
                ", newPassword='" + newPassword + '\'' +
                ", forgetCode='" + forgetCode + '\'' +
                '}';
    }
}
