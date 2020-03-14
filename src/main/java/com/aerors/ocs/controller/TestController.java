package com.aerors.ocs.controller;

import java.util.List;

import javax.annotation.Resource;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.aerors.ocs.entity.ProcessInfo;
import com.aerors.ocs.mq.QueueSender;
import com.aerors.ocs.mq.TopicSender;
import com.aerors.ocs.service.ProcessInfoService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@Api(value = "TestController", description = "swagger测试")
@Controller
@RequestMapping(value = "/test")
public class TestController {
	
	Logger logger = LogManager.getLogger(TestController.class);
	
	@Resource private ProcessInfoService processInfoService;
	
	@Resource private QueueSender queueSender;
	@Resource private TopicSender topicSender;
//	
	@ApiOperation(httpMethod = "GET", value = "test", notes = "接口测试")
	@ApiImplicitParams({
		@ApiImplicitParam(paramType = "query",name="page",value = "页数",required = true,dataType = "int"),
		@ApiImplicitParam(paramType = "query",name="rows",value = "行数",required = true,dataType = "int")
	})
	@GetMapping(value = "/test")
	@ResponseBody
	public String test(int page,int rows) {
		logger.debug("debug ");
		logger.info("info ");
		logger.error(" error");
		ProcessInfo pi = new ProcessInfo();
		pi.setId(2285);
		pi.setLevel("111");
		pi.setProcessid("1113");
		pi.setOutprocessid("121");
		
		
		processInfoService.update(pi);
		
		
		String sql="from ProcessInfo where 1 = 1";
		
		List<T> list =  processInfoService.queryByHql(sql);
		System.out.println("1111");
		return "This is a swagger-ui test";
	}
	
	
	
	@ApiOperation(httpMethod = "Post", value = "activeMQTest", notes = "activeMQTest")
	@PostMapping(value = "/activeMQTest")
	@ResponseBody
	public String activeMQTest() {
		
		queueSender.send("ocs.Queue", "activeMQ Queue test");
//		
		topicSender.send("ocs.Topic",  "activeMQ topic test");
		return "This is a activeMQ test";
	}

}
