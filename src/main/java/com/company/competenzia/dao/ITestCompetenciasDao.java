package com.company.competenzia.dao;

import org.springframework.data.repository.CrudRepository;


import com.company.competenzia.modelo.TestCompetencia;


//Interfaz que extiende CrudRepository para proporcionar métodos CRUD básicos
public interface ITestCompetenciasDao extends CrudRepository<TestCompetencia, Long> {

	
}
