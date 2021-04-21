package com.sinfloo.demo.controler;

import java.util.List;
import java.util.Optional;
import javax.validation.Valid;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.sinfloo.demo.interfaceService.IDomicilioService;
import com.sinfloo.demo.interfaceService.IPersonaService;
import com.sinfloo.demo.modelo.Domicilio;
import com.sinfloo.demo.modelo.Persona;

@Controller
@RequestMapping
public class Controlador {

	@Autowired
	private IPersonaService service;
	
	@Autowired
	
	private IDomicilioService dom;
	
	@GetMapping("/listar")
	public String listar(Model model){
		List<Persona>personas=service.listar();
		model.addAttribute("personas", personas);
		return "index";
	}
	@GetMapping("/mostrar")
	public String mostrar(Model model){
		List<Domicilio>domicilios=dom.mostrar();
		model.addAttribute("domicilios", domicilios);
		return "direcciones";
	}
	
	@GetMapping("/new")
	public String agregar(Model model) {
		model.addAttribute("persona",new Persona());
		return "form";
	}
	
	@GetMapping("/nuevo")
	public String añadir(Model model) {
		model.addAttribute("domicilio",new Domicilio());
		return "formdir";
	}
	
	@PostMapping("/save")
	public String save(@Valid Persona p, Model model) {
		service.save(p);
		return "redirect:/listar";
	}
	
	@PostMapping("/guardar")
	public String save(@Valid Domicilio p, Model model) {
		dom.guardar(p);
		return "redirect:/mostrar";
	}
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable int id, Model model) {
		Optional<Persona>persona=service.listarId(id);
		model.addAttribute("persona", persona);
		return "form";
	}
	@GetMapping("/modificar/{id}")
	public String modificar(@PathVariable int id, Model model) {
		Optional<Domicilio>domicilio=dom.mostrarId(id);
		model.addAttribute("domicilio", domicilio);
		return "formdir";
	}
	@GetMapping("/eliminar/{id}")
	public String delete(Model model, @PathVariable int id) {
		service.delete(id);
		return "redirect:/listar";
	}
	
	@GetMapping("/borrar/{id}")
	public String borrar(Model model, @PathVariable int id) {
		dom.borrar(id);
		return "redirect:/mostrar";
	}
}
	
