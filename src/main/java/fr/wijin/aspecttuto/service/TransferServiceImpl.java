package fr.wijin.aspecttuto.service;

import org.springframework.stereotype.Service;

import fr.wijin.aspecttuto.aspect.Log;

@Service
public class TransferServiceImpl implements TransferService {

	@Override
	public void transfer(String accountA, String accountB, Long amount) {
		System.out.println(amount + " Amount has been transfered from " + accountA + " to " + accountB);
	}

	@Override
	public Double checkBalance(String account) {
		System.out.println("Cheking balance of account " + account);
		return Double.valueOf(10000);
	}

	@Override
	public Long withdrawal(String account, Long amount) {
		System.out.println(amount + " Amount has been withdrawaled from " + account);
		return amount;
	}

	@Override
	@Log
	public void deposite(String account, Long amount) throws Exception {
		System.out.println(amount + " Amount has been deposited to " + account);
		throw new Exception();
	}

}
