/**
 * 
 */
package com.zml.shiro;

import java.util.LinkedHashMap;
import java.util.Map;

import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;

/**
 * @author zhangml
 *
 */
@Configuration
public class ShiroConfig {

	/**
	 * 1.创建ShiroFilterFactoryBean
	 */
	@Bean
	public ShiroFilterFactoryBean getShiroFilterFactoryBean(@Qualifier("securityManager")SecurityManager securityManager) {
		ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
		
		
		
		//设置安全管理器
		shiroFilterFactoryBean.setSecurityManager(securityManager);
		
		//添加Shiro内置过滤器
		/**
		 * Shiro内置过滤器，可以实现权限相关的拦截器
		 * 	常用的过滤器：
		 * 		anon：无需认证（登陆）可以访问
		 * 		authc:必须认证才可以访问
		 * 		user:如果使用rememberMe的功能可以直接访问
		 * 		perms:该资源必须得到资源权限才可以访问
		 * 		role:该资源必须得到角色权限才可以访问
		 */
		Map<String, String> filteMap = new LinkedHashMap<String, String>();
		//页面过滤（强制登陆）
		filteMap.put("/add","authc");
		filteMap.put("/update","authc");
		//跳转到toLogin页面（默认跳转到login.jsp）
		shiroFilterFactoryBean.setLoginUrl("/toLogin");
		
		
		//授权过滤器(授权拦截)
		//注意：当前授权拦截后，shiro会自动跳转到未授权提示页面
		filteMap.put("/add","perms[user:add]");
		filteMap.put("/update","perms[user:update]");
		
		//设置未授权提示页面
		shiroFilterFactoryBean.setUnauthorizedUrl("/noAuth");
		
		shiroFilterFactoryBean.setFilterChainDefinitionMap(filteMap);
		
		
		
		
		return shiroFilterFactoryBean;
	}
	
	/**
	 * 2.创建DefaultWebSecurityManager
	 */
	@Bean(name = "securityManager")
	public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm")UserRealm userRealm) {
		DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
		securityManager.setRealm(userRealm);
		return securityManager;
	}
	
	/**
	 * 3.创建Realm
	 */
	@Bean(name = "userRealm")
	public UserRealm getRealm() {
		return new UserRealm();
	}
	
	/**
	 * 配置shiroDialect，用于thymeleaf和shiro标签配合使用
	 * 
	 */
	@Bean
	public ShiroDialect getShiroDialect() {
		return new ShiroDialect();
	}
}
