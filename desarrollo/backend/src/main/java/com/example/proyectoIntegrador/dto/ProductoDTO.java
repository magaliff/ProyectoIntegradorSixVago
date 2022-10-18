package com.example.proyectoIntegrador.dto;

import com.example.proyectoIntegrador.entity.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonIncludeProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.OneToMany;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@JsonIgnoreProperties(ignoreUnknown = true)
public class ProductoDTO {
    private Long productos_id;
    private String nombre;
    private String descripcion;
    private String direccion;
    private Integer habitaciones;
    private Double longitud;
    private Double latitud;
    private List<Politica> politicas;

    private Categoria categorias_id;
    private Ciudad ciudades_id;

    private List<Caracteristicas> caracteristicas;
    private List<ImagenDTO> listadeimagenes;

    @JsonIgnoreProperties(value = { "datosParaVendedor","productosProductos","usuarios","vacunaCovid"})
    private List<ReservaDTO> reservas;
}
