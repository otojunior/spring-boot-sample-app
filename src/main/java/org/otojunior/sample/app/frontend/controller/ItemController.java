/**
 * 
 */
package org.otojunior.sample.app.frontend.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.otojunior.sample.app.backend.entity.Item;
import org.otojunior.sample.app.backend.service.ItemService;
import org.otojunior.sample.app.frontend.util.Navegador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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
	public String listar(
			@RequestParam Optional<Integer> pagina,
			@RequestParam Optional<Integer> tamanho,
			Model model) {
		Page<Item> itens = service.findAll(pagina, tamanho);
		Navegador navegador = Navegador.of(
			itens.getNumber(),
			itens.getTotalPages(),
			ItemService.TAMANHO_PAGINA_DEFAULT);
		model.addAttribute("itens", itens);
		model.addAttribute("nav", navegador);
		return "item/itemlist";
	}
	
	/**
	 * 
	 * @return
	 */
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Optional<Item> item = service.findById(id);
		model.addAttribute("item", item.get());
		return "item/itemedit";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes rattr) {
		service.deleteById(id);
		rattr.addFlashAttribute("idexcluido", id);
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
		return "item/itemedit";
	}
	
	/**
	 * 
	 * @param model
	 * @return
	 */
	@PostMapping("/salvar")
	public String salvar(@Valid Item item, RedirectAttributes rattr) {
		service.save(item);
		rattr.addFlashAttribute("itemsalvo", item);
		return "redirect:/item/listar";
	}
}
