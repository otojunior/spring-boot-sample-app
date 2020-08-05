/**
 * 
 */
package org.otojunior.sample.app.backend.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.otojunior.sample.app.backend.entity.Arquivo;
import org.otojunior.sample.app.backend.service.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

/**
 * @author 01456231650
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@AutoConfigureTestDatabase
@WebMvcTest(
	controllers = ArquivoRest.class,
	excludeFilters = @ComponentScan.Filter(
		type = FilterType.REGEX,
		pattern = "org.otojunior.sample.app.frontend.advice.*"))
@WithMockUser(
	username = "admin",
	roles = "ADMIN")
public class ArquivoRestTest {
	@MockBean
	private ArquivoService service;
	
	@Autowired
	private MockMvc mvc;

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ArquivoRest#save(java.lang.Long, org.springframework.web.multipart.MultipartFile)}.
	 * @throws Exception 
	 */
	@Test
	public void testSave() throws Exception {
		doReturn(new Arquivo()).when(service).save(any(Arquivo.class));
		
		MockMultipartFile file = new MockMultipartFile(
			"file",
			"ArquivoRestTest_testSave.txt",
			"text/plain",
			"teste123".getBytes());
		
		mvc.perform(multipart("/api/arquivo/100")
				.file(file))
			.andDo(print())
			.andExpect(status().isOk());
	}
}
