/**
 * 
 */
package com.zml.shiro;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;

import com.zml.model.User;
import com.zml.service.IUserService;

/**
 * 自定义Realm
 * @author zhangml
 *
 */
public class UserRealm extends AuthorizingRealm{

	@Autowired
	private IUserService userService;
	/**
	 * 执行授权逻辑
	 * @param principals
	 * @return
	 */
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		System.out.println("执行授权逻辑");
		//给资源授权
		SimpleAuthorizationInfo info=new SimpleAuthorizationInfo();
		
		//添加资源的授权字符串
		//info.addStringPermission("user:add");
		
		
		//到数据库查询当前登陆用户的授权字符串
		//获取当前登陆用户
		Subject subject = SecurityUtils.getSubject();
		User user = (User)subject.getPrincipal();
		User user2=userService.findById(user.getId());
		info.addStringPermission(user2.getPerms());
		return info;
	}

	/**
	 * 执行认证逻辑
	 * @param token
	 * @return
	 * @throws AuthenticationException
	 */
	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
		
		UsernamePasswordToken token2 = (UsernamePasswordToken)token;
		User user =userService.findByName(token2.getUsername());
		if(user==null) {
			//用户名不存在
			return null;  //shiro底层会抛出UnKnowAccountException
		}
		//2.判断密码
		return new SimpleAuthenticationInfo(user, user.getPassword(), "");
	}

	
	
}
