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
import com.company.competenzia.modelo.TestCompetenciaGrafica;
import com.company.competenzia.respuesta.RespuestaTestCompetenciasRest;

@Service
public class TestCompetenciasServicio implements ITestCompetenciasServicios {

	@Autowired
	private ITestCompetenciasDao testCompetenciasDao;
	
	@Autowired
	private IEmpleadosDao empleadosDao;
	
	@Override
	@Transactional
	public ResponseEntity <RespuestaTestCompetenciasRest> guardarFormulario(TestCompetencia testCompetencia){
	
		RespuestaTestCompetenciasRest respuestaTestRest = new RespuestaTestCompetenciasRest();
		List<TestCompetencia>listaTestCompetencia = new ArrayList<>();
		
		try {
			//Busco el ID de empleado y posteriormente setearlo en el objeto TestCompetencia
			Long empleadoId = testCompetencia.getEmpleados().getId();
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
	
	@Override
	@Transactional
	public ResponseEntity <RespuestaTestCompetenciasRest> eliminarFormularioId(Long id){
		RespuestaTestCompetenciasRest respuestaTestRest = new RespuestaTestCompetenciasRest();
		
		
		try {
			//Busco el ID de TestCompetencia
			
			testCompetenciasDao.deleteById(id);;
			respuestaTestRest.setMetadata("Busqueda Id de test OK", "00", "Test encontrado");
			
		}catch(Exception ex){
			ex.printStackTrace();
			respuestaTestRest.setMetadata("Respuesta Error", "-1", "Error en la busqueda de test por ID");
			return new ResponseEntity<RespuestaTestCompetenciasRest>(respuestaTestRest, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<RespuestaTestCompetenciasRest>(respuestaTestRest, HttpStatus.OK);
	}
	
	@Override
	@Transactional(readOnly= true)
	public ResponseEntity <RespuestaTestCompetenciasRest> buscarFormularios(){
		RespuestaTestCompetenciasRest respuestaTestRest = new RespuestaTestCompetenciasRest();
		try {
			  List<TestCompetencia> listaTestCompetencia = (List<TestCompetencia>) testCompetenciasDao.findAll();
		        
		        // Lista donde guardaremos los resultados calculados
		        List<TestCompetenciaGrafica> listaTestCompetenciaGrafica = new ArrayList<>();

		        // Procesamos cada TestCompetencia
		        for (TestCompetencia testCompetencia : listaTestCompetencia) {
		            
		            // Obtenemos el empleadosId a partir de la relación
		            Long empleadosId = testCompetencia.getEmpleados().getId();// Suponiendo que tienes un método getId() en la clase Empleados

		            // Calculamos los promedios de trabajo en equipo (te1, te2, te3)
		            int te1 = ((testCompetencia.getTe1a() + testCompetencia.getTe1b() + testCompetencia.getTe1c()) * 100) / 12;
		            int te2 = ((testCompetencia.getTe2a() + testCompetencia.getTe2b() + testCompetencia.getTe2c()) * 100) / 12;
		            int te3 = ((testCompetencia.getTe3a() + testCompetencia.getTe3b() + testCompetencia.getTe3c()) * 100) / 12;

		            // Calculamos los promedios de organización (o1, o2, o3)
		            int o1 = ((testCompetencia.getO1a() + testCompetencia.getO1b() + testCompetencia.getO1c()) * 100) / 12;
		            int o2 = ((testCompetencia.getO2a() + testCompetencia.getO2b() + testCompetencia.getO2c()) * 100) / 12;
		            int o3 = ((testCompetencia.getO3a() + testCompetencia.getO3b() + testCompetencia.getO3c()) * 100) / 12;

		            // Calculamos los promedios de liderazgo (l1, l2, l3)
		            int l1 = ((testCompetencia.getL1a() + testCompetencia.getL1b() + testCompetencia.getL1c()) * 100) / 12;
		            int l2 = ((testCompetencia.getL2a() + testCompetencia.getL2b() + testCompetencia.getL2c()) * 100) / 12;
		            int l3 = ((testCompetencia.getL3a() + testCompetencia.getL3b() + testCompetencia.getL3c()) * 100) / 12;

		            // Creamos el objeto TestCompetenciaGrafica incluyendo el empleadosId
		            TestCompetenciaGrafica testGrafica = new TestCompetenciaGrafica(
		            	testCompetencia.getNombreTest(),
		            	empleadosId,      
		                te1,
		                te2,
		                te3,
		                o1,
		                o2,
		                o3,
		                l1,
		                l2,
		                l3
		            );

		            // Agregamos el resultado calculado a la lista
		            listaTestCompetenciaGrafica.add(testGrafica);
		        }
		        // Se guarda la lista de resultados calculados en la respuesta
		        respuestaTestRest.getRespuestaCompetencias().setListaTestCompetenciaGrafica(listaTestCompetenciaGrafica);

		        // Establecemos la metadata
		        respuestaTestRest.setMetadata("Busqueda Id de test OK", "00", "Test encontrado");
		        
			/*
			List<TestCompetencia>listaTestCompetencia = (List<TestCompetencia>) testCompetenciasDao.findAll();
			respuestaTestRest.getRespuestaCompetencias().setListaTestCompetencia(listaTestCompetencia);
			respuestaTestRest.setMetadata("Busqueda Id de test OK", "00", "Test encontrado");	
			*/		
			
		}catch(Exception ex){
			ex.printStackTrace();
			respuestaTestRest.setMetadata("Respuesta Error", "-1", "Error en la busqueda de test por ID");
			return new ResponseEntity<RespuestaTestCompetenciasRest>(respuestaTestRest, HttpStatus.BAD_REQUEST);
		}
		
		return new ResponseEntity<RespuestaTestCompetenciasRest>(respuestaTestRest, HttpStatus.OK);
	
	}

}
