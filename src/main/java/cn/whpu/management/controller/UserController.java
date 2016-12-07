package cn.whpu.management.controller;

import cn.whpu.management.exception.Message;
import cn.whpu.management.utils.LogManager;
import cn.whpu.management.vo.AddUser;
import cn.whpu.management.vo.Email;
import cn.whpu.management.vo.Forget;
import cn.whpu.management.vo.Login;
import cn.whpu.management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.mail.MessagingException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;

/**
 * Created by Fiona on 2016/9/23.
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserService service;

    Map map= new HashMap();
    /**
     *
     * @param login
     * @param session
     * @return
     * @throws IOException
     * 登录验证
     */
    @RequestMapping(
            method=RequestMethod.POST,
            consumes="application/json",
            value = "/login.do")
    @ResponseBody
    public Map comfirmLogin(@RequestBody Login login, HttpSession session) throws IOException {
        String realCode = session.getAttribute("generateCode").toString();
        if (!realCode.equalsIgnoreCase(login.getVerifyCode())){
            map.put("code",Message._10001.getCode());
            map.put("content",Message._10001.getMessage());
            return map;
        }
        else {
            System.out.println(service.confrimLogin(login));
            String key = service.confrimLogin(login);
            if(key!=null) {
                session.setAttribute("key",key);
                session.setMaxInactiveInterval(60*30);
                map.put("code",Message._10000.getCode());
                map.put("content",Message._10000.getMessage());
                return map;
            }
            else{
                map.put("code",Message._10005.getCode());
                map.put("content",Message._10005.getMessage());
                return map;
            }
        }
    }

    /**
     *
     * @param email
     * @return
     * 找回密码的代码
     */
    @RequestMapping("/sendEmail.do")
    @ResponseBody
    public Map forget(@RequestBody Email email) {
        if (service.sendEmail(email)) {
            map.put("code", Message._10006.getCode());
            map.put("content", Message._10006.getMessage());
            return map;
        } else {
            map.put("code", Message._10003.getCode());
            map.put("content", Message._10003.getMessage());
            return map;
        }
    }

    @RequestMapping(value = "/forgetPassword.do")
    @ResponseBody()
    public Map change(@RequestBody Forget forget){
        if(service.changePassword(forget)){
            map.put("code",Message._10007.getCode());
            map.put("content",Message._10007.getMessage());
        }
        else{
            map.put("code",Message._10001.getCode());
            map.put("content",Message._10001.getMessage());
        }
        return map;
    }

    @RequestMapping(value = "/addUser.do")
    @ResponseBody()
    public Map add(@RequestBody AddUser add){
        service.addUser(add);
        map.put("code",Message._10001.getCode());
        map.put("content",Message._10001.getMessage());
        return map;
    }
}