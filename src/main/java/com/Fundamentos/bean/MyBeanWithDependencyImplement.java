package com.Fundamentos.bean;

import java.util.LinkedList;

public class MyBeanWithDependencyImplement implements MyBeanWithDependency {

	private MyOperation myOperation;
	
    LinkedList<Integer> datos_basicos = new LinkedList<>();
    
    public MyBeanWithDependencyImplement(MyOperation myOperation) {
    	this.myOperation = myOperation;
    }
	
	@Override
	public void printWithDependency() {
		// TODO Auto-generated method stub
		this.myOperation.getDatosBasicos(datos_basicos);
		System.out.println("Hola desde la implementacion con un Bean Con dependencia...{"
		+ MyBeanWithDependencyImplement.class.getName() );
	}
}
