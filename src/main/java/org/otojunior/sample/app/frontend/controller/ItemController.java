/*
 * Copyright 2019 Oto Soares Coelho Junior.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.otojunior.sample.app.frontend.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.otojunior.sample.app.backend.dto.ItemDto;
import org.otojunior.sample.app.backend.entity.Item;
import org.otojunior.sample.app.backend.service.ItemService;
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
 * <p>ItemController class.</p>
 *
 * @author 01456231650
 * @version $Id: $Id
 */
@Controller
@RequestMapping("/item")
public class ItemController {
	@Autowired
	private ItemService service;
	
	/**
	 * <p>listar.</p>
	 *
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @return a {@link java.lang.String} object.
	 * @param itemdto a {@link org.otojunior.sample.app.backend.dto.ItemDto} object.
	 * @param operacao a {@link java.util.Optional} object.
	 */
	@GetMapping("/listar")
	public String listar(
			@RequestParam Optional<String> operacao,
			ItemDto itemdto,
			Model model) {
		Page<Item> page = service.findAll(itemdto, operacao);
		itemdto.setPage(page);
		model.addAttribute("itemdto", itemdto);
		return "item/itemlist";
	}
	
	/**
	 * <p>editar.</p>
	 *
	 * @param id a {@link java.lang.Long} object.
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @return a {@link java.lang.String} object.
	 */
	@GetMapping("/editar/{id}")
	public String editar(@PathVariable("id") Long id, Model model) {
		Optional<Item> item = service.findById(id);
		model.addAttribute("item", item.get());
		return "item/itemedit";
	}
	
	/**
	 * <p>excluir.</p>
	 *
	 * @param id a {@link java.lang.Long} object.
	 * @param rattr a {@link org.springframework.web.servlet.mvc.support.RedirectAttributes} object.
	 * @return a {@link java.lang.String} object.
	 */
	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, RedirectAttributes rattr) {
		service.deleteById(id);
		rattr.addFlashAttribute("idexcluido", id);
		return "redirect:/item/listar";
	}
	
	/**
	 * <p>adicionar.</p>
	 *
	 * @param model a {@link org.springframework.ui.Model} object.
	 * @return a {@link java.lang.String} object.
	 */
	@GetMapping("/adicionar")
	public String adicionar(Model model) {
		Item item = new Item();
		model.addAttribute("item", item);
		return "item/itemedit";
	}
	
	/**
	 * <p>salvar.</p>
	 *
	 * @param item a {@link org.otojunior.sample.app.backend.entity.Item} object.
	 * @param rattr a {@link org.springframework.web.servlet.mvc.support.RedirectAttributes} object.
	 * @return a {@link java.lang.String} object.
	 */
	@PostMapping("/salvar")
	public String salvar(@Valid Item item, RedirectAttributes rattr) {
		service.save(item);
		rattr.addFlashAttribute("itemsalvo", item);
		return "redirect:/item/listar";
	}
}
