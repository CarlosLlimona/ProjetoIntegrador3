
package com.ProjetoFinal.ProjetoFinal.Service;

import com.ProjetoFinal.ProjetoFinal.Model.Moto;
import com.ProjetoFinal.ProjetoFinal.Repository.MotoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotoService {
    
    @Autowired
    MotoRepository motoRepository;
    
    
    public Moto adicionarMoto(Moto moto){
        
        moto.setId(null);
        motoRepository.save(moto);
        return moto;
        
    }
    
    public List<Moto> buscarMotos(){
        
        List<Moto> listaMotos = motoRepository.findAll();
        return listaMotos;
        
    }
    
    public Moto buscarMotoPeloId(Integer id){
        
        Moto motoLocalizada = motoRepository.findById(id).orElse(null);
        return motoLocalizada;
    }
    
    public Moto atualizarMoto(Integer id,Moto moto){
        
        Moto motoLocalizada = buscarMotoPeloId(id);
        
        if(motoLocalizada.getId()!=null){
            
            motoLocalizada.setMarca(moto.getMarca());
            motoLocalizada.setModelo(moto.getModelo());
            motoLocalizada.setAno_um(moto.getAno_um());
            motoLocalizada.setUltimo_ano(moto.getUltimo_ano());
            motoLocalizada.setRaridade(moto.getRaridade());
            
            motoLocalizada.setMotor(moto.getMotor());
            motoLocalizada.setTransmissao(moto.getTransmissao());
            motoLocalizada.setSuspensao(moto.getSuspensao());
            motoLocalizada.setCombustivel(moto.getCombustivel());
            motoLocalizada.setRefrigeracao(moto.getRefrigeracao());
            motoLocalizada.setCapacidade_cubica(moto.getCapacidade_cubica());
            
            motoLocalizada.setVelocidade(moto.getVelocidade());
            motoLocalizada.setPotencia(moto.getPotencia());
            
            motoRepository.save(motoLocalizada);
        }
        
        return motoLocalizada;
        
    }
    
    public void excluirMoto(Integer id){
        
        Moto motoLocalizada = buscarMotoPeloId(id);
        
        if(motoLocalizada!=null){
            motoRepository.deleteById(id);
        }
        
    }
    
    
    
    
}
