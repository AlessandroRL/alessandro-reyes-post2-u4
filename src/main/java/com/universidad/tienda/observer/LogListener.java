package com.universidad.tienda.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class LogListener {

    @EventListener
    public void onPedidoProcesado(PedidoEvent event) {
        System.out.printf(
                "[LOG] Pedido procesado | cliente=%s | original=%.2f | final=%.2f | estrategia=%s%n",
                event.tipoCliente(),
                event.montoOriginal(),
                event.montoFinal(),
                event.estrategiaAplicada()
        );
    }
}
