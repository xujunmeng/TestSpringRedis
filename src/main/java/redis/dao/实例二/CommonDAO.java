package redis.dao.实例二;

import redis.obj.User;

import java.util.Map;
import java.util.Set;

/**
 * Created by james on 2017/6/13.
 */
public interface CommonDAO {

    boolean exists(String key, String value);

    Set<String> getSerialNumber(String key);

    Long setSerialNumber(String key, String value);

    boolean liveTime(String key, long timeout);

    void opsForHashPutAll(String key, Map map);

    User opsForHashGet(String key, String hashKey);
}
