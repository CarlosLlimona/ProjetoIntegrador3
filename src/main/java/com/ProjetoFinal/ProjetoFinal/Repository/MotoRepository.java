
package com.ProjetoFinal.ProjetoFinal.Repository;

import com.ProjetoFinal.ProjetoFinal.Model.Moto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotoRepository extends JpaRepository<Moto,Integer> {
    
}
