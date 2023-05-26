package org.java.spring.controller;

import java.util.List;
import java.util.Optional;

import org.java.spring.pojo.Pizza;
import org.java.spring.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String index(Model model) {
		List<Pizza> pizzas = pizzaService.findAll();
		model.addAttribute("pizzas" , pizzas);
		return "pizza/index";
	}
	
	@GetMapping("/{id}")
	public String show(Model model , @PathVariable("id") int id) {
		Optional<Pizza> optPizza = pizzaService.findById(id);
		Pizza pizza = optPizza.get();
		model.addAttribute("pizza" , pizza);
		return "pizza/show";
	}
}
