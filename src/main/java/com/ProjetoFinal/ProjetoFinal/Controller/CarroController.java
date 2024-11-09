
package com.ProjetoFinal.ProjetoFinal.Controller;

import com.ProjetoFinal.ProjetoFinal.Model.Carro;
import com.ProjetoFinal.ProjetoFinal.Model.Dados;
import com.ProjetoFinal.ProjetoFinal.Model.Moto;
import com.ProjetoFinal.ProjetoFinal.Model.Opiniao;
import com.ProjetoFinal.ProjetoFinal.Model.OpiniaoMoto;
import com.ProjetoFinal.ProjetoFinal.Service.CarroService;
import com.ProjetoFinal.ProjetoFinal.Service.MotoService;
import com.ProjetoFinal.ProjetoFinal.Service.OpiniaoMotoService;
import com.ProjetoFinal.ProjetoFinal.Service.OpiniaoService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CarroController {
    
    @Autowired
    CarroService carroService;
    
    @Autowired
    OpiniaoService opiniaoCarroService;
    
    @Autowired
    MotoService motoService;
    
    @Autowired
    OpiniaoMotoService opiniaoMotoService;
    
    
    private List<Carro> listaCarros = new ArrayList<>();
    private List<Opiniao> listaOpinioes = new ArrayList<>();
    
    private List<Moto> listaMotos = new ArrayList<>();
    private List<OpiniaoMoto> listaOpMoto = new ArrayList<>();
    
    @GetMapping("/tela-inicio")
    public String mostrarHome(Model model){
       // model.addAttribute("lista", listaOpinioes);
        return "index";
    }
    
    @GetMapping("/inserir-carro")
    public String mostraCadastroCarro(Model model){
        
        model.addAttribute("carrinho", new Carro());
        model.addAttribute("marca", Dados.marcasCarro());
        model.addAttribute("combustivel", Dados.combustiveis());
        model.addAttribute("refrigeracao", Dados.refrigeracao());
        
        
        return "cadastro-carro";
    }
    
    @GetMapping("/galeria-carros")
    public String mostrarGaleriaCarros(Model model){
        //model.addAttribute("carros", listaCarros);
        model.addAttribute("carros", carroService.buscarCarros());
        //model.addAttribute("motos", listaMotos);
        model.addAttribute("motos", motoService.buscarMotos());
        return "galeria-carros";
    }
    
    
    @PostMapping("/guardar-carro")
    public String processarFormularioCarro(Model model, @ModelAttribute("carrinho") Carro carro){
        
        if(carro.getId()!=null){
            carroService.atualizarCarro(carro.getId(),carro);
        }else{
            carroService.adicionarCarro(carro);
        }
      /*  if(carro.getId()!=null){
            
            for(Carro car: listaCarros){
                
                if(car.getId()==carro.getId()){
                    
                    car.setMarca(carro.getMarca());
                    car.setModelo(carro.getModelo());
                    car.setAno_um(carro.getAno_um());
                    car.setUltimo_ano(carro.getUltimo_ano());
                    car.setCombustivel(carro.getCombustivel());
                    car.setMotor(carro.getMotor());
                    car.setPotencia(carro.getPotencia());
                    car.setVelocidade(carro.getVelocidade());
                    car.setRaridade(carro.getRaridade());
                    car.setRefrigeracao(carro.getRefrigeracao());
                    car.setSuspensao(carro.getSuspensao());
                    car.setTransmissao(carro.getTransmissao());
                    
                    
                    break;
                }
            }
        }
        else{
            carro.setId(listaCarros.size()+1);
            listaCarros.add(carro);
        }*/
        
        return "redirect:/galeria-carros";
        
    }
    
    
     
    @GetMapping("/atualizar-veiculo/{id}")
    public String atualizarCarro(Model model,@PathVariable(value="id")Integer id){
      /*  Integer idCarro = Integer.parseInt(id);
        Carro carroLocalizado = new Carro();
        
        for(Carro carro : listaCarros){
            if(carro.getId()==idCarro){
                carroLocalizado = carro;
                break;
            }
        }*/
        
        Carro carroLocalizado = carroService.buscarCarroPeloId(id);
      
      
        model.addAttribute("carrinho", carroLocalizado);
        model.addAttribute("marca", Dados.marcasCarro());
        model.addAttribute("combustivel", Dados.combustiveis());
        model.addAttribute("refrigeracao", Dados.refrigeracao());
        
        return "cadastro-carro";
    }
    
    @GetMapping("/excluir-carro/{id}")
    public String excluirCarro(Model model, @PathVariable(value="id")Integer idCarro){
        
        opiniaoCarroService.excluirTodasOpinioesCarro(idCarro);
        
        carroService.excluirCarro(idCarro);
        
       /* Integer idCarro = Integer.parseInt(id);
        
        Carro carroEncontrado = new Carro();
        for(Carro carro : listaCarros){
            
            if(carro.getId()==idCarro){
                
                carroEncontrado = carro;
                break;
            }
        }    
        
        List<Opiniao> opinioesCarro = new ArrayList<>();
        for(Opiniao opiniao:listaOpinioes){
            if(opiniao.getCarroID() == idCarro){
                opinioesCarro.add(opiniao);
            }
        }
        
        if(opinioesCarro!=null){
            
            for(Opiniao ops : opinioesCarro){
                listaOpinioes.remove(ops);
            }
            listaCarros.remove(carroEncontrado);
        }
        else{
            listaCarros.remove(carroEncontrado);
        }*/
        
        return "redirect:/galeria-carros";

    }
    
    
    
    @GetMapping("/exibir-carro/{id}")
    public String mostrarTelaFichaCarro(Model model, @PathVariable(value="id")Integer id){
        
        Carro carroEncontrado = carroService.buscarCarroPeloId(id);
        
        List<Opiniao> opinioesEncontradas = opiniaoCarroService.buscarOpinioesDoCarro(id);
        
       /* Integer idCarro = Integer.parseInt(id);
        
        Carro carroEncontrado = new Carro();
        
        for(Carro carrinho : listaCarros){
            if(carrinho.getId()==idCarro){
                carroEncontrado = carrinho;
                break;
            }
        }
        
        List<Opiniao> opinioesEncontradas = new ArrayList<>();
        for(Opiniao opiniao:listaOpinioes){
            if(opiniao.getCarroID()==idCarro){  
                opinioesEncontradas.add(opiniao);
            }
        }*/
        
        model.addAttribute("carrinho", carroEncontrado);
        model.addAttribute("opinioes", opinioesEncontradas);
        model.addAttribute("novaOpiniao", new Opiniao());
        
        return "ficha-tecnica-carro";
    }
    
    @PostMapping("/guardar-opiniao")
    public String processarFormularioOpiniao(Model model, @ModelAttribute("novaOpiniao") Opiniao opiniao, @ModelAttribute("carrinho") Carro carrinho){
       // Integer idCarrinho = Integer.parseInt(idCarro);
        
        //opiniao.setCarroID(idCarrinho); /*Ficar esperto*/
        
       /* opiniao.setId(listaOpinioes.size()+1);
        listaOpinioes.add(opiniao);*/
       
       opiniaoCarroService.adicionarOpiniaoCarro(opiniao);
        
        return "redirect:/galeria-carros";
    }
    
    @GetMapping("/excluir-opiniao/{id}")
    public String excluirOpiniaoIndividual(Model model, @PathVariable(value="id")Integer id){
        
        opiniaoCarroService.excluirOpiniao(id);
        
        /*Integer idOpiniao = Integer.parseInt(id);
        
        for(Opiniao opiniao : listaOpinioes){
            
            if(opiniao.getId()==idOpiniao){
                listaOpinioes.remove(opiniao);
                break;
            }
            
        }*/
        
        return "redirect:/galeria-carros";
    }
    
    /*Processos referentes à moto*/
    
    @GetMapping("/inserir-moto")
    public String mostraCadastroMoto(Model model){
        
        model.addAttribute("moto", new Moto());
        model.addAttribute("marca", Dados.marcasMoto());
        model.addAttribute("combustivel", Dados.combustiveis());
        model.addAttribute("refrigeracao", Dados.refrigeracao());
        
        
        return "cadastro-moto";
    }
    
    @PostMapping("/guardar-moto")
    public String processarFormularioMoto(Model model, @ModelAttribute("moto") Moto moto){
        
        if(moto.getId()!=null){
            motoService.atualizarMoto(moto.getId(), moto);
        }else{
            motoService.adicionarMoto(moto);
        }
       /* if(moto.getId()!=null){
            
            for(Moto mot : listaMotos){
                
                if(mot.getId()==moto.getId()){
                    
                    mot.setMarca(moto.getMarca());
                    mot.setModelo(moto.getModelo());
                    mot.setAno_um(moto.getAno_um());
                    mot.setUltimo_ano(moto.getUltimo_ano());
                    mot.setVelocidade(moto.getVelocidade());
                    mot.setPotencia(moto.getPotencia());
                    mot.setMotor(moto.getMotor());
                    mot.setCapacidade_cubica(moto.getCapacidade_cubica());
                    mot.setTransmissao(moto.getTransmissao());
                    mot.setSuspensao(moto.getSuspensao());
                    mot.setRaridade(moto.getRaridade());
                    mot.setCombustivel(moto.getCombustivel());
                    mot.setRefrigeracao(moto.getRefrigeracao());
                    break;
                     
                }
            }

        }else{
            moto.setId(listaMotos.size()+1);
            listaMotos.add(moto);
        }*/
        
        return "redirect:/galeria-carros";
        
    }
    
    @GetMapping("/atualizar-moto/{id}")
    public String atualizarMoto(Model model, @PathVariable(value="id")Integer id){
        
     /*   Integer idMoto = Integer.parseInt(id);
        Moto motoLocalizada = new Moto();
        
        for(Moto moto: listaMotos){
            if(moto.getId()==idMoto){
                motoLocalizada = moto;
                break;
            }
        }*/
        
        Moto motoLocalizada = motoService.buscarMotoPeloId(id);
        
        model.addAttribute("moto", motoLocalizada);
        model.addAttribute("marca", Dados.marcasMoto());
        model.addAttribute("combustivel", Dados.combustiveis());
        model.addAttribute("refrigeracao", Dados.refrigeracao());
        
        
        return "cadastro-moto";
        
    }
    
    @GetMapping("/excluir-moto/{id}")
    public String excluirMoto(Model model, @PathVariable(value="id")Integer idMoto){
        
        opiniaoMotoService.excluirTodasOpinioesMoto(idMoto);
        
        motoService.excluirMoto(idMoto);
        
       /* Integer idMoto = Integer.parseInt(id);
        
        Moto motoLocalizada = new Moto();
        for(Moto moto: listaMotos){
            
            if(moto.getId()==idMoto){
                motoLocalizada = moto;
                break;
            }
            
        }
        
        List<OpiniaoMoto> opinioesMoto = new ArrayList<>();
        for(OpiniaoMoto opiniao : listaOpMoto){
            if(opiniao.getMotoID()==idMoto){
                opinioesMoto.add(opiniao);
            }
        }
        
        if(opinioesMoto!=null){
            
            for(OpiniaoMoto ops: opinioesMoto){
                listaOpMoto.remove(ops);
            }
            listaMotos.remove(motoLocalizada);
        }
        else{
            listaMotos.remove(motoLocalizada);
        }*/
        
         return "redirect:/galeria-carros";
        
    }
    
    @GetMapping("/exibir-moto/{id}")
    public String mostrarFichaMoto(Model model, @PathVariable(value="id")Integer id){
        
        Moto motoLocalizada = motoService.buscarMotoPeloId(id);
        
        List<OpiniaoMoto> opinioesEncontradas = opiniaoMotoService.buscarOpinioesMoto(id);
        
        /*Integer idMoto = Integer.parseInt(id);
        
        Moto motoLocalizada = new Moto();
        for(Moto moto: listaMotos){
            if(moto.getId()==idMoto){
                motoLocalizada = moto;
                break;
            }
        }
        
        List<OpiniaoMoto> opinioesEncontradas = new ArrayList<>();
        for(OpiniaoMoto opiniao: listaOpMoto){
            if(opiniao.getMotoID()==idMoto){
                opinioesEncontradas.add(opiniao);
            }
        }*/
        
        model.addAttribute("moto",motoLocalizada);
        model.addAttribute("opinioes", opinioesEncontradas);
        model.addAttribute("novaOpiniao", new OpiniaoMoto());
        
        return "ficha-tecnica-moto";
        
    }
    
    @PostMapping("/guardar-opiniaoMoto")
    public String processarFormularioOPmoto(Model model,@ModelAttribute("novaOpiniao") OpiniaoMoto opiniao, @ModelAttribute("moto") Moto moto){
        
       /* opiniao.setId(listaOpMoto.size()+1);
        listaOpMoto.add(opiniao);*/
       
       opiniaoMotoService.adicionarOpiniaoMoto(opiniao);
        
        return "redirect:/galeria-carros";
        
    }
    
    @GetMapping("/excluir-opiniaoMoto/{id}")
    public String excluirOPmoto(Model model,@PathVariable(value="id")Integer id){
        
        opiniaoMotoService.excluirOpiniao(id);
        
      /*  Integer idOpiniao = Integer.parseInt(id);
        
        for(OpiniaoMoto opiniao: listaOpMoto){
            
            if(opiniao.getId()==idOpiniao){
                listaOpMoto.remove(opiniao);
                break;
            }
            
        }*/
         return "redirect:/galeria-carros";
        
    }
    
    
}
