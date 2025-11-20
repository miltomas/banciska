package org.example;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;
import org.example.logger.ConsoleLogger;
import org.example.logger.Logger;
import org.example.serialization.BankAccountOwnerJsonSerializationService;
import org.example.serialization.BankAccountOwnerXmlSerializationService;
import org.example.serialization.Serialization;
import org.example.serialization.TransactionJsonSerializationService;

/**
 * BankInjector
 */
public class BankInjector extends AbstractModule {

	@Override
	protected void configure() {
		this.bind(Logger.class).to(ConsoleLogger.class);
		this.bind(Serialization.class)
				.annotatedWith(Names.named("BankAccountOwnerJson"))
				.to(BankAccountOwnerJsonSerializationService.class);
		this.bind(Serialization.class)
				.annotatedWith(Names.named("BankAccountOwnerXml"))
				.to(BankAccountOwnerXmlSerializationService.class);
		this.bind(Serialization.class)
				.annotatedWith(Names.named("TransactionJson"))
				.to(TransactionJsonSerializationService.class);
	}
}
