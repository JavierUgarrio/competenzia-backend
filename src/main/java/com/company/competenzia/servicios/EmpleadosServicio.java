package com.company.competenzia.servicios;

import java.util.List;

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

}
