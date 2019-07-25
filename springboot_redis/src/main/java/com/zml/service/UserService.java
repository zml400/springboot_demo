/**
 * 
 */
package com.zml.service;

import com.zml.model.User;

/**
 * @author zhangml
 *
 */
public interface UserService {

	/**
	 * string存和取测试
	 * @param key
	 * @return
	 */
	public String getString(String key);
	
	public void addUser(User user);
	public User selectById(int id);
	
	
	/**
	 * LIST类型的案例操作
	 */
	
	public void listAdd();
	public Object listRange(int pageNum,int pageSize);
}
