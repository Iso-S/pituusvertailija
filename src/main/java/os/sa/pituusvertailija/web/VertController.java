package os.sa.pituusvertailija.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.validation.Valid;
import os.sa.pituusvertailija.domain.EsineRepository;
import os.sa.pituusvertailija.domain.KategoriaRepository;
import os.sa.pituusvertailija.service.EsineService;
import os.sa.pituusvertailija.domain.Esine;
import os.sa.pituusvertailija.domain.Kategoria;

@Controller
public class VertController {

    @Autowired
    private EsineRepository EsineRepository;

    @Autowired
    private KategoriaRepository KategoriaRepository;

    @Autowired
    private EsineService esineService;

    @GetMapping("/")
    public String home() {
        return "index";
    }

    @GetMapping("/esineet")
    public String esineet(Model model) {
        model.addAttribute("esineet", EsineRepository.findAll());
        model.addAttribute("kategoriat", KategoriaRepository.findAll());
        return "esinekirjasto";
    }

    @GetMapping("/vertailu")
    public String vertailu(Model model) {
        model.addAttribute("esineet", EsineRepository.findAll());
        return "vertailu";
    }

    @PostMapping("/vertaa")
    public String vertaaPituus(@RequestParam("esine1") Long id1, @RequestParam("esine2") Long id2, Model model) {
        String tulos = esineService.vertaaPituus(id1, id2);
        model.addAttribute("esineet", EsineRepository.findAll());
        model.addAttribute("tulos", tulos);
        return "vertailu";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/uusiesine")
    public String uusiEsine(Model model) {
        model.addAttribute("esine", new Esine());
        model.addAttribute("kategoriat", KategoriaRepository.findAll());
        return "uusiesine";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/uusikategoria")
    public String uusiKategoria(Model model) {
        model.addAttribute("kategoria", new Kategoria());
        return "uusikategoria";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/delete/{id}")
    public String deleteEsine(@PathVariable("id") Long esineid, Model model) {
        EsineRepository.deleteById(esineid);
        return "redirect:../esineet";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping("/edit/{id}")
    public String editTuote(@PathVariable("id") Long esineid, Model model) {
        model.addAttribute("esine", EsineRepository.findById(esineid));
        model.addAttribute("kategoriat", KategoriaRepository.findAll());
        return "muokkaaesine";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/saveedit")
    public String saveEdit(@Valid Esine esine, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("kategoriat", KategoriaRepository.findAll());
            return "muokkaaesine";
        }
        EsineRepository.save(esine);
        return "redirect:esineet";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/save")
    public String save(@Valid Esine esine, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            model.addAttribute("kategoriat", KategoriaRepository.findAll());
            return "uusiesine";
        }
        EsineRepository.save(esine);
        return "redirect:esineet";
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @PostMapping("/savekat")
    public String saveKat(@Valid Kategoria kategoria, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return "uusikategoria";
        }
        KategoriaRepository.save(kategoria);
        return "redirect:esineet";
    }
}