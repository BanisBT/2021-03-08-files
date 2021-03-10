package org.example.modul;

public class Payment {
    private int paymentId;
    private int amount;
    private int receiverId;
    private int senderId;

    public Payment() {
    }

    public Payment(int paymentId, int amount, int receiverId, int senderId) {
        this.paymentId = paymentId;
        this.amount = amount;
        this.receiverId = receiverId;
        this.senderId = senderId;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "paymentid=" + paymentId +
                ", amount=" + amount +
                ", receiverid=" + receiverId +
                ", senderid=" + senderId +
                '}';
    }

    public int getPaymentId() {
        return paymentId;
    }

    public void setPaymentId(int paymentId) {
        this.paymentId = paymentId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getReceiverId() {
        return receiverId;
    }

    public void setReceiverId(int receiverId) {
        this.receiverId = receiverId;
    }

    public int getSenderId() {
        return senderId;
    }

    public void setSenderId(int senderId) {
        this.senderId = senderId;
    }
}
