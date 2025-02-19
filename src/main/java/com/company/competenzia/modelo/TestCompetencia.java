package com.company.competenzia.modelo;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="testCompetencias")
public class TestCompetencia implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2243904039647791793L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String nombreTest;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
	private Empleados empleados;

	/*
	 * Variables Competencia Trabajo en Equipo
	 */
	
	// Primer Nivel
	private int te1a;
	private int te1b;
	private int te1c;
	
	// Segundo Nivel
	private int te2a;
	private int te2b;
	private int te2c;
	
	// Tercer Nivel
	private int te3a;
	private int te3b;
	private int te3c;
	
	/*
	 * Variables Competencia Organizacion
	 */
	
	//Primer Nivel
	private int o1a;
	private int o1b;
	private int o1c;
	
	//Segundo Nivel
	private int o2a;
	private int o2b;
	private int o2c;
		
	//Tercer Nivel
	private int o3a;
	private int o3b;
	private int o3c;
	
	
	/*
	 * Variables Competencia Liderazgo
	 */
	
	//Primer Nivel
	private int l1a;
	private int l1b;
	private int l1c;
	
	//Primer Nivel
	private int l2a;
	private int l2b;
	private int l2c;

	//Primer Nivel
	private int l3a;
	private int l3b;
	private int l3c;
	
	//Getter & Setter 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombreTest() {
		return nombreTest;
	}
	public void setNombreTest(String nombreTest) {
		this.nombreTest = nombreTest;
	}
	public Empleados getEmpleados() {
		return empleados;
	}
	public void setEmpleados(Empleados empleados) {
		this.empleados = empleados;
	}
	public int getTe1a() {
		return te1a;
	}
	public void setTe1a(int te1a) {
		this.te1a = te1a;
	}
	public int getTe1b() {
		return te1b;
	}
	public void setTe1b(int te1b) {
		this.te1b = te1b;
	}
	public int getTe1c() {
		return te1c;
	}
	public void setTe1c(int te1c) {
		this.te1c = te1c;
	}
	public int getTe2a() {
		return te2a;
	}
	public void setTe2a(int te2a) {
		this.te2a = te2a;
	}
	public int getTe2b() {
		return te2b;
	}
	public void setTe2b(int te2b) {
		this.te2b = te2b;
	}
	public int getTe2c() {
		return te2c;
	}
	public void setTe2c(int te2c) {
		this.te2c = te2c;
	}
	public int getTe3a() {
		return te3a;
	}
	public void setTe3a(int te3a) {
		this.te3a = te3a;
	}
	public int getTe3b() {
		return te3b;
	}
	public void setTe3b(int te3b) {
		this.te3b = te3b;
	}
	public int getTe3c() {
		return te3c;
	}
	public void setTe3c(int te3c) {
		this.te3c = te3c;
	}
	public int getO1a() {
		return o1a;
	}
	public void setO1a(int o1a) {
		this.o1a = o1a;
	}
	public int getO1b() {
		return o1b;
	}
	public void setO1b(int o1b) {
		this.o1b = o1b;
	}
	public int getO1c() {
		return o1c;
	}
	public void setO1c(int o1c) {
		this.o1c = o1c;
	}
	public int getO2a() {
		return o2a;
	}
	public void setO2a(int o2a) {
		this.o2a = o2a;
	}
	public int getO2b() {
		return o2b;
	}
	public void setO2b(int o2b) {
		this.o2b = o2b;
	}
	public int getO2c() {
		return o2c;
	}
	public void setO2c(int o2c) {
		this.o2c = o2c;
	}
	public int getO3a() {
		return o3a;
	}
	public void setO3a(int o3a) {
		this.o3a = o3a;
	}
	public int getO3b() {
		return o3b;
	}
	public void setO3b(int o3b) {
		this.o3b = o3b;
	}
	public int getO3c() {
		return o3c;
	}
	public void setO3c(int o3c) {
		this.o3c = o3c;
	}
	public int getL1a() {
		return l1a;
	}
	public void setL1a(int l1a) {
		this.l1a = l1a;
	}
	public int getL1b() {
		return l1b;
	}
	public void setL1b(int l1b) {
		this.l1b = l1b;
	}
	public int getL1c() {
		return l1c;
	}
	public void setL1c(int l1c) {
		this.l1c = l1c;
	}
	public int getL2a() {
		return l2a;
	}
	public void setL2a(int l2a) {
		this.l2a = l2a;
	}
	public int getL2b() {
		return l2b;
	}
	public void setL2b(int l2b) {
		this.l2b = l2b;
	}
	public int getL2c() {
		return l2c;
	}
	public void setL2c(int l2c) {
		this.l2c = l2c;
	}
	public int getL3a() {
		return l3a;
	}
	public void setL3a(int l3a) {
		this.l3a = l3a;
	}
	public int getL3b() {
		return l3b;
	}
	public void setL3b(int l3b) {
		this.l3b = l3b;
	}
	public int getL3c() {
		return l3c;
	}
	public void setL3c(int l3c) {
		this.l3c = l3c;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
}
