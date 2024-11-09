
package com.ProjetoFinal.ProjetoFinal.Repository;

import com.ProjetoFinal.ProjetoFinal.Model.OpiniaoMoto;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface OpiniaoMotoRepository extends JpaRepository<OpiniaoMoto,Integer> {
    
    List<OpiniaoMoto> findByMotoID(Integer id);
    
}
