package com.ProjetoAuditorio.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
public class Participante {
	
	@Id
	private String rg;
	private String nomeParticipante;
	
	@ManyToOne
	private Evento evento;

	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	
	public String getRg() {
		return rg;
	}
	public void setRg(String rg) {
		this.rg = rg;
	}
	public String getNome() {
		return nomeParticipante;
	}
	public void setNome(String nomeParticipante) {
		this.nomeParticipante = nomeParticipante;
	}
	
	
	

	
}
