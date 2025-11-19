package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;
import org.example.scheduler.GuiceJobFactory;
import org.quartz.*;
import org.quartz.Scheduler;
import org.quartz.impl.StdSchedulerFactory;

public class Main {

	public static void main(String[] args) {
		// App app = new App();
		// app.run();

		Injector injector = Guice.createInjector(new BankInjector());

		try {
			Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
			scheduler.setJobFactory(new GuiceJobFactory(injector));
			scheduler.start();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		App app = injector.getInstance(App.class);
		app.run();
	}
}
