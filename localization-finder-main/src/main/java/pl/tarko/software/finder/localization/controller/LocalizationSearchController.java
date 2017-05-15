package pl.tarko.software.finder.localization.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.tarko.software.finder.localization.model.dto.LocalizationDto;
import pl.tarko.software.finder.localization.model.dto.LocalizationSearchParamDto;
import pl.tarko.software.finder.localization.service.LocalizationService;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/localization/search")
public class LocalizationSearchController {

    @Autowired
    private LocalizationService localizationService;

    @RequestMapping(method = RequestMethod.GET)
    public LocalizationSearchParamDto search() {
        return new LocalizationSearchParamDto();
    }

    @RequestMapping(method = RequestMethod.POST)
    public List<LocalizationDto> search(@Valid LocalizationSearchParamDto searchForm) {
        final List<LocalizationDto> results = localizationService.findLocalizations(searchForm);
        return results;
    }
}
