package com.kfit.task;

import java.util.Date;

import org.springframework.scheduling.Trigger;
import org.springframework.scheduling.TriggerContext;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 思路：
 * 1、 新建一个task class.
 * 2、在class上添加注解 @EnableScheduling
 * 3、让我们的class实现接口 SchedudingConfigurer;
 * 4、实现SchedudingConfigurer中的方法.
 * 
 * @author Angel -- 守护天使
 * @version v.0.1
 * @date 2017年4月8日
 */

@RestController
@EnableScheduling
public class TaskCronChange implements SchedulingConfigurer{

	//秒，分钟，小时，日期，月份，星期，年（可选）.
	private String expression = "0/5 * * * * *";//每5秒执行一下定时任务.
	
	@RequestMapping("/changeExpression")
	public String changeExpression(){
		expression = "0/10 * * * * *";//每10秒执行一下定时任务.
		return "changeExpression";
	}
	
	
	@Override
	public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
		
		Runnable task = new Runnable() {
			
			@Override
			public void run() {
				System.out.println("configureTasks.run,"+new Date());
			}
		};
		Trigger trigger = new Trigger() {
			
			@Override
			public Date nextExecutionTime(TriggerContext triggerContext) {
				CronTrigger cronTrigger = new CronTrigger(expression);
				return cronTrigger.nextExecutionTime(triggerContext);
			}
		};
		taskRegistrar.addTriggerTask(task, trigger);
		
	}

}
