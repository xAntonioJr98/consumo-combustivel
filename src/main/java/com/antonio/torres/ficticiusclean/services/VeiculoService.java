package com.antonio.torres.ficticiusclean.services;

import com.antonio.torres.ficticiusclean.dto.VeiculoResponseDTO;
import com.antonio.torres.ficticiusclean.model.Veiculo;

import java.util.List;

public interface VeiculoService {


    VeiculoResponseDTO insert (Veiculo veiculo);
    List<VeiculoResponseDTO> calcula (double preco, double consumo_medio_cidade, double consumo_medio_rodovia);
}
