/**
 * 
 */
package com.zml.service;

import com.zml.model.User;

/**
 * @author zhangml
 *
 */
public interface IUserService {
	User findByName(String name);
	User findById(Integer id);
}
