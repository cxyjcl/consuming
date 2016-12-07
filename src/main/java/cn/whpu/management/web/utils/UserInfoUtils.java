package cn.whpu.management.web.utils;

import cn.whpu.management.dto.Consumer;
import cn.whpu.management.utils.SerializeUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import redis.clients.jedis.JedisPool;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import static cn.whpu.management.utils.SerializeUtils.unserialize;

/**
 * Created by cbjcl on 2016/12/7.
 */
@Controller()
@RequestMapping("/info")
public class UserInfoUtils {

    @Resource
    protected JedisPool jedisPool;

    @RequestMapping("/user")
    @ResponseBody()
    public Consumer getUser(HttpSession session){
        String key = session.getAttribute("key").toString();
        Consumer consumer = (Consumer) SerializeUtils.unserialize(jedisPool.getResource().get(key.getBytes()));
        System.out.println(consumer);
        return consumer;
    }
}
