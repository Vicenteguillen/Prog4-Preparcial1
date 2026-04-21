package com.programacion4.unidad4ej6.feature.insumo.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;
import java.util.List;
import java.util.Optional;

@Repository
public interface IInsumoRepository extends CrudRepository<Insumo, Long> {

    boolean existsByCodigoInterno(String codigoInterno);

    Optional<Insumo> findByIdAndActivoTrue(Long id);

    Optional<Insumo> findByIdAndActivoFalse(Long id);

    @Query("SELECT i FROM Insumo i WHERE i.activo = true")
    List<Insumo> findAllActive();
}