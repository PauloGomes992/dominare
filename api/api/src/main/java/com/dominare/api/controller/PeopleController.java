package com.dominare.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.dominare.api.model.people.PeopleModel;
import com.dominare.api.model.people.PeopleRepository;

import jakarta.transaction.Transactional;

@RequestMapping("/sistema/visitante")
@Controller

public class PeopleController {

    @Autowired
    private PeopleRepository repository;
    
    // MÉTODOS HTTPS
    
    // Get
    @GetMapping("/")
    public String listarPeoples (){
        return "sistema/visitante/visitante";
    }

    @GetMapping("/pesquisar")
    public String mostrarFormulario (Model model){
        model.addAttribute("peoples", repository.findAll());
        return "sistema/visitante/listaVisitante";
    }

    @GetMapping("/cadastro")
    public String cadastrarVisitante (Model model){
        model.addAttribute("people", new PeopleModel());
        return "sistema/visitante/cadastroVisitante";
    }

    // Post
    // @PostMapping("/cadastroPeople")
    @PostMapping("/cadastro")
    @Transactional
    public String salvarPeople(@ModelAttribute PeopleModel people) {
        repository.save(people);
        return "redirect:/sistema/visitante/pesquisar";
}



    // Put

    // Delete

}
