
package com.ProjetoFinal.ProjetoFinal.Model;

import lombok.Data;

@Data
public class OpiniaoMoto {
    
    private Integer id;
    
    private Integer motoID; /*<--------*/
    
    private String avaliacao;
    
    private String nome;
    
}
