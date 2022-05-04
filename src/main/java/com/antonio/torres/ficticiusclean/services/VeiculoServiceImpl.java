package com.antonio.torres.ficticiusclean.services;


import com.antonio.torres.ficticiusclean.dto.VeiculoResponseDTO;
import com.antonio.torres.ficticiusclean.mapper.VeiculoMapper;
import com.antonio.torres.ficticiusclean.model.Veiculo;
import com.antonio.torres.ficticiusclean.repository.VeiculoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoServiceImpl implements VeiculoService  {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ConsumoService consumoService;

    @Autowired
    private VeiculoMapper veiculoMapper;


    /** Metodo para retornar uma lista de veiculos
     * @return lista de veiculos.
     *
     * */

    public List<Veiculo> findAll(){
        return veiculoRepository.findAll();
    }

    /**
     * Metodo que retorna o veiculo encontrado pelo seu Id.
     * @param id do veiculo que será localizado
     * @return Retorna um veiculo caso seja encontrado
     * */
    public Optional<Veiculo> obterPorId(String id){

        return veiculoRepository.findById(id);
    }

    /**
          * Metodo que adiciona um novo veiculo ao banco de dados
          * @param veiculo a ser adicionado
          * @return retorna o veiculo que acabou de ser adicionado ao banco de dados
          * */
    @Override
    public VeiculoResponseDTO insert(Veiculo veiculo){
        Veiculo veiculoRegistrado = veiculoRepository.save(veiculo);

        return veiculoMapper.toDto(veiculoRegistrado);

    }

    /**
          * Metodo que calcula o gasto de combustivel
          * @param preco do combustivel
          * @param cidade km na cidade
          * @param rodovia km na rodovia
          * @return retorna a lista de veiculos de acordo com o gasto
          * */
    @Override
    public List<VeiculoResponseDTO> calcula (double preco, double cidade, double rodovia){
        List<Veiculo> todosVeiculos = veiculoRepository.findAll();

        List<VeiculoResponseDTO> listaVeiculos = todosVeiculos.stream().map(veiculo -> {
            double consumoRodovia = consumoService.calculaUsoCombustivel(rodovia, veiculo.getConsumo_medio_rodovia());
            double consumoCidade = consumoService.calculaUsoCombustivel(cidade, veiculo.getConsumo_medio_cidade());
            double precoTotal = consumoService.calculaPrecoTotal(preco, (consumoCidade + consumoRodovia));

            VeiculoResponseDTO veiculoResponseDTO = veiculoMapper.toDto(veiculo);
            veiculoResponseDTO.setCombustivel_gasto(consumoCidade + consumoRodovia);
            veiculoResponseDTO.setValor_gasto_combustivel(precoTotal);

            return veiculoResponseDTO;
        }).collect(Collectors.toList());

        //Collections.sort(listaVeiculos);

        return listaVeiculos;
    }



}

