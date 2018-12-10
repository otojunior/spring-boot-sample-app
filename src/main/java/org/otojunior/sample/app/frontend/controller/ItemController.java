/**
 * 
 */
package org.otojunior.sample.app.frontend.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.otojunior.sample.app.backend.entity.Item;
import org.otojunior.sample.app.backend.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import lombok.extern.slf4j.Slf4j;

/**
 * @author 01456231650
 *
 */
@Controller
@Slf4j
public class ItemController {
	@Autowired
	private ItemService service;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/")
	public String listar(Model model) {
		List<Item> itens = service.findAll();
		model.addAttribute("itens", itens);
		return "item_list";
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		if (log.isTraceEnabled()) {
			log.trace("ItemController.editar({}) chamado", id);
		}
		
		Optional<Item> item = service.findById(id);
		model.addAttribute("item", item.get());
		return "item_edit";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, Model model) {
		if (log.isTraceEnabled()) {
			log.trace("ItemController.excluir({}) chamado", id);
		}
		
		service.deleteById(id);
		return listar(model);
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/adicionar")
	public String adicionar(Model model) {
		if (log.isTraceEnabled()) {
			log.trace("ItemController.adicionar() chamado");
		}
		
		Item item = new Item();
		model.addAttribute("item", item);
		return "item_edit";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@PostMapping
	
	public String salvar(@Valid Item item) {
		if (log.isTraceEnabled()) {
			log.trace("ItemController.salvar() chamado");
		}
		
		service.save(item);
		return "redirect:/";
	}
}
