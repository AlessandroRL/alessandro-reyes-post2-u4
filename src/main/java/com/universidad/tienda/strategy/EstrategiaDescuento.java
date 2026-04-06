package com.universidad.tienda.strategy;

public interface EstrategiaDescuento {
	double aplicar(double monto);
	boolean esAplicable(String tipoCliente);
}
