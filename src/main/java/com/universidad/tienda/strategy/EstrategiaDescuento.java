package com.universidad.tienda.strategy;

public interface EstrategiaDescuento {
    double aplicarDescuento(double monto);

    boolean esAplicable(String tipoCliente);
}