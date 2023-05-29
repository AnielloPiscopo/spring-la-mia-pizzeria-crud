package org.java.spring.repo;

import java.util.List;

import org.java.spring.pojo.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepo extends JpaRepository<Pizza, Integer> {
	public List<Pizza> findByName(String name);
}
