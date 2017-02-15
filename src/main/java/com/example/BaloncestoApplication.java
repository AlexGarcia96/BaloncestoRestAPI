package com.example;

import com.example.domain.Equipo;
import com.example.service.EquipoService;
import com.example.service.JugadorService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class BaloncestoApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context= SpringApplication.run(BaloncestoApplication.class, args);

		JugadorService jugadorService=context.getBean(JugadorService.class);

		EquipoService  equipoService=context.getBean(EquipoService.class);

		equipoService.testEquipo();
		jugadorService.testJugador();


	}
}
