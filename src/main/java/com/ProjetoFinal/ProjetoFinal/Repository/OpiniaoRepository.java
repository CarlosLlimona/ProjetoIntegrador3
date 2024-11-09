
package com.ProjetoFinal.ProjetoFinal.Repository;

import com.ProjetoFinal.ProjetoFinal.Model.Opiniao;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OpiniaoRepository extends JpaRepository<Opiniao,Integer> {
    
    List<Opiniao> findByCarroID(Integer id);
    
}
