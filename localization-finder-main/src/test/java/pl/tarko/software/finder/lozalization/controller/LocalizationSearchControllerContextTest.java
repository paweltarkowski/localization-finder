package pl.tarko.software.finder.lozalization.controller;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import pl.tarko.software.finder.MainPreConfiguredContextTest;
import pl.tarko.software.finder.lozalization.model.dto.LocalizationDto;
import pl.tarko.software.finder.lozalization.service.LocalizationService;

import java.util.Arrays;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

@WebMvcTest(LocalizationSearchController.class)
public class LocalizationSearchControllerContextTest extends MainPreConfiguredContextTest {

    @MockBean
    LocalizationService localizationService;

    @Autowired
    private MockMvc mvc;

    @Test
    public void shouldIncludeContacts() throws Exception {
        given(this.localizationService.findLocalizations(any()))
                .willReturn(Arrays.asList(LocalizationDto.builder().id(1L).build()));

        this.mvc.perform(get("/localization/search").accept(MediaType.TEXT_HTML)).andExpect(status().isOk())
                .andExpect(view().name("localization/search"));
    }

}
