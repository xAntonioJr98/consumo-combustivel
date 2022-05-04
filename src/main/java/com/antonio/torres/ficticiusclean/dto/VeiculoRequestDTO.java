package com.antonio.torres.ficticiusclean.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoRequestDTO {

    private String id;

    private String nome;
    private String marca;
    private String modelo;
    private Date data_de_fabricacao;
    private int consumo_medio_cidade;
    private int consumo_medio_rodovia;
}
