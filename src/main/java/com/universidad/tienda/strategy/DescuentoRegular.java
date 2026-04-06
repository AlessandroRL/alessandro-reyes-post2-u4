package com.universidad.tienda.strategy;

import org.springframework.stereotype.Service;

@Service
public class DescuentoRegular implements EstrategiaDescuento {

    @Override
    public double aplicarDescuento(double monto) {
        return monto * 0.95;
    }

    @Override
    public boolean esAplicable(String tipoCliente) {
        return "REGULAR".equalsIgnoreCase(tipoCliente);
    }
}
