package dev.jlkeesh;

import dev.jlkeesh.vocabulary.Vocabulary;
import dev.jlkeesh.vocabulary.VocabularyService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    private final VocabularyService vocabularyService;

    public HomeController(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }

    @GetMapping({"/home"})
    public ModelAndView homePage(@RequestParam(required = false, defaultValue = "8") int limit) {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("main");
        List<Vocabulary> vocabularies = vocabularyService.getAll(limit);
        mav.addObject("vocabularies", vocabularies);
        return mav;
    }

}
