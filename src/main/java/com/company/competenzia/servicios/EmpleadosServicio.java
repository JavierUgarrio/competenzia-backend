package com.company.competenzia.servicios;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.company.competenzia.dao.IEmpleadosDao;
import com.company.competenzia.modelo.Empleados;
import com.company.competenzia.respuesta.RespuestaEmpleadosRest;

@Service
public class EmpleadosServicio implements IEmpleadosServicios{

	@Autowired
	private IEmpleadosDao empleadosDao;
	
	@Override
	@Transactional(readOnly= true)
	public ResponseEntity<RespuestaEmpleadosRest> buscarEmpleados() {
		
		RespuestaEmpleadosRest respuestaEmpleadosRest = new RespuestaEmpleadosRest();
		
		try {
			List<Empleados> listaEmpleados =(List<Empleados>) empleadosDao.findAll();
			respuestaEmpleadosRest.getRespuestaEmpleados().setEmpleados(listaEmpleados);
			respuestaEmpleadosRest.setMetadata("Ok", "1", "Busqueda correcta");
			
		}catch(Exception ex) {
			ex.getStackTrace();
			respuestaEmpleadosRest.setMetadata("Error", "-1", "Error en la busqueda");
			return new ResponseEntity<RespuestaEmpleadosRest>(respuestaEmpleadosRest, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<RespuestaEmpleadosRest>(respuestaEmpleadosRest, HttpStatus.OK);
	}
	
	@Override
	@Transactional(readOnly=true)
	public ResponseEntity<RespuestaEmpleadosRest> buscarEmpleadosId(Long id){
		RespuestaEmpleadosRest respuestaEmpleadosRest = new RespuestaEmpleadosRest();
		List<Empleados> listaEmpleados = new ArrayList<>();
		
		try {
			Optional<Empleados> empleados = empleadosDao.findById(id);
			if(empleados.isPresent()) {
				listaEmpleados.add(empleados.get());
				respuestaEmpleadosRest.getRespuestaEmpleados().setEmpleados(listaEmpleados);
				respuestaEmpleadosRest.setMetadata("Ok", "1", "Busqueda correcta por Id");
			}else {
				respuestaEmpleadosRest.setMetadata("Error", "-1", "Error en la busqueda de Empleados Id");
				return new ResponseEntity<RespuestaEmpleadosRest>(respuestaEmpleadosRest, HttpStatus.BAD_REQUEST);
			}
		}catch(Exception ex) {
			ex.getStackTrace();
			respuestaEmpleadosRest.setMetadata("Error", "-1", "Error en la busqueda");
			return new ResponseEntity<RespuestaEmpleadosRest>(respuestaEmpleadosRest, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		
		return new ResponseEntity<RespuestaEmpleadosRest>(respuestaEmpleadosRest, HttpStatus.OK);
		
		
	}
	
	@Override
	@Transactional
	public ResponseEntity<RespuestaEmpleadosRest> guardarEmpleados(Empleados empleado){
		RespuestaEmpleadosRest respuestaEmpleadosRest = new RespuestaEmpleadosRest();
		List<Empleados> listaEmpleados = new ArrayList<>();
		
		try {
			Empleados empleadoGuardar = empleadosDao.save(empleado);
			if(empleadoGuardar !=null) {
				listaEmpleados.add(empleadoGuardar);
				respuestaEmpleadosRest.getRespuestaEmpleados().setEmpleados(listaEmpleados);
				respuestaEmpleadosRest.setMetadata("Ok", "1", "Empleado Guardado");
			}else {
				respuestaEmpleadosRest.setMetadata("Error", "-1", "Error de guardar empleado");
				return new ResponseEntity<RespuestaEmpleadosRest>(respuestaEmpleadosRest, HttpStatus.BAD_REQUEST);
			}
			
		}catch(Exception ex) {
			ex.getStackTrace();
			respuestaEmpleadosRest.setMetadata("Error", "-1", "Error en la busqueda");
			return new ResponseEntity<RespuestaEmpleadosRest>(respuestaEmpleadosRest, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RespuestaEmpleadosRest>(respuestaEmpleadosRest, HttpStatus.OK);
	}

	@Override
	@Transactional
	public ResponseEntity<RespuestaEmpleadosRest> actualizarEmpleados (Empleados empleado, Long id){
		RespuestaEmpleadosRest respuestaEmpleadosRest = new RespuestaEmpleadosRest();
		List<Empleados> listaEmpleados = new ArrayList<>();
		
		try {
			Optional<Empleados> empleadosId = empleadosDao.findById(id);
			if(empleadosId.isPresent()) {
				empleadosId.get().setNombre(empleado.getNombre());
				empleadosId.get().setApellidos(empleado.getApellidos());
				empleadosId.get().setEmail(empleado.getEmail());
				empleadosId.get().setTelefono(empleado.getTelefono());
				empleadosId.get().setEquipo(empleado.getEquipo());
				empleadosId.get().setEmpresa(empleado.getEmpresa());
				Empleados empleadoActualizado = empleadosDao.save(empleadosId.get());
				if(empleadoActualizado != null) {
					listaEmpleados.add(empleadoActualizado);
					respuestaEmpleadosRest.getRespuestaEmpleados().setEmpleados(listaEmpleados);
					respuestaEmpleadosRest.setMetadata("OK", "1", "Empleado Actualizado");
				}else {
					respuestaEmpleadosRest.setMetadata("Error", "-1", "Error en la actualizacion del empleado, empleado vacio");
					return new ResponseEntity<RespuestaEmpleadosRest>(respuestaEmpleadosRest, HttpStatus.BAD_REQUEST);
				}
			}else {
				respuestaEmpleadosRest.setMetadata("Error", "-1", "Error en la actualizacion del empleado");
				return new ResponseEntity<RespuestaEmpleadosRest>(respuestaEmpleadosRest, HttpStatus.NOT_FOUND);
			}
		}catch(Exception ex) {
			ex.getStackTrace();
			respuestaEmpleadosRest.setMetadata("Error", "-1", "Error en la actualizacion");
			return new ResponseEntity<RespuestaEmpleadosRest>(respuestaEmpleadosRest, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<RespuestaEmpleadosRest>(respuestaEmpleadosRest, HttpStatus.OK);
	}
}
