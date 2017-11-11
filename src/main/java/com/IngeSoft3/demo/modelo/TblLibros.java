package com.IngeSoft3.demo.modelo;

import org.hibernate.validator.constraints.*;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

import javax.validation.constraints.*;


/**
* @author Zathura Code Generator http://zathuracode.org
* www.zathuracode.org
*
*/
@Entity
@Table(name = "tbl_libros", schema = "public")
public class TblLibros implements java.io.Serializable {
    @NotNull
    private Long idLibro;
    private String autor;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String descripcionLibro;
    @NotNull
    @NotEmpty
    @Size(max = 255)
    private String nombreLibro;
    private Set<TblDetallePrestamo> tblDetallePrestamos = new HashSet<TblDetallePrestamo>(0);

    public TblLibros() {
    }

    public TblLibros(Long idLibro, String autor, String descripcionLibro,
        String nombreLibro, Set<TblDetallePrestamo> tblDetallePrestamos) {
        this.idLibro = idLibro;
        this.autor = autor;
        this.descripcionLibro = descripcionLibro;
        this.nombreLibro = nombreLibro;
        this.tblDetallePrestamos = tblDetallePrestamos;
    }

    @Id
    @Column(name = "id_libro", unique = true, nullable = false)
    public Long getIdLibro() {
        return this.idLibro;
    }

    public void setIdLibro(Long idLibro) {
        this.idLibro = idLibro;
    }

    @Column(name = "autor")
    public String getAutor() {
        return this.autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    @Column(name = "descripcion_libro", nullable = false)
    public String getDescripcionLibro() {
        return this.descripcionLibro;
    }

    public void setDescripcionLibro(String descripcionLibro) {
        this.descripcionLibro = descripcionLibro;
    }

    @Column(name = "nombre_libro", nullable = false)
    public String getNombreLibro() {
        return this.nombreLibro;
    }

    public void setNombreLibro(String nombreLibro) {
        this.nombreLibro = nombreLibro;
    }

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tblLibros")
    public Set<TblDetallePrestamo> getTblDetallePrestamos() {
        return this.tblDetallePrestamos;
    }

    public void setTblDetallePrestamos(
        Set<TblDetallePrestamo> tblDetallePrestamos) {
        this.tblDetallePrestamos = tblDetallePrestamos;
    }
}
