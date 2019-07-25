/**
 * 
 */
package com.zml.redisTemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zml.model.User;
import com.zml.service.UserService;

/**
 * @author zhangml
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class RedisTemplateTest {

	
	@Autowired
	private UserService userService;
	
	@Test
	public void test1() {
		String key ="zml";
		String result=userService.getString(key);
		System.out.println(result);
	}
	@Test
	public void test2() {
		int id=1;
		User user =userService.selectById(id);
		System.out.println(user);
	}
}
