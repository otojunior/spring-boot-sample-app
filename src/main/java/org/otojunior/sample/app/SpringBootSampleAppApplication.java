package org.otojunior.sample.app;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.otojunior.sample.app.backend.entity.Item;
import org.otojunior.sample.app.backend.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 
 * @author 01456231650
 *
 */
@SpringBootApplication
public class SpringBootSampleAppApplication implements CommandLineRunner {
	@Autowired
	private ItemRepository repository;
	
	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(SpringBootSampleAppApplication.class, args);
	}

	/**
	 * 
	 */
	@Override
	public void run(String... args) throws Exception {
		List<Item> itens = new ArrayList<>();
		for (int i = 0; i < 245; i++) {
			Item item = new Item();
			item.setCodigo(Long.valueOf(1000+i));
			item.setNome("Teste " + (i+1));
			item.setPreco(new BigDecimal(i+1));
			itens.add(item);
		}
		repository.saveAll(itens);
	}
}
