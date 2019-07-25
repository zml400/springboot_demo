/**
 * 
 */
package com.zml.controller;


import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangml
 *
 */
@Controller
public class userController {
	
	@RequestMapping("/add")
	public String add() {
		return "user/add";
	}
	
	@RequestMapping("/update")
	public String update() {
		return "user/update";
	}
	@RequestMapping("/toLogin")
	public String toLogin() {
		return "/login";
	}
	@RequestMapping("/noAuth")
	public String noAuth() {
		return "/noAuth";
	}
	//登陆请求
	@RequestMapping("/login")
	public String login(String name,String password,Model model) {
		/**
		 * 使用shiro编写认证操作
		 */
		//1.获取Subject
		Subject subject = SecurityUtils.getSubject();
		
		//2.封装用户数据
		UsernamePasswordToken token = new UsernamePasswordToken(name,password);
		
		//3.执行登录方法
		try {
			subject.login(token);
			return "redirect:/index";
		} catch (UnknownAccountException e) {
			// TODO: handle exception
			model.addAttribute("msg", "用户不存在，请重新输入");
			return "login";
		}catch (IncorrectCredentialsException e) {
			// TODO: handle exception
			model.addAttribute("msg", "密码错误，请重新输入");
			return "login";
		}
	}
	@RequestMapping("/index")
	public String index() {
		return "index";
	}
	
}
