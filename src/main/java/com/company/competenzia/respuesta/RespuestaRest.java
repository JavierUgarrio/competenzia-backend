package com.company.competenzia.respuesta;

import java.util.ArrayList;
import java.util.HashMap;

public class RespuestaRest {

	private ArrayList<HashMap<String , String>> metadata = new ArrayList<>();
	
	//GET & SET
	
	public ArrayList<HashMap<String, String>> getMetadata() {
		return metadata;
	}

	public void setMetadata(String tipo, String codigo, String estado) {
		
		HashMap<String, String> mapeo = new HashMap<String, String>();
		mapeo.put("tipo", tipo);
		mapeo.put(codigo, codigo);
		mapeo.put(estado, estado);
		
		metadata.add(mapeo);
		
	}
}

/*
 El objetivo de esta clase es crear una estructura que sea sencilla de gestionar, donde te da la informacion del envio de datos
 
 creando la variable metadata como ArrayList, donde dentro hay un hashmapa que con la clave y el valor te va a decir el estado de envio de los datos 
*/