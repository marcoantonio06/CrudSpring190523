package com.sinfloo.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.sinfloo.demo.modelo.Domicilio;



public interface IDomicilioService {
	public List<Domicilio>mostrar();
	public Optional<Domicilio>mostrarId(int id);
	public int guardar(Domicilio p);
	public void borrar(int id);
}
