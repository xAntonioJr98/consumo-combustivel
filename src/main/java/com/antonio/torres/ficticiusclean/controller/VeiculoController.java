package com.antonio.torres.ficticiusclean.controller;

import com.antonio.torres.ficticiusclean.dto.VeiculoRequestDTO;
import com.antonio.torres.ficticiusclean.dto.VeiculoResponseDTO;
import com.antonio.torres.ficticiusclean.mapper.VeiculoMapper;
import com.antonio.torres.ficticiusclean.model.Veiculo;
import com.antonio.torres.ficticiusclean.repository.VeiculoRepository;
import com.antonio.torres.ficticiusclean.services.VeiculoService;
import com.antonio.torres.ficticiusclean.services.VeiculoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/veiculos")
public class VeiculoController {

    @Autowired
    private VeiculoService veiculoService;

    @Autowired
    private VeiculoMapper veiculoMapper;


    @GetMapping("/findall")
    public ResponseEntity<List<Veiculo>> findAll(){

        List<Veiculo> list = veiculoService.findAll();
        return ResponseEntity.ok().body(list);

    }
//
//    @GetMapping("/id/{id}")
//    public Optional<Veiculo> obterPorId(@PathVariable int id){
//        return veiculoServiceImpl.obterPorId(id);
//
//    }
//    @DeleteMapping("/id/{id}")
//    public String deletar (@PathVariable int id){
//        veiculoServiceImpl.deletar(id);
//
//        return "veiculo com id " + id + " foi deletado com sucesso";
//
//    }
//
//    @PutMapping("/atualizar/{id}")
//    public Veiculo atualizar (@RequestBody Veiculo veiculo, @PathVariable int id){
//        return veiculoServiceImpl.atualizar(id, veiculo);
//
//
//    }

    @PostMapping("/add")
    public ResponseEntity<VeiculoResponseDTO> insert(@RequestBody VeiculoRequestDTO veiculo) {
        VeiculoResponseDTO salvarVeiculo = veiculoService.insert(veiculoMapper.toEntity(veiculo));

        return new ResponseEntity<>(salvarVeiculo, HttpStatus.CREATED);
    }

    @GetMapping(value = "/calcula")
    public ResponseEntity<List<VeiculoResponseDTO>> compute(@RequestParam("preco") double preco,
                                                            @RequestParam("cidade") double cidade,
                                                            @RequestParam("rodovia") double rodovia) {

        List<VeiculoResponseDTO> dto = veiculoService.calcula(preco, cidade, rodovia);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }


}
