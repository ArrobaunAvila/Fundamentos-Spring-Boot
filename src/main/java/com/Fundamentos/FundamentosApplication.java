package com.Fundamentos;

import com.Fundamentos.bean.BeanPropertyConfiguration;
import com.Fundamentos.bean.MyOperation;
import com.Fundamentos.entity.User;
import com.Fundamentos.pojo.UserPojo;
import com.Fundamentos.repository.UserRepository;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.Fundamentos.bean.MyBean;
import com.Fundamentos.bean.MyBeanWithDependency;
import com.Fundamentos.component.ComponentDependency;
import org.springframework.data.domain.Sort;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@SpringBootApplication
public class FundamentosApplication implements CommandLineRunner {
	
	/*Haciendo inyeccion de dependencias con @Autowired
	 * & por medio del contructor... Dos formas de inyectar dependencias
	 */
	private final Log LOGGER = LogFactory.getLog(FundamentosApplication.class);

    @Autowired
    @Qualifier("componentImplement")
	private ComponentDependency componentDependency;
    
    private MyBean myBean;
    private MyBeanWithDependency myBeanWithDependency;
	private BeanPropertyConfiguration beanPropertyConfiguration;
    private UserPojo userPojo;

	private UserRepository userRepository;

	@Autowired
	private MyOperation myOperation;
    
    /*
    public FundamentosApplication (@Qualifier("componentTwoImplement") ComponentDependency componentDependency){
    	this.componentDependency = componentDependency;
    }
	*/
    
    public FundamentosApplication(MyBean myBean, MyBeanWithDependency myBeanWithDependency, UserPojo userPojo, UserRepository userRepository) {
    	this.myBean = myBean;
    	this.myBeanWithDependency = myBeanWithDependency;
		this.userPojo = userPojo;
		this.userRepository = userRepository;
    }
    
	public static void main(String[] args) {
		SpringApplication.run(FundamentosApplication.class, args);
	}

	private void executeExamplesInjectionDependences() {
		// TODO Auto-generated method stub

		LinkedList<Integer> datos_operation = new LinkedList<>();

		for(int i=0; i <= 10; i++){
			datos_operation.add((int) (Math.random() * 50 + 3));
		}

		componentDependency.saludar();

		myBean.print();

		myOperation.getDatosBasicos(datos_operation);
		myBeanWithDependency.printWithDependency();

		try {
			System.out.println(userPojo.toString());
			System.out.println(beanPropertyConfiguration.propertyUsuario());
		}catch (Exception e) {

			LOGGER.error("Error Grave!!! " + e.getMessage());
		}
	}


	private void getInformacionJpqlFromUserByEmail (){
         LOGGER.info("El usuario User with metodo findbyUserEmail" + userRepository.findByUserEmail("molinoDanilo@gmail.com")
				 .orElseThrow( () -> new RuntimeException("No se encontro el usuario")));

         userRepository.findAndSort("M", Sort.by("id").descending())
				 .stream().forEach(user -> LOGGER.info("User with method sort" + user));

		 userRepository.findByName("Lobo")
				 .stream()
				 .forEach(user -> LOGGER.info("Usuario con query Method: " + user));

		 LOGGER.info("Usuario con query method findByEmailAndName " +
				 userRepository.findByEmailAndName("elpibemariano@gmail.com","Mariano")
						 .orElseThrow( () -> new  RuntimeException("Usuario No encontrado")));

		 userRepository.findByNameLike("M%")
				 .stream()
				 .forEach(user -> LOGGER.info("Usuario findByNameLike: " + user));

		userRepository.findByNameOrEmail(null, "maria34_45@gmail.com")
				.stream()
				.forEach(user -> LOGGER.info("Usuario findByNameOrEmail: " + user));

        userRepository.findByBirthdayBetween(LocalDate.of(2021, 03, 1), LocalDate.of(2021, 03 , 20))
				.stream()
				.forEach(user -> LOGGER.info("Usuario con intervalo de fechas-->" + user));
	}

	private void saveUsersInDatabase(){
		List<User> list =  List.of(User.builder()
						.name("Maria")
						.email("maria34_45@gmail.com")
						.address("Calle56 A # 37")
				        .birthday(LocalDate.of(2021, 03, 15))
						.build(), User.builder()
				        .name("Fabio")
				        .email("fabioGalvan@hotmail.com")
			        	.address("Avenida 13 calle 54A")
				        .birthday(LocalDate.now())
				        .build(),User.builder()
						.name("Lobo")
				        .email("loboCarrasco12@gmail.com")
			        	.address("Avenida las americas")
				        .birthday(LocalDate.now())
				        .build(),User.builder()
			           	.name("Danilo")
			        	.email("molinoDanilo@gmail.com")
				        .address("Cra7a-14")
				        .birthday(LocalDate.of(2021, 03, 25))
				        .build(),User.builder()
				        .name("Mariano")
			        	.email("elpibemariano@gmail.com")
				        .address("Calle A# 45D")
						.birthday(LocalDate.of(2021, 03, 20))
				        .build());
		list.stream().forEach(userRepository::save);

	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		//executeExamplesInjectionDependences();
		saveUsersInDatabase();
		getInformacionJpqlFromUserByEmail();

	}

}
