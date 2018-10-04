package com.hector.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.hector.demo.service.CountryClient;
import com.hector.demo.ws.GetCountryResponse;

@Controller
public class ServicioController {
	@Autowired
	CountryClient quoteClient;
	
	@GetMapping("/servicios")
	public String formAlumno(Model model,@RequestParam(value="pais", required=true)String pais){
		
		GetCountryResponse response = quoteClient.getCountry(pais);
		
		model.addAttribute("titulo", "Datos de los pais");
		model.addAttribute("pais",pais);
		model.addAttribute("prueba", response.getCountry());
		if(response.getCountry()== null ){
			model.addAttribute("validar", false);
		}else{
			model.addAttribute("validar", true);
			model.addAttribute("ResponseName",response.getCountry().getName());
			model.addAttribute("ResponsePopulation",response.getCountry().getPopulation());
			model.addAttribute("ResponseCapital",response.getCountry().getCapital());
			model.addAttribute("ResponseMoneda",response.getCountry().getCurrency());
		}

		
		return  "ListaServicios";
	}
//	@GetMapping("/form/{id}")
//	public String editar(Model model){
//		
//		return "form"
//	} 
}
