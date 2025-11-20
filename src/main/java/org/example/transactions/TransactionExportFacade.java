package org.example.transactions;

import com.google.inject.Inject;
import com.google.inject.name.Named;
import java.io.FileWriter;
import java.util.Collection;
import java.util.Map;
import org.example.logger.Logger;
import org.example.serialization.Serialization;
import org.example.serialization.TransactionSerializationFactory;

/**
 * TransactionExportFacade
 */
public class TransactionExportFacade {

	@Inject
	TransactionRepository transactionRepository;
	@Inject
	TransactionSerializationFactory transactionSerializationFactory;
	@Inject
	@Named("TransactionJson")
	Serialization serialization;
	@Inject
	Logger logger;

	public void export(String filePath) {
		Map<String, Collection<Transaction>> transactions = transactionRepository.getTransactions();

		try {
			FileWriter writer = new FileWriter(filePath);
			transactions.forEach((key, transactionsForAccount) -> {
				transactionsForAccount.forEach((transaction) -> {
					try {
						writer.write(serialization.serialization(transaction));
					} catch (Exception e) {
						logger.log(e.getMessage());
					}
				});
			});
			writer.flush();
			writer.close();
		} catch (Exception e) {
			logger.log(e.getMessage());
		}
	}
}
