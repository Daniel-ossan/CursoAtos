package com.ProjetoAuditorio.repositories;

import org.springframework.data.repository.CrudRepository;

import com.ProjetoAuditorio.models.Evento;
import com.ProjetoAuditorio.models.Participante;

public interface ParticipanteRepository extends CrudRepository<Participante, String> {
	Iterable<Participante> findByEvento(Evento evento);
	Participante findByRg(String rg);
}
