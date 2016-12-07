package cn.whpu.management.service.impl;

import cn.whpu.management.dao.CharacterDao;
import cn.whpu.management.dao.UserDao;
import cn.whpu.management.dto.Consumer;
import cn.whpu.management.utils.Md5Utils;
import cn.whpu.management.utils.SerializeUtils;
import cn.whpu.management.vo.*;
import cn.whpu.management.entity.User;
import cn.whpu.management.service.UserService;
import cn.whpu.management.web.utils.VerifyCode;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Fiona on 2016/9/25.
 */
@Service
public class UserServiceImpl implements UserService {
    @Resource
    UserDao dao;
    @Resource
    CharacterDao character;

    @Resource
    protected JedisPool jedisPool;

    public UserServiceImpl() {

    }

    User user = new User();

    public String confrimLogin(Login login) {
        user.setUsername(login.getUsername());
        try {
            user.setPassword(Md5Utils.getMd(login.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        Consumer consumer = dao.findUser(user);
        if (consumer == null)
            return null;
        else {
            consumer.setKey(user.getId()+""+new Date()+""+VerifyCode.createCode(8).toString());
            System.out.println(consumer);
            jedisPool.getResource().setex(consumer.getKey().getBytes(),30*60, SerializeUtils.serialize(consumer));
            return consumer.getKey();
        }
    }

    public boolean changePassword(Forget forget) {
       // String code = (String) redisTemplate.opsForValue().get("code"+forget.getUsername());
//        user.setUsername(forget.getUsername());
//        try {
//            user.setPassword(Md5Utils.getMd(forget.getNewPassword()));
//        } catch (NoSuchAlgorithmException e) {
//            e.printStackTrace();
//        } catch (UnsupportedEncodingException e) {
//            e.printStackTrace();
//        }
//        if(code==null) {
//            return false;
//        }
//        else if(!code.equals(forget.getForgetCode())){
//            return false;
//        }
//        else{
//            dao.changePassword(user);
//            return true;
//        }
        return true;
    }

    public boolean sendEmail(Email email) {
        user.setUsername(email.getUsername());
        user = dao.findEmail(user);
        if(user!=null){
            StringBuffer code = VerifyCode.createCode(4);
            String content= email.getContent()+""+code;
//            MailUtils.send(content);
//            redisTemplate.boundValueOps("code"+user.getUsername()).set(code.toString(),30,TimeUnit.MINUTES);
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public int getUserId(String username) {
        return dao.getUserId(username);
    }

    @Override
    public void addUser(AddUser add) {
        user.setDepartment(add.getDepartment());
        try {
            user.setPassword(Md5Utils.getMd(add.getPassword()));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        user.setUsername(add.getUsername());
        user.setRealName(add.getRealName());
        user.setStatus(0);
        user.setEmail(add.getEmail());
        int id= character.getCharacterId(add.getCharacter());
        user.setCharacter_id(id);
        dao.addUser(user);
    }

}
