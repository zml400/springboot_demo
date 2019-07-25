/**
 * 
 */
package com.zml.model;

import java.io.Serializable;

import lombok.Data;

/**
 * @author zhangml
 *
 */
@Data
public class User implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;
	private String name;
	private int age;
	private String loginName;
	private String loginPssword;
}
