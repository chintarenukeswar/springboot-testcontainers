package com.example.firstapp.hexagonalarchitecture;

import java.util.UUID;

public interface PreparingCoffee {
    Order startPreparingCoffee(UUID orderId);
    Order finishPreparingCoffee(UUID orderId);
}
