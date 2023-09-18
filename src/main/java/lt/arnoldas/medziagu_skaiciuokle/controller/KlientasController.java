package lt.arnoldas.medziagu_skaiciuokle.controller;

import lt.arnoldas.medziagu_skaiciuokle.repository.model.Klientas;
import lt.arnoldas.medziagu_skaiciuokle.service.KlientasService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping(value = "/klientas")
public class KlientasController {

    @Autowired
    private KlientasService klientasService;

    // http://localhost:8888/klientas/search
    @RequestMapping(value = "/search", method = RequestMethod.GET)      //get all klientai
    public String getKlientai(Model model){
    model.addAttribute("key_klientas", new Klientas());
    model.addAttribute("key_klientai_list", klientasService.getAll());
    return "klientu_list";
    }

    @RequestMapping(value = "/search", method = RequestMethod.POST)         // by name
    public String getKlientai(Model model, @ModelAttribute(value = "key_klientas") Klientas klientas){
        model.addAttribute("key_klientas", klientas);
        model.addAttribute(
                "key_klientai_list",
                klientasService.getKlientasByNameLike(klientas.getKlientoVardas())
        );
        return "klientu_list";
    }

    @GetMapping(value = "/id/{klientoId}")             // update klientas
    public String getKlientas(Model model, @PathVariable String klientoId) {
        Klientas klientas = klientasService.getById(klientoId);
        model.addAttribute("key_klientas", klientas);
        return "klientas_create";
    }


    // http://localhost:8888/klientas/create
    @RequestMapping(value = "/create", method = RequestMethod.GET)
    public String saveKlientas(Model model){
        model.addAttribute("key_klientas", new Klientas());
        return "klientas_create";
    }

    @RequestMapping(path = "/create", method = RequestMethod.POST)
    public String saveKlientas(Model model, @ModelAttribute(value = "key_klientas") Klientas klientas){
        String customerId = klientasService.save(klientas);
        model.addAttribute("key_klientas", klientas);
        return "klientas_create";
    }

    @GetMapping(value = "/menu")                // atidaro menu langa
    private String getMenu(){
        return "klientai_menu";
    }

    @GetMapping(value = "/samatumenu")                // atidaro menu langa
    private String getSamatuMenu(){
        return "samatos_menu";
    }

    @RequestMapping(value = "/choose", method = RequestMethod.GET)              // pasirenkam klienta, samatos kurimui
    private String chooseKlientas(Model model){
        model.addAttribute("key_klientas", new Klientas());
        model.addAttribute("key_klientai_list", klientasService.getAll());
        return "klientas_choose";
    }
    @RequestMapping(value = "/choose", method = RequestMethod.POST)         // by name
    public String chooseKlientai(Model model, @ModelAttribute(value = "key_klientas") Klientas klientas){
        model.addAttribute("key_klientas", klientas);
        model.addAttribute(
                "key_klientai_list",
                klientasService.getKlientasByNameLike(klientas.getKlientoVardas())
        );
        return "klientas_choose";
    }
}
