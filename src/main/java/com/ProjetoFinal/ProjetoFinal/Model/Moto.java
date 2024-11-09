
package com.ProjetoFinal.ProjetoFinal.Model;

import lombok.Data;

@Data
public class Moto {
    
        /*Dados gerais*/
    private Integer id;
    
    private String marca;
   
    private String modelo;
    
    private Integer ano_um;
    
    private Integer ultimo_ano;
    
    private Integer raridade;
    
    /*Dados tecnicos*/
    
    private Double velocidade;
    
    private Double potencia;
    
    private String refrigeracao;
    
    private String combustivel;
    
    /*Dados mecanicos*/
    
    private String motor;
    
    private Integer capacidade_cubica;
    
    private String transmissao;
    
    private String suspensao;
    
    
}
