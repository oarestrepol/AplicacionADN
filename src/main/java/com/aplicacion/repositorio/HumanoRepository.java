package com.aplicacion.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aplicacion.modelo.HumanoModel;

@Repository
public interface HumanoRepository extends CrudRepository<HumanoModel, Long> {
	List<HumanoModel> findByEsMutante(int esMutante);
}
