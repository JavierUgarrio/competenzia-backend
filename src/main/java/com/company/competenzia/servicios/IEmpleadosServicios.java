package com.company.competenzia.servicios;

import org.springframework.http.ResponseEntity;

import com.company.competenzia.respuesta.RespuestaEmpleadosRest;

public interface IEmpleadosServicios {

	public ResponseEntity<RespuestaEmpleadosRest> buscarEmpleados();
	
}
