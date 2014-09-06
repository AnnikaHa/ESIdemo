package org.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.test.models.Plant;
import org.test.repositories.PlantRepository;

@Controller
public class MyController {
	
	@Autowired
	PlantRepository repo;

	@RequestMapping("/plants")
	public String list(Model model){
	    model.addAttribute("plants", repo.findAll());
	    return "plants/list";
	}

	@RequestMapping(value="/plants/form")
	public String form(Model model){
	    model.addAttribute("plant", new Plant());
	    return "plants/create";
	}

	@RequestMapping(value="/plants", method=RequestMethod.POST)
	public String create(Plant plant){
	    repo.saveAndFlush(plant);
	    return "redirect:/plants";
	}

}
