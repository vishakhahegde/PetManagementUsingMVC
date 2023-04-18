package com.example.mvcinventorytracker;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;


@Controller
public class petController {

	@Autowired
	public MongoRepo repo;

	@GetMapping("/")
	public String homepage(Model model){
		return "homepage";
	}

	@GetMapping("/viewpet")
	public String viewpets(Model model) {
		List<pet> pets = repo.findAll();
		model.addAttribute("allpets",pets);
		return "viewpet";
	}
	
	@GetMapping("/addpet")
	public String addpet(Model model) {
		model.addAttribute("pet",new pet());
		return "addpet";
	}

	@GetMapping("/deletepet")
    public String deletepet(Model model) {
        model.addAttribute("pet", new pet());
        return "deletepet";
    }

	@GetMapping("/updatepet/{id}")
	public String showUpdateForm(@PathVariable("id") String id, Model model) {
    pet pet = repo.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid product Id: " + id));
    model.addAttribute("pet", pet);
    return "updatepet";
	}

	@PostMapping("/updatepet")
	public String updatepet(@ModelAttribute("pet") pet pet) {
    repo.save(pet);
    return "redirect:viewpet";
}

    @PostMapping("/deletepet")
    public String deletepet(@ModelAttribute("pet") pet pet, Model model) {
        repo.deleteByName(pet.getName());
        model.addAttribute("message", "pet deleted successfully");
        return "redirect:viewpet";
    }
	
	@PostMapping("/addpet")
	public String submitpet(@ModelAttribute("pet") pet pet) {
		repo.save(pet);
		return "redirect:viewpet";
	}
}