package com.sneppets.model;

import javax.ws.rs.QueryParam;

public class Account {
	
	@QueryParam("balance")
	private Integer balance;
	
	@QueryParam("status")
	private String status;

    public Account() {}
    
    public Integer getBalance() {
        return balance;
    }
    public void setBalance(Integer balance) {
        this.balance = balance;
    }
    public Account(Integer balance) {
        super();
        this.balance = balance;
    }
    public void withdraw(int money) {
        balance -= money;
    }

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
