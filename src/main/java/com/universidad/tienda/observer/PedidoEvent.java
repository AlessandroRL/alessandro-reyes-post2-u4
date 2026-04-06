package com.universidad.tienda.observer;

public record PedidoEvent(
        String tipoCliente,
        double montoOriginal,
        double montoFinal,
        String estrategiaAplicada
) {
}
