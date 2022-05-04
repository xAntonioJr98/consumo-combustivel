package com.antonio.torres.ficticiusclean.servicesTest;

import com.antonio.torres.ficticiusclean.services.ConsumoServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class consumoServiceImplTest {

    private static final double PRECO_COMBUSTIVEL = 3.5f;
    private static final double COMBUSTIVEL_CONSUMIDO = 11.5f;
    private static final double DISTANCIA = 50f;
    private static final double COMSUMO_MEDIO = 17.5f;

    private final ConsumoServiceImpl consumoService = new ConsumoServiceImpl();

    @Test
    public void shouldComputeTotalPrice() {
        double precoTotal = consumoService.calculaPrecoTotal(PRECO_COMBUSTIVEL, COMBUSTIVEL_CONSUMIDO);

        Assertions.assertEquals(40.25f, precoTotal);
    }

    @Test
    public void shouldComputeUsage() {
        double usoCombustivel = consumoService.calculaUsoCombustivel(DISTANCIA, COMSUMO_MEDIO);

        Assertions.assertEquals(2.857143f, usoCombustivel);
    }
}
