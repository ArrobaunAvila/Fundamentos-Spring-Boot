package com.Fundamentos.bean;

public class MyBeanImplement implements MyBean {

	@Override
	public void print() {
		// TODO Auto-generated method stub
		System.out.println("Hola Desde la implementacion del Bean: "+ MyBeanImplement.class.getName());
	}

}
