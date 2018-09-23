package com.lanhu.work.task;

import java.util.Date;

import org.redisson.api.RLock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.lanhu.work.locker.DistributedLocker;

//@Component
public class Task {
	
	@Autowired
	private DistributedLocker distributedLocker;
	
	private int a =0;
	
	@Scheduled(fixedDelayString = "1")
	public void task1() throws InterruptedException {
		long start = new Date().getTime();
		try {
			 distributedLocker.lock("lock");
			 Thread.sleep(10000);
			 a=a+1;
			 System.out.println("="+a);
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			distributedLocker.unlock("lock");
		}
	   
		long end = new Date().getTime();
		//System.out.println("task1执行时间:" + (end-start));
	}
	
	@Scheduled(fixedDelay = 1)
	public void task2() throws InterruptedException {
		long start = new Date().getTime();
		try {
			 distributedLocker.lock("lock");
			 a=a+1;
			 System.out.println("+"+a);
		}catch (Exception e) {
			// TODO: handle exception
		}finally {
			distributedLocker.unlock("lock");
		}
		long end = new Date().getTime();
	//	System.out.println("task2执行时间:" + (end-start));
	}

}
