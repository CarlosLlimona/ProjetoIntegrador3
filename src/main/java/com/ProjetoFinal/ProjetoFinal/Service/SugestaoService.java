
package com.ProjetoFinal.ProjetoFinal.Service;

import com.ProjetoFinal.ProjetoFinal.Model.Sugestao;
import com.ProjetoFinal.ProjetoFinal.Repository.SugestaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class SugestaoService {
    
    @Autowired
    SugestaoRepository sugestaoRepository;
    
    public Sugestao adicionarSugestao(Sugestao sugestao){
        
        sugestao.setId(null);
        sugestaoRepository.save(sugestao);
        
        return sugestao;
        
    }
    
}
