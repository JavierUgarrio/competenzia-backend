package com.company.competenzia.respuesta;

import java.util.List;

import com.company.competenzia.modelo.TestCompetencia;
import com.company.competenzia.modelo.TestCompetenciaGrafica;

public class RespuestaTestCompetencias {

	List<TestCompetencia> listaTestCompetencia;
	
	List<TestCompetenciaGrafica> listaTestCompetenciaGrafica;
	
	//Getter & Setter
	public List<TestCompetencia> getListaTestCompetencia() {
		return listaTestCompetencia;
	}

	public void setListaTestCompetencia(List<TestCompetencia> listaTestCompetencia) {
		this.listaTestCompetencia = listaTestCompetencia;
	}

	public List<TestCompetenciaGrafica> getListaTestCompetenciaGrafica() {
		return listaTestCompetenciaGrafica;
	}

	public void setListaTestCompetenciaGrafica(List<TestCompetenciaGrafica> listaTestCompetenciaGrafica) {
		this.listaTestCompetenciaGrafica = listaTestCompetenciaGrafica;
	}
	
	
	
}
