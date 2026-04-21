package com.programacion4.unidad4ej6.feature.insumo.models;

import java.util.List;
import java.util.ArrayList;
import java.util.Objects;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "insumos")
@Getter @Setter 
@NoArgsConstructor 
@AllArgsConstructor
@Builder
public class Insumo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, unique = true)
    private String codigoInterno;

    @Column(nullable = false)
    @Builder.Default
    private Long stockActual = 0L;

    @Column(nullable = false)
    @Builder.Default
    private Boolean activo = true;

    @OneToMany(mappedBy = "insumo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<HistorialPrecio> historialPrecios = new ArrayList<>();

    @OneToMany(mappedBy = "insumo", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Builder.Default
    private List<MovimientoStock> movimientosStock = new ArrayList<>();

    public void changeStatus() {
        this.activo = !this.activo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Insumo)) return false;
        Insumo insumo = (Insumo) o;
        return id != null && id.equals(insumo.id);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(id);
    }
}