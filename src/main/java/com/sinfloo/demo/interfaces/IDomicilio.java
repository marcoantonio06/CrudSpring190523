package com.sinfloo.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.sinfloo.demo.modelo.Domicilio;



@Repository
public interface IDomicilio extends CrudRepository<Domicilio, Integer>{

}
