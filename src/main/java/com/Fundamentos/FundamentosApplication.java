package com.Fundamentos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Fundamentos.bean.MyBean;
import com.Fundamentos.bean.MyBeanWithDependency;
import com.Fundamentos.component.ComponentDependency;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	
	/*Haciendo inyeccion de dependencias con @Autowired
	 * & por medio del contructor... Dos formas de inyectar dependencias
	 */
	
    @Autowired
    @Qualifier("componentTwoImplement")
	private ComponentDependency componentDependency;
    
    private MyBean myBean;
    
    private MyBeanWithDependency myBeanWithDependency;
    
    
    /*
    public FundamentosApplication (@Qualifier("componentTwoImplement") ComponentDependency componentDependency){
    	this.componentDependency = componentDependency;
    }
	*/
    
    public FundamentosApplication(MyBean myBean, MyBeanWithDependency myBeanWithDependency) {
    	this.myBean = myBean;
    	this.myBeanWithDependency = myBeanWithDependency;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		componentDependency.saludar();
		
		myBean.print();
		
		myBeanWithDependency.printWithDependency();
	}

}
