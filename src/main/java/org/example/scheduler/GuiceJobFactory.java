package org.example.scheduler;

import com.google.inject.Injector;
import org.quartz.spi.JobFactory;
import org.quartz.spi.TriggerFiredBundle;
import org.quartz.SchedulerException;
import org.quartz.Job;

public class GuiceJobFactory implements JobFactory {

    private final Injector injector;

    public GuiceJobFactory(Injector injector) {
        this.injector = injector;
    }

    @Override
    public Job newJob(TriggerFiredBundle bundle, org.quartz.Scheduler scheduler) throws SchedulerException {
        // Let Guice create the Job instance (with all dependencies injected)
        return injector.getInstance(bundle.getJobDetail().getJobClass());
    }
}
