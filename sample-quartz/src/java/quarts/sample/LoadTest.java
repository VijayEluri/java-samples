/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package quarts.sample;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleTrigger;

import java.util.Date;


/**
 *
 * @author funato
 * @createted 2005/05/19
 */
public class LoadTest {
    public static void loadTest(SchedulerFactory sf) throws Exception {
        Log log = LogFactory.getLog(LoadTest.class);

        Scheduler sched = sf.getScheduler();
        int count = 1;

        for (; count <= 10; count++) {
            JobDetail job =
                new JobDetail("job_" + count, "grp_1", TestJob.class);

            job.setRequestsRecovery(true);

            SimpleTrigger trigger = new SimpleTrigger("trig_" + count, "grp_1");
            trigger.setStartTime(new Date(System.currentTimeMillis() + 10000L
                                          + (count * 100)));

            log.info(job.getFullName() + " will run at: " +
             trigger.getNextFireTime() + " & repeat: " +
             trigger.getRepeatCount() + "/" + trigger.getRepeatInterval());
            sched.scheduleJob(job, trigger);
        }

        log.info("Finished scheduling " + count + " jobs.");

        log.info("------- Starting Scheduler ----------------");

        sched.start();
        log.info("------- Started Scheduler -----------------");

        log.info("------- Waiting... -----------------------");

        try {
            Thread.sleep(30L * 1000L);
        } catch (Exception e) {}

        log.info("------- Shutting Down ---------------------");

        sched.shutdown();

        log.info("------- Shutdown Complete -----------------");
    }

    public static void main(String[] args) {
        try {
            loadTest(new org.quartz.impl.StdSchedulerFactory());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
