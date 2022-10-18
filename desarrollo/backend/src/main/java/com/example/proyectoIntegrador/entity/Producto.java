package com.example.proyectoIntegrador.entity;

import com.fasterxml.jackson.annotation.*;
import lombok.*;

import javax.persistence.*;
import java.util.*;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "productos")
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class,property="@id", scope = Producto.class)
public class Producto{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "productos_id")
    private Long productos_id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "habitaciones")
    private Integer habitaciones;

    @Column(name = "longitud")
    private Double longitud;

    @Column(name = "latitud")
    private Double latitud;


    @ManyToOne
    @JoinColumn(name = "categorias_id",referencedColumnName = "id")
    private Categoria categorias_id; //NO TOCAR

    @ManyToOne
    @JoinColumn(name = "ciudades_id", referencedColumnName = "ciudades_id")
    private Ciudad ciudades_id; //NO TOCAR

    @ManyToMany
    @JoinTable(name ="productos_caracteristicas", joinColumns = @JoinColumn(name = "productos_id"),
            inverseJoinColumns = @JoinColumn(name ="caracteristicas_id"))
    private List<Caracteristicas> caracteristicas;

    @ManyToMany
    @JoinTable(name = "productos_politicas", joinColumns = @JoinColumn(name = "productos_id"),
                inverseJoinColumns = @JoinColumn(name="politicas_id"))
    private List<Politica> politicas;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "productos_id")
    private List<Imagen> listadeimagenes;


    @OneToMany(mappedBy = "productosProductos",cascade = CascadeType.ALL)
    private List<Reserva> reservas;

}
