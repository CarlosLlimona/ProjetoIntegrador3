
package com.ProjetoFinal.ProjetoFinal.Model;

import java.util.ArrayList;
import java.util.List;


public class Dados {
    
    /*Dados Marcas carros*/
    public static List<String> marcasCarro(){
        
        List<String> lista = new ArrayList<>();
        lista.add("Chevrolet");
        lista.add("Citroen");
        lista.add("Fiat");
        lista.add("Ford");
        lista.add("Jeep");
        lista.add("Volkswagen");
        lista.add("Outro");
        
        return lista;
    }
    
    /*Dados Marcas moto*/
    public static List<String> marcasMoto(){
        
        List<String> lista = new ArrayList<>();
        lista.add("Harley-Davidson");
        lista.add("Honda");
        lista.add("Suzuki");
        lista.add("Vespa");
        lista.add("Yamaha");
        lista.add("Outro");
        
        return lista;
        
    }
    /*Dados combustivel*/
    public static List<String> combustiveis(){
        
        List<String> lista= new ArrayList<>();
        lista.add("Gasolina");
        lista.add("Alcool");
        lista.add("Diesel");
        
        return lista;
    }
    
    /*Dados refrigeracao*/
    public static List<String> refrigeracao(){
        
        List<String> lista = new ArrayList<>();
        lista.add("Ar");
        lista.add("Agua");
        
        return lista;
        
    }
    
    
}
