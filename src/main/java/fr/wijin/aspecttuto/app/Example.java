package fr.wijin.aspecttuto.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import fr.wijin.aspecttuto.config.AppConfig;
import fr.wijin.aspecttuto.service.TransferService;

public class Example {

	public static void main(String[] args) {
		ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
		TransferService transferService = context.getBean(TransferService.class);

		try {
			transferService.transfer("accountOne", "accountTwo", 5000L);
			System.out.println("Balance: " + transferService.checkBalance("accountOne"));
			transferService.deposite("accountOne", 2000L);
			System.out.println("Withdrawal: " + transferService.withdrawal("accountTwo", 1500L));
		} catch (Exception e) {
			System.out.println("Exception caught in main: " + e.getMessage());
		}
	}
}
