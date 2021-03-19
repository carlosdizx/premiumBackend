package umariana.models.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "empresas")
public class Empresa
{
    private final static long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    @Size(min = 4,max = 30, message = "debe contener minimo 4 letras y maximo 30")
    private String nit;

    @Column(nullable = false)
    @NotEmpty
    @Size(min = 2,max = 60)
    private String nombre;

    @NotEmpty
    private String rutaRut;

    @NotEmpty
    private String rutaRepresentante;

    @NotEmpty
    private String rutaDocAcreditacion;

    @NotEmpty
    private String sector;

    private long telefono;

    @Email(message = "debe contener un formato correcto de correo electronico")
    @NotEmpty(message = "no puede estar vacio")
    @Column(nullable = false,unique = true)
    @Size(max = 250)
    private String correo;

    private long celular;

    public Empresa() {
    }

    public Empresa(Long id, String nit, String nombre, String rutaRut, String rutaRepresentante, String rutaDocAcreditacion, String sector, long telefono, String correo, long celular) {
        this.id = id;
        this.nit = nit;
        this.nombre = nombre;
        this.rutaRut = rutaRut;
        this.rutaRepresentante = rutaRepresentante;
        this.rutaDocAcreditacion = rutaDocAcreditacion;
        this.sector = sector;
        this.telefono = telefono;
        this.correo = correo;
        this.celular = celular;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNit() {
        return nit;
    }

    public void setNit(String nit) {
        this.nit = nit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getRutaRut() {
        return rutaRut;
    }

    public void setRutaRut(String rutaRut) {
        this.rutaRut = rutaRut;
    }

    public String getRutaRepresentante() {
        return rutaRepresentante;
    }

    public void setRutaRepresentante(String rutaRepresentante) {
        this.rutaRepresentante = rutaRepresentante;
    }

    public String getRutaDocAcreditacion() {
        return rutaDocAcreditacion;
    }

    public void setRutaDocAcreditacion(String rutaDocAcreditacion) {
        this.rutaDocAcreditacion = rutaDocAcreditacion;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public long getTelefono() {
        return telefono;
    }

    public void setTelefono(long telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }
}
