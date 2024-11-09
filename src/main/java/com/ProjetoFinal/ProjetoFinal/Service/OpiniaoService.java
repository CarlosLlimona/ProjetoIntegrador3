
package com.ProjetoFinal.ProjetoFinal.Service;

import com.ProjetoFinal.ProjetoFinal.Model.Opiniao;
import com.ProjetoFinal.ProjetoFinal.Repository.OpiniaoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OpiniaoService {
    
    @Autowired
    OpiniaoRepository opiniaoRepository;
    
    public Opiniao adicionarOpiniaoCarro(Opiniao opiniao){
        
        opiniao.setId(null);
        opiniaoRepository.save(opiniao);
        return opiniao;
    }
    
    public Opiniao buscarOpiniaoIndividualPeloId(Integer id){
        
        Opiniao opiniaoLocalizada = opiniaoRepository.findById(id).orElse(null);
        return opiniaoLocalizada;
    }
    
    public void excluirOpiniao(Integer id){
        
        Opiniao opiniaoLocalizada = buscarOpiniaoIndividualPeloId(id);
        
        if(opiniaoLocalizada !=null){
            opiniaoRepository.deleteById(id);
        }
        
    }
    
    
    public List<Opiniao> buscarOpinioesDoCarro(Integer idCarro){
        
        List<Opiniao> opinioesEncontradas = opiniaoRepository.findByCarroID(idCarro);
        return opinioesEncontradas;
    }
    
    public void excluirTodasOpinioesCarro(Integer idCarro){
        
        List<Opiniao> opinioesEncontradas = buscarOpinioesDoCarro(idCarro);
        
        if(opinioesEncontradas !=null){
            for(Opiniao opiniao : opinioesEncontradas){
                excluirOpiniao(opiniao.getId());
            }
        }
        
    }
    
}
