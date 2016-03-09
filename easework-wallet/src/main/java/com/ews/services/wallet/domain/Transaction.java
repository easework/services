package com.ews.services.wallet.domain;

import java.io.Serializable;

public interface Transaction<T, V> extends Serializable {
	
	enum TransactionType {DEBIT, CREDIT, LOAN, RENT}
	
	T getType();
	V getValue();
	String getDetails();
}
