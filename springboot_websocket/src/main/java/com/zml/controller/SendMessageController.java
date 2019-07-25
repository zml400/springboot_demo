package com.zml.controller;

import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author zhangml
 *
 */
@Controller
@RequestMapping("/socket")
public class SendMessageController {
	//推送数据接口
	@ResponseBody
	@RequestMapping("/push/{clientId}")
	public String pushToWeb(@PathVariable String clientId,String message) {  
		try {
			WebSocketServer.sendInfo(message,clientId);
		} catch (IOException e) {
			e.printStackTrace();
			return "error:clientId="+clientId+"#"+e.getMessage();
		}  
		return "success:clientId="+clientId;
	} 
}
