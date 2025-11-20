package org.example.scheduler;

import com.google.inject.Inject;
import org.example.transactions.TransactionExportFacade;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

/**
 * InterestJob
 */
public class TransactionExportJob implements Job {

	@Inject
	TransactionExportFacade transactionExportFacade;

	@Override
	public void execute(JobExecutionContext context)
			throws JobExecutionException {
		try {
			transactionExportFacade.export("export.json");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
