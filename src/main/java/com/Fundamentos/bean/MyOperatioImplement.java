package com.Fundamentos.bean;

import java.util.LinkedList;

public class MyOperatioImplement implements MyOperation {

	@Override
	public void getDatosBasicos(LinkedList<String> datosBasicos) {
		// TODO Auto-generated method stub
		System.out.println("Entrando a metodo getDatosBasicos()---> : "+MyOperation.class.getName());
		if(datosBasicos.isEmpty()) {
		System.out.println("No se puede mostrar los datos en este momento...");	
		} else {
			for(String datos : datosBasicos){
				System.out.println(datos);
			}
		}
		
	}



}
