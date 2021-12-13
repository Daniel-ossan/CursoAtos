package com.ProjetoAuditorio.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.ProjetoAuditorio.models.Evento;
import com.ProjetoAuditorio.models.Participante;
import com.ProjetoAuditorio.repositories.EventoRepository;
import com.ProjetoAuditorio.repositories.ParticipanteRepository;

@Controller
public class EventoController {
	
	//INJETANDO DEPENDÊNCIAS

	@Autowired
	private EventoRepository er;

	@Autowired
	private ParticipanteRepository pr;
	
	// Lê o estado atual do banco de dados
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.GET)
	public String form() {
		return "eventoForm";
	}

	// Insere no banco de dados
	@RequestMapping(value = "/cadastrarEvento", method = RequestMethod.POST)
	public String form(Evento evento) {

		// Persistir evento no banco de dados.
		er.save(evento);

		return "redirect:/cadastrarEvento";
	}

	// Metodo pra retornar a lista de eventos no banco de dados.
	@RequestMapping("/eventos")
	public ModelAndView listaEventos() {
		ModelAndView mv = new ModelAndView("index");
		Iterable<Evento> eventos = er.findAll(); // Busca todos no BD
		// ${eventos] Como está salvo no index
		mv.addObject("eventos", eventos);
		return mv;
	}
	
	@RequestMapping(value =  "/{id}", method = RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("id") long id) {
		Evento evento = er.findById(id);
		ModelAndView mv = new ModelAndView("detalhesEvento");
		mv.addObject("evento", evento);
		return mv;
	}
	
	
	
	@RequestMapping(value = "/{id}", method = RequestMethod.POST)
	public String detalhesEvento(@PathVariable("id") long id, Participante participante) {
		Evento evento = er.findById(id);
		participante.setEvento(evento);
		pr.save(participante);
		
		return "redirect:/{id}";
	} 
	
	

}
