package com.antonio.torres.ficticiusclean.repository;

import com.antonio.torres.ficticiusclean.model.Veiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface VeiculoRepository extends MongoRepository<Veiculo, String> {
}
