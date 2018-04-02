package hello.quartz;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

import java.util.Collection;
import java.util.Date;

public class Test {
    public static void main(String[] args) throws SchedulerException {


    }
    void ramJobTest() throws SchedulerException {
        SchedulerFactory schedulerFactory = new StdSchedulerFactory();
        Scheduler scheduler = schedulerFactory.getScheduler();
        JobDetail jobDetail = JobBuilder.newJob(RamJob.class)
                .withDescription("this is a ram job")
                .withIdentity("ramJob","ramGroup")
                .build();
        long time = System.currentTimeMillis()+3*1000L;
        Date startDate = new Date(time);
        Trigger t = TriggerBuilder.newTrigger().withDescription("").withIdentity("ramTrigger","ramTriggerGroup")
                .startAt(startDate).withSchedule(CronScheduleBuilder.cronSchedule("0/2 * * * * ?")).build();
        scheduler.scheduleJob(jobDetail,t);
        scheduler.start();
        System.out.println("启动：");
    }

}
