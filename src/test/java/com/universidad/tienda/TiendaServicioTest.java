package com.universidad.tienda;

import com.universidad.tienda.strategy.DescuentoRegular;
import com.universidad.tienda.strategy.DescuentoVIP;
import com.universidad.tienda.strategy.SinDescuento;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class TiendaServicioTest {

	@Test
	void descuentoVipDebeAplicarVeintePorciento() {
		DescuentoVIP vip = new DescuentoVIP();
		assertEquals(80.0, vip.aplicarDescuento(100.0));
		assertTrue(vip.esAplicable("VIP"));
		assertFalse(vip.esAplicable("REGULAR"));
	}

	@Test
	void descuentoRegularDebeAplicarCincoPorciento() {
		DescuentoRegular regular = new DescuentoRegular();
		assertEquals(95.0, regular.aplicarDescuento(100.0));
		assertTrue(regular.esAplicable("REGULAR"));
		assertFalse(regular.esAplicable("VIP"));
	}

	@Test
	void sinDescuentoDebeMantenerMontoOriginal() {
		SinDescuento sinDescuento = new SinDescuento();
		assertEquals(100.0, sinDescuento.aplicarDescuento(100.0));
	}
}
