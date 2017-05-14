package pl.tarko.software.finder.lozalization.controller;

import ma.glasnost.orika.MapperFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tarko.software.finder.lozalization.model.dto.LocalizationDto;
import pl.tarko.software.finder.lozalization.model.dto.LocalizationSearchParamDto;
import pl.tarko.software.finder.lozalization.model.form.LocalizationSearchParamForm;
import pl.tarko.software.finder.lozalization.service.LocalizationService;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/localization/search")
public class LocalizationSearchController {

    @Autowired
    private LocalizationService localizationService;

    @Autowired
    private MapperFacade mapper;

    @RequestMapping(method = RequestMethod.GET)
    public LocalizationSearchParamForm localizationSearchForm() {
        return new LocalizationSearchParamForm();
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<LocalizationDto> search(@Valid LocalizationSearchParamForm searchForm) {
        final List<LocalizationDto> results = new ArrayList<>();
        localizationService.findLocalizations(mapper.map(searchForm, LocalizationSearchParamDto.class));
        return results;
    }

}
