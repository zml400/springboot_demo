/**
 * 
 */
package com.zml.mapper;

import com.zml.model.User;

/**
 * @author zhangml
 *
 */
public interface UserMapper {
	public User findByName(String name);
	public User findById(Integer id);
}
