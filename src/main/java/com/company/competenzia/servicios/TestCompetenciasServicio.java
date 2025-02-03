package com.company.competenzia.servicios;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.competenzia.dao.IEmpleadosDao;
import com.company.competenzia.dao.ITestCompetenciasDao;
import com.company.competenzia.modelo.Empleados;
import com.company.competenzia.modelo.TestCompetencia;

import com.company.competenzia.respuesta.RespuestaTestCompetenciasRest;

@Service
public class TestCompetenciasServicio implements ITestCompetenciasServicios {

	@Autowired
	private ITestCompetenciasDao testCompetenciasDao;
	
	@Autowired
	private IEmpleadosDao empleadosDao;
	
	@Override
	@Transactional
	public ResponseEntity <RespuestaTestCompetenciasRest> guardarFormulario(TestCompetencia testCompetencia, Long empleadoId){
	
		RespuestaTestCompetenciasRest respuestaTestRest = new RespuestaTestCompetenciasRest();
		List<TestCompetencia>listaTestCompetencia = new ArrayList<>();
		
		try {
			//Busco el ID de empleado y posteriormente setearlo en el objeto TestCompetencia
			
			Optional <Empleados> empleado = empleadosDao.findById(empleadoId);
			
			if(empleado.isPresent()){
				testCompetencia.setEmpleados(empleado.get());
				
			}else {
				respuestaTestRest.setMetadata("Respuesta Error", "-1", "empleado no encontrado");
				return new ResponseEntity<RespuestaTestCompetenciasRest>(respuestaTestRest, HttpStatus.NOT_FOUND);
			}
			
			//Guardo el formulario una vez que encuentro el empleado
			
			TestCompetencia testCompetenciaGuardar = testCompetenciasDao.save(testCompetencia);
			if(testCompetenciaGuardar != null) {
				listaTestCompetencia.add(testCompetenciaGuardar);
				respuestaTestRest.getRespuestaCompetencias().setListaTestCompetencia(listaTestCompetencia);
				respuestaTestRest.setMetadata("Respuesta OK", "00", "Test Guardado");
			}else {
				respuestaTestRest.setMetadata("Respuesta Error", "-1", "test no guardado");
				return new ResponseEntity<RespuestaTestCompetenciasRest>(respuestaTestRest, HttpStatus.BAD_REQUEST);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			respuestaTestRest.setMetadata("Respuesta Error", "-1", "Error en el metodo de guardar formulario");
			return new ResponseEntity<RespuestaTestCompetenciasRest>(respuestaTestRest, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<RespuestaTestCompetenciasRest>(respuestaTestRest, HttpStatus.OK);
	}
	
	//Este metodo lo aprovechare para extraer los test de competencias y posteriormente tratare los datos para la exposicion en graficos
	@Override
	@Transactional(readOnly= true)
	public ResponseEntity <RespuestaTestCompetenciasRest> buscarFormularioId(Long id){
		RespuestaTestCompetenciasRest respuestaTestRest = new RespuestaTestCompetenciasRest();
		List<TestCompetencia>listaTestCompetencia = new ArrayList<>();
		
		try {
			//Busco el ID de TestCompetencia
			
			Optional <TestCompetencia> testCompetencia = testCompetenciasDao.findById(id);
			
			if(testCompetencia.isPresent()){
				listaTestCompetencia.add(testCompetencia.get());
				respuestaTestRest.getRespuestaCompetencias().setListaTestCompetencia(listaTestCompetencia);
				respuestaTestRest.setMetadata("Busqueda Id de test OK", "00", "Test encontrado");
				
			}else {
				respuestaTestRest.setMetadata("Respuesta Error", "-1", "Test no encontrado");
				return new ResponseEntity<RespuestaTestCompetenciasRest>(respuestaTestRest, HttpStatus.NOT_FOUND);
			}
		}catch(Exception ex){
			ex.printStackTrace();
			respuestaTestRest.setMetadata("Respuesta Error", "-1", "Error en la busqueda de test por ID");
			return new ResponseEntity<RespuestaTestCompetenciasRest>(respuestaTestRest, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<RespuestaTestCompetenciasRest>(respuestaTestRest, HttpStatus.OK);
	}
}
