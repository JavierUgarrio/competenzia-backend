package com.company.competenzia.servicios;

import org.springframework.http.ResponseEntity;

import com.company.competenzia.modelo.TestCompetencia;
import com.company.competenzia.respuesta.RespuestaTestCompetenciasRest;

public interface ITestCompetenciasServicios {

	public ResponseEntity <RespuestaTestCompetenciasRest> guardarFormulario(TestCompetencia testCompetencia, Long empleadoId);
	public ResponseEntity <RespuestaTestCompetenciasRest> buscarFormularioId(Long id);
	public ResponseEntity <RespuestaTestCompetenciasRest> eliminarFormularioId(Long id);
	public ResponseEntity <RespuestaTestCompetenciasRest> buscarFormularios();
	
}
