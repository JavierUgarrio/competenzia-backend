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
	
	/*
	@PostMapping("/formularios")
	public ResponseEntity<RespuestaTestCompetenciasRest> guardarFormulario(
			@RequestParam("nombreTest") String nombreTest,
			@RequestParam("te1a")int te1a,
			@RequestParam("te1b")int te1b,
			@RequestParam("te1c")int te1c,
			@RequestParam("te2a")int te2a,
			@RequestParam("te2b")int te2b,
			@RequestParam("te2c")int te2c,
			@RequestParam("te3a")int te3a,
			@RequestParam("te3b")int te3b,
			@RequestParam("te3c")int te3c,
			@RequestParam("o1a")int o1a,
			@RequestParam("o1b")int o1b,
			@RequestParam("o1c")int o1c,
			@RequestParam("o2a")int o2a,
			@RequestParam("o2b")int o2b,
			@RequestParam("o2c")int o2c,
			@RequestParam("o3a")int o3a,
			@RequestParam("o3b")int o3b,
			@RequestParam("o3c")int o3c,
			@RequestParam("l1a")int l1a,
			@RequestParam("l1b")int l1b,
			@RequestParam("l1c")int l1c,
			@RequestParam("l2a")int l2a,
			@RequestParam("l2b")int l2b,
			@RequestParam("l2c")int l2c,
			@RequestParam("l3a")int l3a,
			@RequestParam("l3b")int l3b,
			@RequestParam("l3c")int l3c,
			@RequestParam("empleadoId")Long empleadoId)throws IOException{
		
		TestCompetencia testCompetencia = new TestCompetencia();
		testCompetencia.setNombreTest(nombreTest);
		testCompetencia.setTe1a(te1a);
		testCompetencia.setTe1b(te1b);
		testCompetencia.setTe1c(te1c);
		testCompetencia.setTe2a(te2a);
		testCompetencia.setTe2b(te2b);
		testCompetencia.setTe2c(te2c);
		testCompetencia.setTe3a(te3a);
		testCompetencia.setTe3b(te3b);
		testCompetencia.setTe3c(te3c);
		testCompetencia.setO1a(o1a);
		testCompetencia.setO1b(o1b);
		testCompetencia.setO1c(o1c);
		testCompetencia.setO2a(o2a);
		testCompetencia.setO2b(o2b);
		testCompetencia.setO2c(o2c);
		testCompetencia.setO3a(o3a);
		testCompetencia.setO3b(o3b);
		testCompetencia.setO3c(o3c);
		testCompetencia.setL1a(l1a);
		testCompetencia.setL1b(l1b);
		testCompetencia.setL1c(l1c);
		testCompetencia.setL2a(l2a);
		testCompetencia.setL2b(l2b);
		testCompetencia.setL2c(l2c);
		testCompetencia.setL3a(l3a);
		testCompetencia.setL3b(l3b);
		testCompetencia.setL3c(l3c);
		testCompetencia.setId(empleadoId);
		
		ResponseEntity<RespuestaTestCompetenciasRest> respuesta = iTestCompetenciasServicios.guardarFormulario(testCompetencia, empleadoId);
		return respuesta;
		
	}*/
	
	
	@PostMapping("/formularios/{idEmpleado}")
	public ResponseEntity<RespuestaTestCompetenciasRest> guardarFormulario(@RequestBody TestCompetencia testCompetencia, @PathVariable Long idEmpleado){
		ResponseEntity<RespuestaTestCompetenciasRest> respuesta = iTestCompetenciasServicios.guardarFormulario(testCompetencia, idEmpleado );
		return respuesta;
		
	}
	
	@GetMapping("/formularios/{id}")
	public ResponseEntity<RespuestaTestCompetenciasRest>buscarFormularioId(@PathVariable Long id){
		ResponseEntity<RespuestaTestCompetenciasRest> respuesta = iTestCompetenciasServicios.buscarFormularioId(id);
		return respuesta;
	}
	
	@DeleteMapping("formularios/{id}")
	public ResponseEntity<RespuestaTestCompetenciasRest> eliminarFormularioId( @PathVariable Long id){
		ResponseEntity<RespuestaTestCompetenciasRest> respuesta = iTestCompetenciasServicios.eliminarFormularioId(id);
		return respuesta;
		
	}
	
	@GetMapping("/formularios")
	public ResponseEntity<RespuestaTestCompetenciasRest>buscarFormularios(){
		ResponseEntity<RespuestaTestCompetenciasRest> respuesta = iTestCompetenciasServicios.buscarFormularios();
		return respuesta;
	}
	
	
	
}

