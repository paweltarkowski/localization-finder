package pl.tarko.software.finder.localization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tarko.software.finder.localization.model.dto.CountryDto;
import pl.tarko.software.finder.localization.model.dto.LocalizationDto;
import pl.tarko.software.finder.localization.model.dto.LocalizationSearchParamDto;
import pl.tarko.software.finder.localization.service.CountryService;
import pl.tarko.software.finder.localization.service.LocalizationService;

import java.util.List;

@Controller
@RequestMapping("/localization/search")
public class LocalizationSearchController {

    protected static final String SEARCH_VIEW_NAME = "localization/search";

    @Autowired
    private LocalizationService localizationService;

    @Autowired
    private CountryService countryService;

    @RequestMapping(method = RequestMethod.GET)
    public String search(Model model) {
        model.addAttribute("searchForm", new LocalizationSearchParamDto());
        return SEARCH_VIEW_NAME;
    }

    @RequestMapping(method = RequestMethod.POST)
    public String search(@ModelAttribute(name = "searchForm") LocalizationSearchParamDto searchForm, Model model) {
        final List<LocalizationDto> results = localizationService.findLocalizations(searchForm);
        model.addAttribute("results", results);
        return SEARCH_VIEW_NAME;
    }

    @ModelAttribute("countries")
    public List<CountryDto> getCountries() {
        return countryService.findAll();
    }
}
