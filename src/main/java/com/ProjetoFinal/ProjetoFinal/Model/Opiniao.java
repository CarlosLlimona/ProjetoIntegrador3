
package com.ProjetoFinal.ProjetoFinal.Model;

import lombok.Data;


@Data
public class Opiniao {
    
    private Integer id;
    
    private Integer carroID; /*<--------*/
    
    private String avaliacao;
    
    private String nome;
    
}
