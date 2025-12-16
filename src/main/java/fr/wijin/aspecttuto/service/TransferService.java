package fr.wijin.aspecttuto.service;

public interface TransferService {
	void transfer(String accountA, String accountB, Long amount);

	Double checkBalance(String account);

	Long withdrawal(String account, Long amount);

	void deposite(String account, Long amount) throws Exception;
}
