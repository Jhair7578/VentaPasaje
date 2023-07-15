package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.entity.Cargo;

public interface CargoRepository extends JpaRepository<Cargo, Integer>  {

}
