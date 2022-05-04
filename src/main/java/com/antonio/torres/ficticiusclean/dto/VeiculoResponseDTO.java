package com.antonio.torres.ficticiusclean.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VeiculoResponseDTO {

    private String id;

    private String nome;
    private String marca;
    private String modelo;
    private LocalDate data_de_fabricacao;
    private double combustivel_gasto;
    private double valor_gasto_combustivel;
}
