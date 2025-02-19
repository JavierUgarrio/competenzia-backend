package com.company.competenzia.modelo;

public class TestCompetenciaGrafica {
	private String nombreTest; // Nombre del test
    private Long empleadosId; // Id del empleado
    private int te1; // Resultado del promedio de te1a, te1b, te1c
    private int te2; // Resultado del promedio de te2a, te2b, te2c
    private int te3; // Resultado del promedio de te3a, te3b, te3c
    private int o1;  // Resultado del promedio de o1a, o1b, o1c
    private int o2;  // Resultado del promedio de o2a, o2b, o2c
    private int o3;  // Resultado del promedio de o3a, o3b, o3c
    private int l1;  // Resultado del promedio de l1a, l1b, l1c
    private int l2;  // Resultado del promedio de l2a, l2b, l2c
    private int l3;  // Resultado del promedio de l3a, l3b, l3c
	    
    //Constructor
    
    public TestCompetenciaGrafica(String nombreTest, Long empleadosId, int te1, int te2, int te3, int o1, int o2, int o3,
			int l1, int l2, int l3) {
		super();
		this.nombreTest = nombreTest;
		this.empleadosId = empleadosId;
		this.te1 = te1;
		this.te2 = te2;
		this.te3 = te3;
		this.o1 = o1;
		this.o2 = o2;
		this.o3 = o3;
		this.l1 = l1;
		this.l2 = l2;
		this.l3 = l3;
	}

    
    //getter & setter
    
    public Long getEmpleadosId() {
        return empleadosId;
    }

    public void setEmpleadosId(Long empleadosId) {
        this.empleadosId = empleadosId;
    }

    public String getNombreTest() {
        return nombreTest;
    }

    public void setNombreTest(String nombreTest) {
        this.nombreTest = nombreTest;
    }

    public int getTe1() {
        return te1;
    }

    public void setTe1(int te1) {
        this.te1 = te1;
    }

    public int getTe2() {
        return te2;
    }

    public void setTe2(int te2) {
        this.te2 = te2;
    }

    public int getTe3() {
        return te3;
    }

    public void setTe3(int te3) {
        this.te3 = te3;
    }

    public int getO1() {
        return o1;
    }

    public void setO1(int o1) {
        this.o1 = o1;
    }

    public int getO2() {
        return o2;
    }

    public void setO2(int o2) {
        this.o2 = o2;
    }

    public int getO3() {
        return o3;
    }

    public void setO3(int o3) {
        this.o3 = o3;
    }

    public int getL1() {
        return l1;
    }

    public void setL1(int l1) {
        this.l1 = l1;
    }

    public int getL2() {
        return l2;
    }

    public void setL2(int l2) {
        this.l2 = l2;
    }

    public int getL3() {
        return l3;
    }

    public void setL3(int l3) {
        this.l3 = l3;
    }
    
}


    

    
    