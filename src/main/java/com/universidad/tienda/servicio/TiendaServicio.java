package com.universidad.tienda.servicio;

import com.universidad.tienda.observer.PedidoEvent;
import com.universidad.tienda.strategy.EstrategiaDescuento;
import com.universidad.tienda.strategy.SinDescuento;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TiendaServicio {

    private final List<EstrategiaDescuento> estrategias;
    private final ApplicationEventPublisher eventPublisher;

    public TiendaServicio(List<EstrategiaDescuento> estrategias, ApplicationEventPublisher eventPublisher) {
        this.estrategias = estrategias;
        this.eventPublisher = eventPublisher;
    }

    public double procesarPedido(String tipoCliente, double monto) {
        EstrategiaDescuento estrategia = estrategias.stream()
                .filter(e -> !(e instanceof SinDescuento))
                .filter(e -> e.esAplicable(tipoCliente))
                .findFirst()
                .orElseGet(SinDescuento::new);

        double montoFinal = estrategia.aplicarDescuento(monto);

        eventPublisher.publishEvent(new PedidoEvent(
                tipoCliente,
                monto,
                montoFinal,
                estrategia.getClass().getSimpleName()
        ));

        return montoFinal;
    }
}
