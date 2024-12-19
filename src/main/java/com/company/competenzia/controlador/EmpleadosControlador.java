package com.company.competenzia.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.company.competenzia.respuesta.RespuestaEmpleadosRest;
import com.company.competenzia.servicios.IEmpleadosServicios;

@RestController
@RequestMapping("/apiCompetenzia")
public class EmpleadosControlador {
	
	@Autowired
	private IEmpleadosServicios empleadosServicios;

	@GetMapping("/empleados")
	public ResponseEntity<RespuestaEmpleadosRest> buscarEmpleados(){
		ResponseEntity<RespuestaEmpleadosRest> respuestaEmpleadosRest = empleadosServicios.buscarEmpleados();
		return respuestaEmpleadosRest;
	}
	
	@GetMapping("/empleados/{id}")
	public ResponseEntity<RespuestaEmpleadosRest> buscarEmpleadosId(@PathVariable Long id){
		ResponseEntity<RespuestaEmpleadosRest> respuestaEmpleadosRest = empleadosServicios.buscarEmpleadosId(id);
		return respuestaEmpleadosRest;
	}
}
