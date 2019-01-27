package com.example.transectionapp;

import java.util.ArrayList;

public class TransectionDetailsModal {
    private String transactionDetail;
    private double transactionAmount;
    private ArrayList<TransactionParticipantModel> transactionParticipants;


    public String getTransactionDetail() {
        return transactionDetail;
    }

    public void setTransactionDetail(String transactionDetail) {
        this.transactionDetail = transactionDetail;
    }

    public double getTransactionAmount() {
        return transactionAmount;
    }

    public void setTransactionAmount(double transactionAmount) {
        this.transactionAmount = transactionAmount;
    }

    public ArrayList<TransactionParticipantModel> getTransactionParticipants() {
        return transactionParticipants;
    }

    public void setTransactionParticipants(ArrayList<TransactionParticipantModel> transactionParticipants) {
        this.transactionParticipants = transactionParticipants;
    }
}
