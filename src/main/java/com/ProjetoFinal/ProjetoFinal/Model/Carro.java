
package com.ProjetoFinal.ProjetoFinal.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="carro")
public class Carro {
  
    /*Dados gerais*/
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;
    
    private String marca;
   
    private String modelo;
    
    private Integer ano_um;
    
    private Integer ultimo_ano;
    
    private Integer raridade;
    
    /*Dados tecnicos*/
    
    private Double velocidade;
    
    private Double potencia;
    
    private String combustivel;
    
    private String refrigeracao;
    
    /*Dados mecanicos*/
    
    private String motor;
    
    private String transmissao;
    
    private String suspensao;
    
}
