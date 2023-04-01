package dev.jlkeesh.vocabulary;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/vocabulary")
public class VocabularyController {
    private final VocabularyService vocabularyService;

    public VocabularyController(VocabularyService vocabularyService) {
        this.vocabularyService = vocabularyService;
    }


    @GetMapping("/create")
    public ModelAndView createPage() {
        ModelAndView mav = new ModelAndView();
        mav.setViewName("vocab/create");
        return mav;
    }

    @PostMapping("/create")
    public String create(@ModelAttribute VocabularyCreateDTO dto) {
        vocabularyService.create(dto);
        return "redirect:/home";
    }

}
