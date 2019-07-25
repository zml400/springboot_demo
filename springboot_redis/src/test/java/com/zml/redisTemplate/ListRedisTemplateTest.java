/**
 * 
 */
package com.zml.redisTemplate;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.zml.service.UserService;

/**
 * @author zhangml
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ListRedisTemplateTest {

	@Autowired
	private UserService userService;
	@Test
	public void test1() {
		userService.listAdd();
		List<String> list = (List<String>)userService.listRange(1,3);
		for(String s:list) {
			System.out.println(s);
		}
	}
}
