package cn.bill.rediscluster;

import java.util.HashSet;
import java.util.Set;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Description: Java访问Redis集群<br/>
 * Date:2018年8月20日 下午2:45:59 <br/>
 *
 * @author fengminbiao@126.com
 * @version
 */

public class RedisClusterDemo
{

	@SuppressWarnings("resource")
	public static void main(String[] args)
	{
		Set<HostAndPort> jedisClusterNodes = new HashSet<>();
		jedisClusterNodes.add(new HostAndPort("192.168.1.26", 8001));
		jedisClusterNodes.add(new HostAndPort("192.168.1.26", 8002));
		jedisClusterNodes.add(new HostAndPort("192.168.1.26", 8003));
		jedisClusterNodes.add(new HostAndPort("192.168.1.26", 8004));
		jedisClusterNodes.add(new HostAndPort("192.168.1.26", 8005));
		jedisClusterNodes.add(new HostAndPort("192.168.1.26", 8006));
		
		JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
		//最大连接数, 默认8个
		jedisPoolConfig.setMaxTotal(100);
		//最大空闲连接数, 默认8个
		jedisPoolConfig.setMaxIdle(10);
		//在获取连接的时候检查有效性, 默认false
		jedisPoolConfig.setTestOnBorrow(true);
		
		JedisCluster jedisCluster = new JedisCluster(jedisClusterNodes,600,10,jedisPoolConfig);
		System.out.println(jedisCluster.set("aabb", "哈哈aabb"));
		System.out.println(jedisCluster.get("aabb"));
		
	}

}
