package com.ews.services.wallet.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.util.Assert;

import com.ews.services.core.domain.HasId;
import com.ews.services.core.domain.HasOwner;
import com.ews.services.wallet.domain.Transaction.TransactionType;

@Document(collection="wallet")
public class Wallet implements Serializable, HasId<String>, HasOwner<String> {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6987737881817855436L;
	
	@Field
	private String id;
	@Field	
	private double balance;
	@Field
	private String owner;
	@Field
	private List<Transaction<TransactionType, Double>> transactions;
	
	public void doTransaction(Transaction<TransactionType, Double> tr) {
		if(tr.getType() == TransactionType.DEBIT) {
			Assert.isTrue(this.balance > tr.getValue() && tr.getValue() > 0);
			this.balance = this.balance - tr.getValue();
		} else if (tr.getType() == TransactionType.CREDIT) {
			Assert.isTrue(tr.getValue() > 0);
			this.balance = this.balance + tr.getValue();
		}
	}
	
	public double getBalance() {
		return balance;
	}

	@Override
	public String getId() {
		return this.id;
	}

	@Override
	public String getOwner() {
		return owner;
	}

}
