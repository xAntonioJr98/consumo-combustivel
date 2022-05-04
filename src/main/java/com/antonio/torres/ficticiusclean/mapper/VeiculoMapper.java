package com.antonio.torres.ficticiusclean.mapper;

import com.antonio.torres.ficticiusclean.dto.VeiculoRequestDTO;
import com.antonio.torres.ficticiusclean.dto.VeiculoResponseDTO;
import com.antonio.torres.ficticiusclean.model.Veiculo;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class VeiculoMapper {

    private Veiculo mapToEntity(VeiculoRequestDTO dto) {
        return new Veiculo(
                dto.getId(),
                dto.getNome(),
                dto.getMarca(),
                dto.getModelo(),
                dto.getData_de_fabricacao(),
                dto.getConsumo_medio_cidade(),
                dto.getConsumo_medio_rodovia()
        );
    }

    private VeiculoResponseDTO mapToDto(Veiculo entity) {
        return new VeiculoResponseDTO(
                entity.getId(),
                entity.getNome(),
                entity.getMarca(),
                entity.getModelo(),
                entity.getData_de_fabricacao(),
                entity.getConsumo_medio_cidade(),
                entity.getConsumo_medio_rodovia()
        );
    }

    private List<Veiculo> mapToListEntity(List<VeiculoRequestDTO> dtos) {
        return dtos.stream()
                .map(this::mapToEntity)
                .collect(Collectors.toList());
    }

    private List<VeiculoResponseDTO> mapToListDto(List<Veiculo> entities) {
        return entities.stream()
                .map(this::mapToDto)
                .collect(Collectors.toList());
    }

    public Veiculo toEntity(VeiculoRequestDTO dto) {
        return Optional.ofNullable(dto)
                .map(this::mapToEntity)
                .orElse(null);
    }

    public VeiculoResponseDTO toDto(Veiculo entity) {
        return Optional.ofNullable(entity)
                .map(this::mapToDto)
                .orElse(null);
    }

    public List<Veiculo> toListEntity(List<VeiculoRequestDTO> dtos) {
        return Optional.ofNullable(dtos)
                .map(this::mapToListEntity)
                .orElse(null);
    }

    public List<VeiculoResponseDTO> toListDto(List<Veiculo> entities) {
        return Optional.ofNullable(entities)
                .map(this::mapToListDto)
                .orElse(null);
    }
}
