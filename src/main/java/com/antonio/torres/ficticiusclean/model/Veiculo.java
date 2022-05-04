package com.antonio.torres.ficticiusclean.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity
@Document
public class Veiculo implements Serializable {

   private static final long serialVersionUID = 1L;

   @Id
   private String id;

   @Column(name = "nome")
   private String nome;

   @Column(name = "marca")
   private String marca;

   @Column(name = "modelo")
   private String modelo;

   @Column(name = "data_de_fabricacao")
   private LocalDate data_de_fabricacao;

   @Column(name = "consumo_medio_cidade")
   private double consumo_medio_cidade;

   @Column(name = "consumo_medio_rodovia")
   private double consumo_medio_rodovia;
}
