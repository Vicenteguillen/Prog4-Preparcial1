package com.programacion4.unidad4ej6.feature.insumo.services.impl.domain;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import com.programacion4.unidad4ej6.config.exceptions.NotFoundException;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoResponseDTO;
import com.programacion4.unidad4ej6.feature.insumo.mappers.InsumoMapper;
import com.programacion4.unidad4ej6.feature.insumo.models.Insumo;
import com.programacion4.unidad4ej6.feature.insumo.repositories.IInsumoRepository;
import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoGetService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class InsumoGetService implements IInsumoGetService {

    private final IInsumoRepository insumoRepository;

    @Override
    public List<InsumoResponseDTO> getAllInsumos() {
        List<Insumo> insumos = insumoRepository.findAllActive(); 
        return insumos.stream()
                .map(InsumoMapper::toResponseDTO)
                .collect(Collectors.toList());
    }

    @Override
    public InsumoResponseDTO getInsumo(Long id) {
        return insumoRepository.findByIdAndActivoTrue(id)
                .map(InsumoMapper::toResponseDTO)
                .orElseThrow(() -> new NotFoundException("Insumo no encontrado o inactivo"));
    }
}