package cn.whpu.management.service;

import cn.whpu.management.vo.AddUser;
import cn.whpu.management.vo.Email;
import cn.whpu.management.vo.Forget;
import cn.whpu.management.vo.Login;

/**
 * Created by Fiona on 2016/9/25.
 */
public interface UserService {

    /**
     * 验证登录
     * username
     * password
     * @param login
     * @return
     */
    public String confrimLogin(Login login);

    public boolean changePassword(Forget forget);

    public boolean sendEmail(Email email);

    public int getUserId(String username);

    public void addUser(AddUser add);

//    public  getRejectInfo();
}
