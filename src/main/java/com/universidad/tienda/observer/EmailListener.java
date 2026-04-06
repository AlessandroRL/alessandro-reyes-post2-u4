package com.universidad.tienda.observer;

import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class EmailListener {

    @EventListener
    public void onPedidoProcesado(PedidoEvent event) {
        System.out.printf(
                "[EMAIL] Enviando confirmacion: cliente=%s, total=%.2f%n",
                event.tipoCliente(),
                event.montoFinal()
        );
    }
}
