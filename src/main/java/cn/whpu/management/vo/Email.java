package cn.whpu.management.vo;

/**
 * Created by Fiona on 2016/10/22.
 */
public class Email {

    private String username;
    private String content;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "Email{" +
                "username='" + username + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
