/**
 * 
 */
package com.zml.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zml.mapper.UserMapper;
import com.zml.model.User;

/**
 * @author zhangml
 *
 */
@Service
public class UserServiceImpl implements IUserService{

	@Autowired
	private UserMapper usermapper;
	/**
	 * @param name
	 * @return
	 */
	@Override
	public User findByName(String name) {
		
		return usermapper.findByName(name);
	}
	@Override
	public User findById(Integer id) {
		return usermapper.findById(id);
	}

}
