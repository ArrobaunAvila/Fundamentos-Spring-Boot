package com.Fundamentos.bean;

public class MyBeanImplement implements MyBean {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Hola Desde la implementacion propia del Bean: "+ MyBeanImplement.class.getName() + " --->1");
	}

}
