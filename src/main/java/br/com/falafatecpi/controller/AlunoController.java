package br.com.falafatecpi.controller;

import br.com.falafatecpi.model.AlunoModel;
import br.com.falafatecpi.service.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class AlunoController {

    @Autowired
    private final AlunoService alunoService;

    public AlunoController(AlunoService alunoService) {
        this.alunoService = alunoService;
    }

    @GetMapping("/cadastro")
    public String getRegisterPage(Model model){
        model.addAttribute("cadastroRequest", new AlunoModel());
        return "cadastro.html";
    }

    @GetMapping("/login")
    public String getLoginPage(Model model){
        model.addAttribute("loginRequest", new AlunoModel());
        return "login.html";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@ModelAttribute AlunoModel alunoModel){
        System.out.println("Cadastro request: " + alunoModel);
        AlunoModel registerUser = alunoService.registerUser(alunoModel.getRa(), alunoModel.getEmail(), alunoModel.getSenha());
        return registerUser == null ? "error_page" : "redirect:/login";
    }

    @PostMapping("/login")
    public String login(@ModelAttribute AlunoModel alunoModel, Model model){
        System.out.println("login request: " + alunoModel);
        AlunoModel authenticated = alunoService.authenticate(alunoModel.getEmail(), alunoModel.getSenha());
        if(authenticated != null){
            model.addAttribute("alunoLogin", authenticated.getEmail());
            return "home";
        }else {
            return "error_page";
        }
    }



}
