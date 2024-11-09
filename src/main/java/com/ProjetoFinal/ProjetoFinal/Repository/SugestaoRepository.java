
package com.ProjetoFinal.ProjetoFinal.Repository;

import com.ProjetoFinal.ProjetoFinal.Model.Sugestao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SugestaoRepository extends JpaRepository<Sugestao, Integer> {
    
}
