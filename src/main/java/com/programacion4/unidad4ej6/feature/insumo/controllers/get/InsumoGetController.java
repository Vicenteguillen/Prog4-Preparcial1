package com.programacion4.unidad4ej6.feature.insumo.controllers.get;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.programacion4.unidad4ej6.config.BaseResponse;
import com.programacion4.unidad4ej6.feature.insumo.dtos.response.InsumoResponseDTO;
import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoGetService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/insumos")
@RequiredArgsConstructor
public class InsumoGetController {
    private final IInsumoGetService insumoGetService;

    @GetMapping
    public ResponseEntity<BaseResponse<List<InsumoResponseDTO>>> getAllInsumos() {
        return ResponseEntity.ok(BaseResponse.ok(insumoGetService.getAllInsumos(), "Insumos listados correctamente"));
    }
}