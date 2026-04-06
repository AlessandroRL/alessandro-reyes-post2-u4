package com.universidad.tienda.strategy;

import org.springframework.stereotype.Service;

@Service
public class DescuentoVIP implements EstrategiaDescuento {

    @Override
    public double aplicarDescuento(double monto) {
        return monto * 0.80;
    }

    @Override
    public boolean esAplicable(String tipoCliente) {
        return "VIP".equalsIgnoreCase(tipoCliente);
    }
}
