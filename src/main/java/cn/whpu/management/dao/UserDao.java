package cn.whpu.management.dao;

import cn.whpu.management.dto.Consumer;
import cn.whpu.management.entity.User;

import java.util.ArrayList;

/**
 * Created by Fiona on 2016/9/25.
 */
public interface UserDao {
    public Consumer findUser(User user);

    public User findEmail(User user);

    public void changePassword(User user);

    public int getUserId(String username);

    public void addUser(User user);
}
