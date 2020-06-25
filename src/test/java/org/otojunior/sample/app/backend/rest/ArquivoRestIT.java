/**
 * 
 */
package org.otojunior.sample.app.backend.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.multipart;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 01456231650
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc(addFilters = false)
public class ArquivoRestIT {
	@Autowired
	private MockMvc mvc;

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ArquivoRest#save(java.lang.Long, org.springframework.web.multipart.MultipartFile)}.
	 * @throws Exception 
	 */
	@Test
	@Transactional
	public void testSave() throws Exception {
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
