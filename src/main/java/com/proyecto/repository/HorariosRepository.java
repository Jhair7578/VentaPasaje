package com.proyecto.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.proyecto.entity.Horarios;

public interface HorariosRepository extends JpaRepository<Horarios, Integer>{

}
