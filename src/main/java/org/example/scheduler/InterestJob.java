package org.example.scheduler;

import com.google.inject.Inject;
import org.example.accounts.facades.InterestFacade;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * InterestJob
 */
public class InterestJob implements Job {

	@Inject InterestFacade interestFacade;

	@Override
	public void execute(JobExecutionContext context)
		throws JobExecutionException {
		try {
			interestFacade.interestAllSaveBankAccounts();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
