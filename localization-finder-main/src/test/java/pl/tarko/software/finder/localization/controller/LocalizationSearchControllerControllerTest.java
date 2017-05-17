package pl.tarko.software.finder.localization.controller;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import pl.tarko.software.finder.PreConfiguredControllerTest;
import pl.tarko.software.finder.localization.model.dto.LocalizationSearchParamDto;
import pl.tarko.software.finder.localization.service.LocalizationService;

import java.util.ArrayList;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.any;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class LocalizationSearchControllerControllerTest extends PreConfiguredControllerTest {

    @InjectMocks
    private LocalizationSearchController controller;

    @Mock
    LocalizationService localizationService;

    @Before
    public void setup(){
        initSetup(controller);
    }

    @Test
    public void shouldReturnSearchForm() throws Exception {
        this.mockMvc.perform(get("/localization/search").accept(MediaType.TEXT_HTML)).andExpect(status().isOk())
                .andExpect(view().name(LocalizationSearchController.SEARCH_VIEW_NAME));
    }

    @Test
    public void shouldSearchLocalizations() throws Exception {
        given(localizationService.findLocalizations(any())).willReturn(new ArrayList<>());

        this.mockMvc.perform(post("/localization/search").requestAttr("searchForm", new LocalizationSearchParamDto()).accept(MediaType.TEXT_HTML)).andExpect(status().isOk())
                .andExpect(view().name(LocalizationSearchController.SEARCH_VIEW_NAME));
    }

}
