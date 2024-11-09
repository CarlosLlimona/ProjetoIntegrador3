
package com.ProjetoFinal.ProjetoFinal.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name="opiniaoCarro")
public class Opiniao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    
    private Integer carroID; /*<--------*/
    
    private String avaliacao;
    
    private String nome;
    
}
