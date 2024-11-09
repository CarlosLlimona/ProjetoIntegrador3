
package com.ProjetoFinal.ProjetoFinal.Service;

import com.ProjetoFinal.ProjetoFinal.Model.OpiniaoMoto;
import com.ProjetoFinal.ProjetoFinal.Repository.OpiniaoMotoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpiniaoMotoService {
    
    @Autowired
    OpiniaoMotoRepository opiniaoRepository;
    
    public OpiniaoMoto adicionarOpiniaoMoto(OpiniaoMoto opiniao){
        
        opiniao.setId(null);
        opiniaoRepository.save(opiniao);
        return opiniao;
        
    }
    
    public OpiniaoMoto buscarOpiniaoIndividualPeloId(Integer id){
        
        OpiniaoMoto opiniaoLocalizada = opiniaoRepository.findById(id).orElse(null);
        return opiniaoLocalizada;
        
    }
    
    public void excluirOpiniao(Integer id){
        
        OpiniaoMoto opiniaoLocalizada = buscarOpiniaoIndividualPeloId(id);
        
        if(opiniaoLocalizada!=null){
            opiniaoRepository.deleteById(id);
        }
        
    }
    
    public List<OpiniaoMoto> buscarOpinioesMoto(Integer idMoto){
        
        List<OpiniaoMoto> listaOpinioes = opiniaoRepository.findByMotoID(idMoto);
        return listaOpinioes;
    }
    
    public void excluirTodasOpinioesMoto(Integer idMoto){
        
        List<OpiniaoMoto> listaOpinioes = buscarOpinioesMoto(idMoto);
        
        if(listaOpinioes!=null){
            for(OpiniaoMoto opiniao : listaOpinioes){
                excluirOpiniao(opiniao.getId());
            }
        }
        
    }
    
}
