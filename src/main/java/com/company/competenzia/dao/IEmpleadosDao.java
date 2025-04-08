package com.company.competenzia.dao;

import org.springframework.data.repository.CrudRepository;

import com.company.competenzia.modelo.Empleados;

//Interfaz que extiende CrudRepository para proporcionar métodos CRUD básicos
public interface IEmpleadosDao extends CrudRepository<Empleados, Long>{

	
}
