
package com.ProjetoFinal.ProjetoFinal.Controller;

import com.ProjetoFinal.ProjetoFinal.Model.Sugestao;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SugestaoController {
    
    List<Sugestao> listaSugestao = new ArrayList<>();
    
    @GetMapping("/contato")
    public String mostrarTelaConta(Model model){
        
        model.addAttribute("sugestao", new Sugestao());
        
        return "contato";
    }
    
    @PostMapping("/guardar-sugestao")
    public String enviarSugestao(Model model, @ModelAttribute Sugestao sugestao){
        
        sugestao.setId(listaSugestao.size()+1);
        listaSugestao.add(sugestao);
        
        return "redirect:/tela-inicio";
        
    }
    
}
