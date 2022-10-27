package com.Fundamentos.Configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.Fundamentos.bean.MyBean;
import com.Fundamentos.bean.MyBeanImplement2;
import com.Fundamentos.bean.MyBeanWithDependency;
import com.Fundamentos.bean.MyBeanWithDependencyImplement;
import com.Fundamentos.bean.MyOperatioImplement;
import com.Fundamentos.bean.MyOperation;

@Configuration
public class MyConfigurationBean {

	
	@Bean
	public MyBean beanOperation() {
		return new MyBeanImplement2();
	}
	
	@Bean
	public MyOperation beanOperationDatosBasicos() {
		return new MyOperatioImplement();
	}
	
	@Bean
	public MyBeanWithDependency beanWithDependencyToOther(MyOperation myOperation){
		return new MyBeanWithDependencyImplement(myOperation);
	}
}
