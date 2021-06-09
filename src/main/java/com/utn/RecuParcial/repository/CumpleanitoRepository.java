package com.utn.RecuParcial.repository;


import com.utn.RecuParcial.model.Cumpleanitos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CumpleanitoRepository extends JpaRepository<Cumpleanitos, Integer>{
}
