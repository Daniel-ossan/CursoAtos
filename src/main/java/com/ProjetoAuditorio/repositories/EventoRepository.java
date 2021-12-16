package com.ProjetoAuditorio.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ProjetoAuditorio.models.Evento;

//                                                         Entidade e String
public interface EventoRepository extends CrudRepository<Evento, String> {
	Evento findById(long id);
}


