package pe.edu.vallegrande.ms_productos.domain.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data                 
@AllArgsConstructor
@NoArgsConstructor
@Table("productos")
public class Producto {

    @Id
    private Long id;
    private String name;
    private Double price;
    private Integer stock;
    private Boolean active;
}