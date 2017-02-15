package com.example.repository;


import com.example.domain.Jugador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface JugadorRepository extends JpaRepository<Jugador, Long> {

    List<Jugador> findByName(String name);
    List<Jugador> findByCanastasTotalesGreatreThanEqual(Integer canastasTotales);
    List<Jugador> findByAsistenciasTotalesBetween(Integer min, Integer max);
    List<Jugador> findByPosicion(String posicion);
    List<Jugador> findByBirthdayBefore(LocalDate nacimiento);



    @Query("SELECT jugador from Jugador jugador WHERE jugador.nombre  = :nombre ")
    String findJugadorByName(@Param("name") String name);

    @Query("SELECT jugador from Jugador jugador WHERE jugador.canastasTotales  >=:canastasTotales ")
    List<Jugador> findJugadoresByCanastasTotales(@Param("canastasTotales") Integer canastasTotales);

    @Query("SELECT jugador from Jugador jugador WHERE jugador.asistenciasTotales between :minAsis and :maxAsis")
    List<Jugador> findJugadoresByMinMaxAsis(@Param("minAsis") Integer minAsis,
                                            @Param("maxAsis") Integer maxAsis);



    @Query("SELECT jugador.posicion, AVG(jugador.canastasTotales), AVG(jugador.asistenciasTotales), AVG(jugador.arebotesTotales) " +
            "FROM Jugador jugador " +
            "GROUP BY jugador.posicion")
    List<Object[]> AvgCanastaASisteRebotes(@Param("canastasTotales") Integer canastasTotales,
                                                 @Param("asistenciasTotales") Integer asistenciasTotales,
                                                 @Param("rebotesTotales") Integer rebotesTotales,
                                                 @Param("posicion") String posicion);


    @Query("SELECT jugador.posicion, AVG(jugador.canastasTotales), AVG(jugador.asistenciasTotales), AVG(jugador.rebotesTotales), " +
            "MAX(jugador.canastasTotales), MAX(jugador.asistenciasTotales), MAX(jugador.arebotesTotales)," +
            "MIN (jugador.canastasTotales), MIN(jugador.asistenciasTotales), MIN(jugador.arebotesTotales) " +
            "FROM Jugador jugador " +
            "GROUP BY jugador.posicion")
    List<Object[]> AvgAndMaxAndMinPerCanastasTotalesAsistenciasTotalesRebotesTotatelsOrderByPosicion(@Param("canastasTotales") Integer canastasTotales,
                                                                                                     @Param("asistenciasTotales") Integer asistenciasTotales,
                                                                                                     @Param("rebotesTotales") Integer rebotesTotales,
                                                                                                     @Param("posicion") String posicion);

    @Query("Select jugador from Jugador jugador where jugador.equipo =:equipo")
    List<Object[]> findJugadorDeEquipo(@Param("equipo")String equipo);

    @Query("Select jugador from Jugador jugador where jugador.equipo =:equipo AND jugador.posicion =:posicion" )
    List<Object[]> findJugadorDeEq(@Param("equipo")String equip,
                                   @Param("posicion")String posicion);


    @Query("Select jugador.nombre, MAX(jugador.canastasTotales) from Jugador jugador where jugador.equipo =:equipo " +
             "ORDER BY jugador.canastasTotales ASC")
   Jugador findBYMAXJugadorDq(@Param("equipo")String equip);


}



