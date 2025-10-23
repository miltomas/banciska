package org.example;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class Main {

	public static void main(String[] args) {
		// App app = new App();
		// app.run();

		Injector injector = Guice.createInjector(new BankInjector());
		App app = injector.getInstance(App.class);
		app.run();
	}
}
