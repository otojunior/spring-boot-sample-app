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
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author 01456231650
 *
 */
@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService service;
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/listar")
	public String listar(Model model) {
		List<Item> itens = service.findAll();
		model.addAttribute("itens", itens);
		return "itemlist";
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Optional<Item> item = service.findById(id);
		model.addAttribute("item", item.get());
		return "itemedit";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, Model model) {
		service.deleteById(id);
		return "redirect:/item/listar";
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/adicionar")
	public String adicionar(Model model) {
		Item item = new Item();
		model.addAttribute("item", item);
		return "itemedit";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@PostMapping("/salvar")
	public String salvar(@Valid Item item) {
		service.save(item);
		return "redirect:/item/listar";
	}
}
