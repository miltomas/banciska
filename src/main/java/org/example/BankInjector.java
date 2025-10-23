package org.example;

import com.google.inject.AbstractModule;
import org.example.logger.ConsoleLogger;
import org.example.logger.Logger;

/**
 * BankInjector
 */
public class BankInjector extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(Logger.class).to(ConsoleLogger.class);
	}
}
