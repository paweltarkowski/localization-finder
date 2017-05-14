package pl.tarko.software.finder.lozalization.controller;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

import java.util.Arrays;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.impl.ConfigurableMapper;
import pl.tarko.software.finder.PreconfiguredTransactionalTest;
import pl.tarko.software.finder.lozalization.model.dto.LocalizationDto;
import pl.tarko.software.finder.lozalization.service.LocalizationService;

@WebMvcTest(LocalizationSearchController.class)
public class LocalizationSearchControllerTest extends PreconfiguredTransactionalTest {

	@Autowired
	private MockMvc mvc;

	@MockBean
	LocalizationService localizationService;
	/*
		@MockBean
		MapperFacade mapperFacade = new ConfigurableMapper();
	*/
	@Test
	public void shouldIncludeContacts() throws Exception {
		given(this.localizationService.findLocalizations(any()))
				.willReturn(Arrays.asList(LocalizationDto.builder().id(1L).build()));

		this.mvc.perform(get("/localization/search").accept(MediaType.TEXT_HTML)).andExpect(status().isOk())
				.andExpect(view().name("localizationSearchForm"));
	}

}
