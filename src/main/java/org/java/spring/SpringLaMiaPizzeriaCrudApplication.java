package org.java.spring;

import java.util.ArrayList;
import java.util.List;

import org.java.spring.pojo.Pizza;
import org.java.spring.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringLaMiaPizzeriaCrudApplication implements CommandLineRunner {
	@Autowired
	private PizzaService pizzaService;

	public static void main(String[] args){
		SpringApplication.run(SpringLaMiaPizzeriaCrudApplication.class, args);
	}

	public void run(String... args) throws Exception{
		addToDb();
//		Pizza p = new Pizza("asd" , "asd" , "ads" , 12.2f);
//		pizzaService.save(p);
		
	}
	
	private List<Pizza> getPizzasList() {
		List<Pizza> pizzasList = new ArrayList<>();
		pizzasList.add(new Pizza("asdasd" , "asd" , "asdadsads" , 21.2f));
		pizzasList.add(new Pizza("asdasasdd" , "asasdd" , "asda2ddsads" , 21.2f));
		pizzasList.add(new Pizza("asdasccxzd" , "ascdsddd" , "asdads3sads" , 212.2f));
		pizzasList.add(new Pizza("asdahtrergdfsdasd" , "sdfasd" , "assdcdadsads" , 21.2f));
		
		return pizzasList;
	}
	
	private void addToDb() {		
		for(Pizza p : getPizzasList()) {
			pizzaService.save(p);
		}
	}

}
