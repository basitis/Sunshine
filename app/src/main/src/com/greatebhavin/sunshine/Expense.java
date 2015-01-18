package com.greatebhavin.sunshine;

/**
 * Created by Bhavin on 9/25/2014.
 */
public class Expense {
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDebit() {
        return debit;
    }

    public void setDebit(String debit) {
        this.debit = debit;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    private long id;
    private String debit,credit;

}
