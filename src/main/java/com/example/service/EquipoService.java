package com.example.service;

import com.example.domain.Equipo;
import com.example.domain.Jugador;
import com.example.repository.EquipoRepository;
import com.example.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

public class EquipoService {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private EquipoRepository equipoRepository;


    public void testEquipo(){


        Equipo equipo1= new Equipo("Spurs", "Mi casa", LocalDate.of(1975,9,22));
        equipoRepository.save(equipo1);
        Equipo equipo2= new Equipo("Bulls", "Mi casa", LocalDate.of(1980,8,13));
        equipoRepository.save(equipo2);
        Equipo equipo3= new Equipo("Celtic", "Boston", LocalDate.of(1924,5,4));
        equipoRepository.save(equipo3);
        Equipo equipo4= new Equipo("Miami", "Miami", LocalDate.of(1924,5,4));
        equipoRepository.save(equipo4);
        Equipo equipo5= new Equipo("Philadelphia", "Philadelphia", LocalDate.of(1924,5,4));
        equipoRepository.save(equipo5);


    }


}
