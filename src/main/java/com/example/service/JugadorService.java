package com.example.service;


import com.example.domain.Equipo;
import com.example.domain.Jugador;
import com.example.repository.EquipoRepository;
import com.example.repository.JugadorRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDate;

public class JugadorService {

    @Autowired
    private JugadorRepository jugadorRepository;

    @Autowired
    private EquipoRepository equipoRepository;


    public void testJugador(){

        Jugador jugador1= new Jugador();
        jugador1.setNombre("Alfredo");
        jugador1.setPosicion("alero");
        jugador1.setRebotesTotales(50);
        jugador1.setCanastasTotales(100);
        jugador1.setAsistenciasTotales(25);
        jugador1.setNacimiento(LocalDate.of(1999,5,7));

        Equipo spurs = equipoRepository.findOne(1L);
        jugador1.setOwner(spurs);
        jugadorRepository.save(jugador1);


        Jugador jugador2= new Jugador();
        jugador2.setNombre("Anne");
        jugador2.setPosicion("base");
        jugador2.setRebotesTotales(45);
        jugador2.setCanastasTotales(125);
        jugador2.setAsistenciasTotales(23);
        jugador2.setNacimiento(LocalDate.of(1989,6,10));

        Equipo bulls = equipoRepository.findOne(2L);
        jugador2.setOwner(bulls);
        jugadorRepository.save(jugador2);

        Jugador jugador3= new Jugador();
        jugador3.setNombre("Johat");
        jugador3.setPosicion("pivot");
        jugador3.setRebotesTotales(60);
        jugador3.setCanastasTotales(90);
        jugador3.setAsistenciasTotales(20);
        jugador3.setNacimiento(LocalDate.of(1993,2,3));

        Equipo celtic = equipoRepository.findOne(3L);
        jugador3.setOwner(celtic);
        jugadorRepository.save(jugador3);

        Jugador jugador4= new Jugador();
        jugador4.setNombre("Megan");
        jugador4.setPosicion("escolta");
        jugador4.setRebotesTotales(80);
        jugador4.setCanastasTotales(140);
        jugador4.setAsistenciasTotales(30);
        jugador4.setNacimiento(LocalDate.of(2000,5,11));

        Equipo miami = equipoRepository.findOne(4L);
        jugador4.setOwner(miami);
        jugadorRepository.save(jugador4);

        Jugador jugador5= new Jugador();
        jugador5.setNombre("Artiach");
        jugador5.setPosicion("ala-pivot");
        jugador5.setRebotesTotales(10);
        jugador5.setCanastasTotales(25);
        jugador5.setAsistenciasTotales(5);
        jugador5.setNacimiento(LocalDate.of(2000,9,23));

        Equipo philadelphia = equipoRepository.findOne(5L);
        jugador5.setOwner(philadelphia);
        jugadorRepository.save(jugador5);



        System.out.println("Buscar jugadores por");
        System.out.println(jugadorRepository.findByName("Anne"));
        System.out.println("Buscar jugadores por canastas mayor o igual a 50: ");
        System.out.println(jugadorRepository.findByCanastasTotalesGreatreThanEqual(40));
        System.out.println("Buscar jugadores por asistencias determinadas ");
        System.out.println(jugadorRepository.findJugadoresByMinMaxAsis(20,35));
        System.out.println("Buscar jugadores por posicion determinada: pivot ");
        System.out.println(jugadorRepository.findByPosicion("pivot"));
        System.out.println("Buscar jugadores que hayan nacido antes de ");
        System.out.println(jugadorRepository.findByBirthdayBefore(LocalDate.of(2000,5,11)));
        System.out.println("Buscar jugadores por la posicion de campo y devolver medias ");
        System.out.println(jugadorRepository.AvgCanastaASisteRebotes(30, 90, 14, "base"));
        System.out.println("Buscar jugadores por la posicion de campo y devolver medias máximas y menos ");
        System.out.println(jugadorRepository.AvgAndMaxAndMinPerCanastasTotalesAsistenciasTotalesRebotesTotatelsOrderByPosicion(90, 80, 90, "base"));



    }






}
