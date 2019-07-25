package com.zml.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.zml.service.IMqttSender;

@Controller
@RequestMapping(value = "/")
public class MqttController {

	/**
	* 注入发送MQTT的Bean
	*/
	@Resource
	private IMqttSender iMqttSender;
	
	/**
	 * 
	 * @param message
	 * @return
	*/
	@ResponseBody
	@RequestMapping(value = "/mqtt")
	public String sendMqtt(@RequestParam(value = "msg") String message) {
		iMqttSender.sendToMqtt("defualtTopic:"+message);
		return "OK";
	}
}
