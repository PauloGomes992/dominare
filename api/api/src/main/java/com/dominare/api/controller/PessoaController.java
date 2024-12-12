package com.dominare.api.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import com.dominare.api.model.pessoa.PessoaModel;
import com.dominare.api.model.pessoa.PessoaRepository;

import jakarta.transaction.Transactional;

@RequestMapping("/sistema/morador")
@Controller

public class PessoaController {

    @Autowired
    private PessoaRepository repository;
    
    // MÉTODOS HTTPS
    
    // Get
    @GetMapping("/")
    public String listarPessoas (){
        return "sistema/morador/morador";
    }

    @GetMapping("/pesquisar")
    public String mostrarFormulario (Model model){
        model.addAttribute("pessoas", repository.findAll());
        return "sistema/morador/listaMorador";
    }

    @GetMapping("/cadastro")
    public String cadastrarMorador (Model model){
        model.addAttribute("pessoa", new PessoaModel());
        return "sistema/morador/cadastroMorador";
    }

    // Post
    // @PostMapping("/cadastroPessoa")
    @PostMapping("/cadastro")
    @Transactional
    public String salvarPessoa(@ModelAttribute PessoaModel pessoa) {
        repository.save(pessoa);
        return "redirect:/sistema/morador/pesquisar";
}



    // Put

    // Delete

}
