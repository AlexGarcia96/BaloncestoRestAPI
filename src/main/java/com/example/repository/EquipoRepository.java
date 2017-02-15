package com.example.repository;

import com.example.domain.Equipo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * Created by alex on 26/10/16.
 */
public interface EquipoRepository extends JpaRepository<Equipo, Long> {

    @Query("SELECT equipo from Equipo equipo WHERE equipo.localidad  = :localidad ")
    String findEquipoByLocalidad(@Param("localidad") String localidad);



}
