
package com.ProjetoFinal.ProjetoFinal.Service;

import com.ProjetoFinal.ProjetoFinal.Model.Carro;
import com.ProjetoFinal.ProjetoFinal.Repository.CarroRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CarroService {
    
    @Autowired
    CarroRepository carroRepository;
    
    
    public Carro adicionarCarro(Carro carro){
        
        carro.setId(null);
        carroRepository.save(carro);
        return carro;
        
    }
    
    public List<Carro> buscarCarros(){
        
        List<Carro> listaCarros = carroRepository.findAll();
        return listaCarros;
    }
    
    public Carro buscarCarroPeloId(Integer id){
        
        Carro carroLocalizado = carroRepository.findById(id).orElse(null);
        return carroLocalizado;
    }
    
    public Carro atualizarCarro(Integer id, Carro carro){
        
        Carro carroLocalizado = buscarCarroPeloId(id);
        
        if(carroLocalizado.getId() !=null){
            
            carroLocalizado.setMarca(carro.getMarca());
            carroLocalizado.setModelo(carro.getModelo());
            carroLocalizado.setAno_um(carro.getAno_um());
            carroLocalizado.setUltimo_ano(carro.getUltimo_ano());
            carroLocalizado.setRaridade(carro.getRaridade());
            
            carroLocalizado.setCombustivel(carro.getCombustivel());
            carroLocalizado.setRefrigeracao(carro.getRefrigeracao());
            carroLocalizado.setMotor(carro.getMotor());
            carroLocalizado.setTransmissao(carro.getTransmissao());
            carroLocalizado.setSuspensao(carro.getSuspensao());
            
            carroLocalizado.setVelocidade(carro.getVelocidade());
            carroLocalizado.setPotencia(carro.getPotencia());
            
            carroRepository.save(carroLocalizado);
        }
        
        return carroLocalizado;
        
    }
    
    public void excluirCarro(Integer id){
        
        Carro carroLocalizado = buscarCarroPeloId(id);
        
        if(carroLocalizado!=null){
            carroRepository.deleteById(id);
        }
        
    }
    
}
