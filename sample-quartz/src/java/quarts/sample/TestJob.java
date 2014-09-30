/*
 * Copyright (c) 2005 ATL Systems incorporated.
 * All rights reserved.
 */
package quarts.sample;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * 
 * @author funato
 * @createted 2005/05/19
 */
public class TestJob implements Job {

    /**
     * @see org.quartz.Job#execute(org.quartz.JobExecutionContext)
     */
    public void execute(JobExecutionContext arg0) throws JobExecutionException {
        System.out.println("Job‚ªŒÄ‚Î‚ê‚½‚æ");
    }

}
