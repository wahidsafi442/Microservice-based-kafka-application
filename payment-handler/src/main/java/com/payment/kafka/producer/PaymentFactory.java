package com.payment.kafka.producer;

import java.io.Serializable;

public class PaymentFactory implements Serializable {

     public String transactionId;
     public String paymentType;
     public String amount;

     public String getTransactionId() {
          return transactionId;
     }

     public void setTransactionId(String transactionId) {
          this.transactionId = transactionId;
     }

     public void setPaymentType(String paymentType) {
          this.paymentType = paymentType;
     }

     public void setAmount(String amount) {
          this.amount = amount;
     }

     public String getPaymentType() {
          return paymentType;
     }

     public String getAmount() {
          return amount;
     }
}
