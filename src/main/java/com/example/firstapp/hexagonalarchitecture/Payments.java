package com.example.firstapp.hexagonalarchitecture;

import java.util.UUID;

public interface Payments {

    Payment findPaymentByOrderId(UUID orderId);
    Payment save(Payment payment);
}
