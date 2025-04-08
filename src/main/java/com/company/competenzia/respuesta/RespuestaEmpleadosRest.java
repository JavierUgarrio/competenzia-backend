package com.company.competenzia.respuesta;

/*
 * El objetivo de esta clase trata de "enlazar" la clase Empleados con Respuesta Rest, con el fin de que a la hora de hacer las llamadas a la parte Front 
 * muestre la informacion que hay empleados y RespuestaRest
 * 
 */

public class RespuestaEmpleadosRest extends RespuestaRest{
	
	private RespuestaEmpleados respuestaEmpleados = new RespuestaEmpleados();

	//Get & Set
	public RespuestaEmpleados getRespuestaEmpleados() {
		return respuestaEmpleados;
	}

	public void setRespuestaEmpleados(RespuestaEmpleados respuestaEmpleados) {
		this.respuestaEmpleados = respuestaEmpleados;
	}
	
	
	

}
