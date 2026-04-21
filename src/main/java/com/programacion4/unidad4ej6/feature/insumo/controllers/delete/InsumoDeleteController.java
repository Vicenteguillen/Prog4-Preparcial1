package com.programacion4.unidad4ej6.feature.insumo.controllers.delete; 

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.programacion4.unidad4ej6.config.BaseResponse;
import com.programacion4.unidad4ej6.feature.insumo.services.interfaces.domain.IInsumoDeleteService;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/insumos")
@RequiredArgsConstructor
public class InsumoDeleteController {
    private final IInsumoDeleteService insumoDeleteService;

    @DeleteMapping("/{id}")
    public ResponseEntity<BaseResponse<Void>> deleteInsumo(@PathVariable Long id) {
        insumoDeleteService.deleteInsumo(id);
        return ResponseEntity.status(HttpStatus.OK)
                .body(BaseResponse.ok(null, "Insumo eliminado correctamente"));
    }
}