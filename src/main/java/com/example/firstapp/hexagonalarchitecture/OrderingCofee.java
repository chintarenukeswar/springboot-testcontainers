package com.example.firstapp.hexagonalarchitecture;

import java.util.UUID;

public interface OrderingCofee {
    Order placeOrder(Order order);
    Order updateOrder(UUID orderId,Order order);
    Order deleteOrder(UUID orderId);
    Payment payOrder(UUID orderId,CreditCard creditCard);
    Receipt readReceipt(UUID orderId);
    Order takeOrder(UUID orderId);
}
