package fr.wijin.aspecttuto.service;

import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {

	@Override
	public void transfer(String accountA, String accountB, Long amount) {
		System.out.println(amount + " has been transferred from " + accountA + " to " + accountB);
	}

	@Override
	public Double checkBalance(String account) {
		System.out.println("Checking balance of account " + account);
		return 10000.0;
	}

	@Override
	public Long withdrawal(String account, Long amount) {
		System.out.println(amount + " has been withdrawn from " + account);
		return amount;
	}

	@Override
	public void deposite(String account, Long amount) throws Exception {
		System.out.println(amount + " has been deposited to " + account);
		throw new Exception("Deposit error for testing");
	}
}
