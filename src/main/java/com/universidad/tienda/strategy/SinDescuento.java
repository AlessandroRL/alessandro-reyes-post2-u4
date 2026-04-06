package com.universidad.tienda.strategy;

import org.springframework.stereotype.Service;

@Service
public class SinDescuento implements EstrategiaDescuento {

    @Override
    public double aplicarDescuento(double monto) {
        return monto;
    }

    @Override
    public boolean esAplicable(String tipoCliente) {
        return false;
    }
}
