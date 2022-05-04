package com.antonio.torres.ficticiusclean.services;

import org.springframework.stereotype.Service;

@Service
public class ConsumoServiceImpl implements ConsumoService  {

    @Override
    public double calculaPrecoTotal(double valor_combustivel, double combustivel_consumido) {
        return valor_combustivel * combustivel_consumido;
    }

    @Override
    public double calculaUsoCombustivel(double distancia, double media_consumo) {
        return distancia / media_consumo;
    }
}
