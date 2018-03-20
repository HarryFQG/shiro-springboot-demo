package com.kfit.demo.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.kfit.demo.bean.Demo;
import com.kfit.demo.mapper.DemoMapper;
import com.kfit.demo.service.DemoService;

@RestController
public class DemoController {
	
	@Autowired
	private DemoService demoService;
	@Autowired
	private DemoMapper demoMapper;//实际项目不建议这么做，这里只是为了测试方便.
	
	@RequestMapping("/save")
	public Demo save(Demo demo){
		int rs = demoService.save(demo);
		System.out.println("rs-->"+rs);
		return demo;
	}
	
	
	@RequestMapping("/update")
	public Demo update(Demo demo){
		int rs = demoService.update(demo);
		System.out.println("rs-->"+rs);
		return demo;
	}
	
	@RequestMapping("/update2")
	public Demo update2(Demo demo){
		int rs = demoService.update2(demo);
		System.out.println("rs-->"+rs);
		return demo;
	}
	
	@RequestMapping("/delete")
	public int delete(int id){
		int rs = demoService.delete(id);
		System.out.println("rs-->"+rs);
		return rs;
	}
	
	
	@RequestMapping("/selectAll")
	public List<Demo> selectAll(int pageNum,int pageSize){
		//pageNum:页码，pageSize:每页显示的条数.
		PageHelper.startPage(pageNum, pageSize);
		return demoService.selectAll();
	}
	
	@RequestMapping("/selectById")
	public Demo selectById(int id){
		Demo demo = demoService.selectById(id);
		if(demo == null){ //这并不是实际开发的代码 ---> 实际的时候，需要抛出异常，或者直接返回错误编码，no found.
			demo = new Demo();
			demo.setId(0);
			demo.setName("no found");
		}
		return demo;
	}
	
	@RequestMapping("/select1")
	public List<Demo> select1(String name,String email){
		return demoMapper.select1(name, email);
	}
	
	@RequestMapping("/select3")
	public List<Demo> select3(String name,String email){
		return demoMapper.select3(name, email);
	}
	
	@RequestMapping("/select5")
	public List<Demo> select5(Integer[] id){
		return demoMapper.select5(Arrays.asList(id));
	}
}

