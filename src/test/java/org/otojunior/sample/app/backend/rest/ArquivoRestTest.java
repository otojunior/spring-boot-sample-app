/**
 * 
 */
package org.otojunior.sample.app.backend.rest;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.io.File;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.otojunior.sample.app.backend.entity.Arquivo;
import org.otojunior.sample.app.backend.service.ArquivoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;
import org.springframework.http.HttpStatus;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import io.restassured.http.ContentType;
import io.restassured.module.mockmvc.RestAssuredMockMvc;

/**
 * @author 01456231650
 *
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringRunner.class)
@WebMvcTest(
	controllers=ArquivoRest.class,
	secure=false,
	properties="logging.level.org.otojunior.sample.app.backend.rest=DEBUG",
	excludeFilters=@ComponentScan.Filter(type=FilterType.REGEX, pattern="org.otojunior.sample.app.frontend.advice.*"))
public class ArquivoRestTest {
	@MockBean
	private ArquivoService service;
	
	@Autowired
	private MockMvc mvc;

	/**
	 * Test method for {@link org.otojunior.sample.app.backend.rest.ArquivoRest#save(java.lang.Long, org.springframework.web.multipart.MultipartFile)}.
	 */
	@Test
	public void testSave() {
		doReturn(new Arquivo()).when(service).save(any(Arquivo.class));
		
		RestAssuredMockMvc.
			given().mockMvc(mvc).
			multiPart(new File("ArquivoRestTest_testSave.txt")).
			contentType(ContentType.BINARY).
			when().post("/api/arquivo/100").
			then().statusCode(HttpStatus.OK.value());
	}
}
