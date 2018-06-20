package redis.dao.实例二.impl;

import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.dao.实例二.CommonDAO;
import redis.obj.User;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by james on 2017/6/13.
 */
public class CommonDAOImpl implements CommonDAO {

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate jdkSerializerRedisTemplate;

    @Override
    public boolean exists(String key, String value) {
        return stringRedisTemplate.opsForSet().isMember(key, value);
    }

    @Override
    public Set<String> getSerialNumber(String key) {
        return stringRedisTemplate.opsForSet().members(key);
    }


    @Override
    public Long setSerialNumber(String key, String value) {
        return stringRedisTemplate.opsForSet().add(key, value);
    }

    @Override
    public boolean liveTime(String key, long timeout) {
        return stringRedisTemplate.expire(key, timeout, TimeUnit.SECONDS);
    }

    @Override
    public void opsForHashPutAll(String key, Map map) {
        jdkSerializerRedisTemplate.opsForHash().putAll(key, map);
    }

    @Override
    public User opsForHashGet(String key, String hashKey) {
        return (User) jdkSerializerRedisTemplate.opsForHash().get(key, hashKey);
    }
}
