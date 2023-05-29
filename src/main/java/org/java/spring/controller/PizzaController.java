package org.java.spring.controller;

import java.util.List;
import java.util.Optional;

import org.java.spring.pojo.Pizza;
import org.java.spring.services.PizzaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/pizzas")
public class PizzaController {
	private static String pageTitle;
	
	private String getPizzas(List<Pizza> pizzas , Model model) {
		pageTitle = "Lista pizze";
		model.addAttribute("pizzas" , pizzas);
		model.addAttribute("title" , pageTitle);
		return "pizza/index";
	}
	
	@Autowired
	private PizzaService pizzaService;
	
	@GetMapping("/")
	public String index(Model model ) {
		List<Pizza> pizzas = pizzaService.findAll();
		return getPizzas(pizzas, model);
	}
	
	@PostMapping("/")
	public String index(Model model , @RequestParam(name = "name") String name) {
		List<Pizza> pizzas = pizzaService.findByNameContaining(name);
		return getPizzas(pizzas, model);
	}
	
	@GetMapping("/{id}")
	public String show(Model model , @PathVariable("id") int id) {
		Optional<Pizza> optPizza = pizzaService.findById(id);
		Pizza pizza = optPizza.get();
		pageTitle = "Pizza " + pizza.getName();
		model.addAttribute("pizza" , pizza);
		model.addAttribute("title" , pageTitle);
		return "pizza/show";
	}
	
	@GetMapping("/create")
	public String create(Model model) {
		pageTitle = "Creazione pizza";
		Pizza pizza = new Pizza();
		String btnText = "Aggiungi alla lista delle pizze";
		model.addAttribute("btnText" , btnText);
		model.addAttribute("pizza", pizza);
		model.addAttribute("title" , pageTitle);
		return "pizza/create";
	}
	
	@PostMapping("/create")
	public String store(@ModelAttribute("pizza") Pizza pizza , Model model) {
		pizzaService.save(pizza);
		return "redirect:/pizzas/";
	}
}
