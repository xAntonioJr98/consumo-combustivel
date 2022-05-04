package com.antonio.torres.ficticiusclean.servicesTest;

import com.antonio.torres.ficticiusclean.dto.VeiculoResponseDTO;
import com.antonio.torres.ficticiusclean.mapper.VeiculoMapper;
import com.antonio.torres.ficticiusclean.model.Veiculo;
import com.antonio.torres.ficticiusclean.repository.VeiculoRepository;
import com.antonio.torres.ficticiusclean.services.ConsumoServiceImpl;
import com.antonio.torres.ficticiusclean.services.VeiculoService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

@RunWith(MockitoJUnitRunner.class)
public class VeiculoServiceImpl {


    @InjectMocks
    private VeiculoService veiculoServiceImpl;

    @Mock
    private VeiculoRepository veiculoRepository;

    @Mock
    private ConsumoServiceImpl consumoServiceImpl;

    @Mock
    private VeiculoMapper veiculoMapper;


    @Test
    public void testInsertVeiculo() {
        Veiculo veiculoMock = getVeiculoEntity();
        VeiculoResponseDTO vehicleResponseMock = getVeiculoResponse();
        Mockito.when(veiculoRepository.save(veiculoMock)).thenReturn(veiculoMock);
        Mockito.when(veiculoMapper.toDto(veiculoMock)).thenReturn(vehicleResponseMock);

        VeiculoResponseDTO veiculoResponseDTO = veiculoServiceImpl.insert(veiculoMock);

        Assert.assertEquals(veiculoMock.getId(), veiculoResponseDTO.getId());
        Assert.assertEquals(veiculoMock.getNome(), veiculoResponseDTO.getNome());
        Assert.assertEquals(veiculoMock.getMarca(), veiculoResponseDTO.getMarca());
        Assert.assertEquals(veiculoMock.getModelo(), veiculoResponseDTO.getModelo());
        Assert.assertEquals(veiculoMock.getData_de_fabricacao(), veiculoResponseDTO.getData_de_fabricacao());

    }

    @Test
    public void testShouldComputeVehicles() {
        Veiculo veiculoMock = getVeiculoEntity();
        VeiculoResponseDTO vehicleResponseMock = getVeiculoResponse();
        List<Veiculo> todosVeiculos = new ArrayList<>();
        todosVeiculos.add(veiculoMock);
        double rodovia = 20f;
        double cidade = 15f;
        double preco = 5f;
        Mockito.when(veiculoRepository.save(veiculoMock)).thenReturn(veiculoMock);
        Mockito.when(veiculoMapper.toDto(veiculoMock)).thenReturn(vehicleResponseMock);
        Mockito.when(veiculoRepository.findAll()).thenReturn(todosVeiculos);
        Mockito.when(consumoServiceImpl.calculaUsoCombustivel(rodovia, veiculoMock.getConsumo_medio_rodovia())).thenReturn(4.0);
        Mockito.when(consumoServiceImpl.calculaUsoCombustivel(cidade, veiculoMock.getConsumo_medio_cidade())).thenReturn(3.0);
        Mockito.when(consumoServiceImpl.calculaPrecoTotal(preco, 7.0f)).thenReturn(35.0);

        List<VeiculoResponseDTO> listaVeiculos = veiculoServiceImpl.calcula(5.0, 15, 20);

        Assert.assertEquals(1, listaVeiculos.size());
        Assert.assertEquals(veiculoMock.getNome(), listaVeiculos.get(0).getNome());
        Assert.assertEquals(veiculoMock.getMarca(), listaVeiculos.get(0).getMarca());
        Assert.assertEquals(veiculoMock.getModelo(), listaVeiculos.get(0).getModelo());
        Assert.assertEquals(veiculoMock.getData_de_fabricacao(), listaVeiculos.get(0).getData_de_fabricacao());
        Assert.assertEquals(7.0f, listaVeiculos.get(0).getCombustivel_gasto(), 0.0001);
        Assert.assertEquals(35.0f, listaVeiculos.get(0).getValor_gasto_combustivel(), 0.0001);
    }
    private Veiculo getVeiculoEntity() {
        Veiculo veiculo = new Veiculo();
        veiculo.setId("123");
        veiculo.setNome("CIVIC");
        veiculo.setMarca("HONDA");
        veiculo.setModelo("2020");
        veiculo.setData_de_fabricacao(LocalDate.of(2019, Month.MARCH, 10));
        veiculo.setConsumo_medio_rodovia(10.0);
        veiculo.setConsumo_medio_cidade(20.0);
        return veiculo;
    }

    private VeiculoResponseDTO getVeiculoResponse() {
        VeiculoResponseDTO veiculo = new VeiculoResponseDTO(
                "1234",
                "CIVIC",
                "HONDA",
                "2020",
                LocalDate.of(2019, Month.MARCH, 10),
                10.0,
                15.0);

        return veiculo;
    }


}
