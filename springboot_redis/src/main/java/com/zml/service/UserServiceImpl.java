/**
 * 
 */
package com.zml.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import com.zml.model.User;

/**
 * @author zhangml
 *
 */
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	@Qualifier("redisTemplate")
	 private RedisTemplate<Object, Object> redisTemplate;
	@Resource(name = "redisTemplate")
	ListOperations<String, String> opsForList;
	
	/**
	 * 通过某个Key得到值
	 * 如果key在redis中存在，则在redis中查询
	 * 如果key在redis不存在，则去数据库查询
	 * @param key
	 * @return
	 */
	@Override
	public String getString(String key) {
		ValueOperations<Object,Object> string=redisTemplate.opsForValue();
		if(redisTemplate.hasKey(key)) {
			return string.get(key).toString();
		}else {
			//仿照从数据库中得到的result
			String result="张明明";
			//将从数据库中得到的数据存入redis
			string.set(key, result);
			System.out.println("从数据库中查询得到");
		}
		return null;
	}


	/**
	 * 将javaBean对象存储到redis中
	 * @param user
	 */
	@Override
	public void addUser(User user) {
		
		//将User对象存入redis的hash中
		redisTemplate.opsForHash().put("user", user.getId(), user);
		
	}
	
	@Override
	public User selectById(int id) {
		//判断redis中是否有key，若有从redis中读取 ，否则去数据库中读取
		User user = new User();
		if(redisTemplate.opsForHash().hasKey("user", id)) {
			user=(User)redisTemplate.opsForHash().get("user", id);
			System.out.println("从redis中读取");
		}else {
			user.setId(id);
			user.setName("zzzz");
			user.setAge(20);
			user.setLoginName("zml444");
			user.setLoginPssword("123456");
			redisTemplate.opsForHash().put("user", user.getId(), user);
			System.out.println("从数据中读取");
		}
		return user;
	}


	@Override
	public void listAdd() {
		String key="news";
		opsForList.leftPush(key, "aaaaa");
		opsForList.leftPush(key, "bbbbb");
		opsForList.leftPush(key, "ccccc");
		opsForList.leftPush(key, "ddddd");
		opsForList.leftPush(key, "eeeee");
		 
	}


	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	@Override
	public Object listRange(int pageNum,int pageSize) {
		String key="news";
		int start=(pageNum-1)*pageSize;
		int end=pageNum*pageSize-1;
		List<String> list = opsForList.range(key, start, end);
		long count=opsForList.size(key);
		System.out.println("当前记录数："+count);
		return list;
	}
	
	
}
