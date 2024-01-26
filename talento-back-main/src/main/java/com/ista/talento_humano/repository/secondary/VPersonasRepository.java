package com.ista.talento_humano.repository.secondary;

import com.ista.talento_humano.model.secondary.vpersonas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface VPersonasRepository extends JpaRepository<vpersonas, String> {

    @Query("SELECT p FROM vpersonas AS p WHERE p.cedula = :cedula")
    List<vpersonas> findByCedulaFenix(@Param("cedula") String cedula);

}