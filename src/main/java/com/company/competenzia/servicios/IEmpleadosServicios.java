package com.company.competenzia.servicios;

import org.springframework.http.ResponseEntity;

import com.company.competenzia.modelo.Empleados;
import com.company.competenzia.respuesta.RespuestaEmpleadosRest;

public interface IEmpleadosServicios {

	public ResponseEntity<RespuestaEmpleadosRest> buscarEmpleados();
	
	public ResponseEntity<RespuestaEmpleadosRest> buscarEmpleadosId(Long id);

	public ResponseEntity<RespuestaEmpleadosRest> guardarEmpleados(Empleados empleado);
	
	public ResponseEntity<RespuestaEmpleadosRest> actualizarEmpleados(Empleados empleado, Long id);
	
	public ResponseEntity<RespuestaEmpleadosRest> eliminarEmpleados(Long id);
}
