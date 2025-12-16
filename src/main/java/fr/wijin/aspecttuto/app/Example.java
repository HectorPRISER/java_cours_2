package fr.wijin.aspecttuto.app;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import fr.wijin.aspecttuto.config.AppConfig;
import fr.wijin.aspecttuto.service.TransferService;

public class Example {

	/**
	 * Test method: run time discovery can be intercepted
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
		TransferService transferService = applicationContext.getBean(TransferService.class);
		try {
			transferService.transfer("accountOne", "accountTwo", 50000l);
			System.out.println("Available balance: " + transferService.checkBalance("accountOne"));
			transferService.deposite("accountOne", 50000l);
			System.out.println("Withdrawal amount: " + transferService.withdrawal("accountTwo", 40000l));
		} catch (Exception e) {
			System.out.println("Gestion exception !");
		}
	}
}
