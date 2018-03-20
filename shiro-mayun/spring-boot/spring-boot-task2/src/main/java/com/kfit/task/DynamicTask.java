package com.kfit.task;

import java.util.Date;
import java.util.concurrent.ScheduledFuture;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableScheduling
public class DynamicTask {

	@Autowired
	private ThreadPoolTaskScheduler threadPoolTaskScheduler;	
	
	private ScheduledFuture<?> future;
	
	@Bean
	public ThreadPoolTaskScheduler threadPoolTaskScheduler(){
		return new ThreadPoolTaskScheduler();
	}
	
	
	/**
	 * 1、定一个方法：startTask-启动定时任务;
	 * 2、定义一个方法：stopTask - 停止定时任务;
	 * 3、定义一个方法：changeCron  - 修改定时任务时间：
	 */
	
	//1、定一个方法：startTask-启动定时任务;
	@RequestMapping("/startTask")
	public String startTask(){
		//秒，分钟，小时，日期，月份，星期，年（可选）.
		//每5秒执行一次定时任务.
		future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger("0/5 * * * * *"));
		System.out.println("start Task");
		return "startTask";
	}
	
	//2、定义一个方法：stopTask - 停止定时任务;
	@RequestMapping("/stopTask")
	public String stopTask(){
		if(future != null){
			future.cancel(true);
		}
		System.out.println("stop task");
		return "stopTask";
	}
	
	// 3、定义一个方法：changeCron  - 修改定时任务时间：
	@RequestMapping("/changeCron")
	public String changeCron(){
		//(1) 先停止定时器； （2）在启动定时器.
		stopTask();
		//每10秒执行一次定时任务.
		future = threadPoolTaskScheduler.schedule(new MyRunnable(), new CronTrigger("0/10 * * * * *"));
		System.out.println("change Cron");
		return "changeCron";
	}
	
	
	private class MyRunnable implements Runnable{
		@Override
		public void run() {
			System.out.println("MyRunable.run,"+new Date());
		}
		
	}
}
