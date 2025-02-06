package com.company.competenzia.controlador;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.company.competenzia.modelo.TestCompetencia;
import com.company.competenzia.respuesta.RespuestaTestCompetenciasRest;
import com.company.competenzia.servicios.ITestCompetenciasServicios;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping("/apiCompetenzia")
public class TestCompetenciasControlador {

	@Autowired
	private ITestCompetenciasServicios iTestCompetenciasServicios;
	
	
	@PostMapping("/test-competencia")
	public ResponseEntity<RespuestaTestCompetenciasRest> guardarFormulario(@RequestBody TestCompetencia testCompetencia){
		ResponseEntity<RespuestaTestCompetenciasRest> respuesta = iTestCompetenciasServicios.guardarFormulario(testCompetencia );
		return respuesta;
		
	}
	
	@GetMapping("/test-competencia/{id}")
	public ResponseEntity<RespuestaTestCompetenciasRest>buscarFormularioId(@PathVariable Long id){
		ResponseEntity<RespuestaTestCompetenciasRest> respuesta = iTestCompetenciasServicios.buscarFormularioId(id);
		return respuesta;
	}
	
	@DeleteMapping("test-competencia/{id}")
	public ResponseEntity<RespuestaTestCompetenciasRest> eliminarFormularioId( @PathVariable Long id){
		ResponseEntity<RespuestaTestCompetenciasRest> respuesta = iTestCompetenciasServicios.eliminarFormularioId(id);
		return respuesta;
		
	}
	
	@GetMapping("/test-competencia")
	public ResponseEntity<RespuestaTestCompetenciasRest>buscarFormularios(){
		ResponseEntity<RespuestaTestCompetenciasRest> respuesta = iTestCompetenciasServicios.buscarFormularios();
		return respuesta;
	}
	
	
	
}

