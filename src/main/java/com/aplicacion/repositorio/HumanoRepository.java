package com.aplicacion.repositorio;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.aplicacion.modelo.HumanoModel;

/**
 * 
 * @author Omar
 * Esta interface extiende de CrudRepository y declara un metodo para consultar la base de datos buscando por el campo esMutante
 *
 */
@Repository
public interface HumanoRepository extends CrudRepository<HumanoModel, Long> {
	List<HumanoModel> findByEsMutante(int esMutante);
}
