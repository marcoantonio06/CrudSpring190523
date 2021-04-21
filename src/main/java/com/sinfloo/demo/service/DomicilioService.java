package com.sinfloo.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sinfloo.demo.interfaceService.IDomicilioService;
import com.sinfloo.demo.interfaces.IDomicilio;
import com.sinfloo.demo.modelo.Domicilio;




@Service
public class DomicilioService implements IDomicilioService {
	@Autowired
	private IDomicilio datos;
	
	@Override
	public List<Domicilio> mostrar() {
		return (List<Domicilio>)datos.findAll() ;
	}

	@Override
	public Optional<Domicilio> mostrarId(int id) {
		
		return datos.findById(id);
	}

	@Override
	public int guardar(Domicilio p) {
		int res=0;
		Domicilio domicilio=datos.save(p);
		if(!domicilio.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void borrar(int id) {
		datos.deleteById(id);
		
	}

}