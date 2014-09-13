package org.test.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.test.models.Plant;
import org.test.repositories.PlantRepository;

@Controller
public class MyController {
	
	@Autowired
	PlantRepository repo;
	
	@RequestMapping("")
	public String index() {
		return "index";
	}
	

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
	
	
	
	@RequestMapping("/plants/{id}")
	public String show(Model model, @PathVariable Long id){
		model.addAttribute("plant", repo.getOne(id));
		return "plants/show";
	}

	@RequestMapping("/plants/{id}/form")
	public String edit(Model model, @PathVariable Long id){
		model.addAttribute("plant", repo.getOne(id));
		return "plants/update";
	}

	@RequestMapping(value="/plants/{id}", method=RequestMethod.PUT)
	public String update(Plant plant, @PathVariable Long id){
		repo.getOne(id).setName(plant.getName());
		repo.getOne(id).setDescription(plant.getDescription());
		repo.getOne(id).setPrice(plant.getPrice());
		repo.saveAndFlush(repo.getOne(id));
		return "redirect:/plants";
	}

}
