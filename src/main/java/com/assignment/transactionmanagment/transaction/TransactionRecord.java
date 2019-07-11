package com.assignment.transactionmanagment.transaction;

import java.util.Date;

/**
 * TransactionRecord
 * 
 * POJO class containing the transaction attributes.
 */
public class TransactionRecord {


	private String transactionId;
	private String fromAccountId;
	private String toAccountId;
	private Date createdAt;
	private Float amount;
	private String transactionType;
	private String relatedTransaction;
	
	public String getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}
	public String getFromAccountId() {
		return fromAccountId;
	}
	public void setFromAccountId(String fromAccountId) {
		this.fromAccountId = fromAccountId;
	}
	public String getToAccountId() {
		return toAccountId;
	}
	public void setToAccountId(String toAccountId) {
		this.toAccountId = toAccountId;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public String getRelatedTransaction() {
		return relatedTransaction;
	}
	public void setRelatedTransaction(String relatedTransaction) {
		this.relatedTransaction = relatedTransaction;
	}
	public Float getAmount() {
		return amount;
	}
	public void setAmount(Float amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return "TransactionRecord [transactionId=" + transactionId + ", fromAccountId=" + fromAccountId
				+ ", toAccountId=" + toAccountId + ", createdAt=" + createdAt + ", amount=" + amount
				+ ", transactionType=" + transactionType + ", relatedTransaction=" + relatedTransaction + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((amount == null) ? 0 : amount.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((fromAccountId == null) ? 0 : fromAccountId.hashCode());
		result = prime * result + ((relatedTransaction == null) ? 0 : relatedTransaction.hashCode());
		result = prime * result + ((toAccountId == null) ? 0 : toAccountId.hashCode());
		result = prime * result + ((transactionId == null) ? 0 : transactionId.hashCode());
		result = prime * result + ((transactionType == null) ? 0 : transactionType.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TransactionRecord other = (TransactionRecord) obj;
		if (amount == null) {
			if (other.amount != null)
				return false;
		} else if (!amount.equals(other.amount))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (fromAccountId == null) {
			if (other.fromAccountId != null)
				return false;
		} else if (!fromAccountId.equals(other.fromAccountId))
			return false;
		if (relatedTransaction == null) {
			if (other.relatedTransaction != null)
				return false;
		} else if (!relatedTransaction.equals(other.relatedTransaction))
			return false;
		if (toAccountId == null) {
			if (other.toAccountId != null)
				return false;
		} else if (!toAccountId.equals(other.toAccountId))
			return false;
		if (transactionId == null) {
			if (other.transactionId != null)
				return false;
		} else if (!transactionId.equals(other.transactionId))
			return false;
		if (transactionType == null) {
			if (other.transactionType != null)
				return false;
		} else if (!transactionType.equals(other.transactionType))
			return false;
		return true;
	}
	
	
	
	
	
}
