package umariana.models.entity;

import javax.persistence.*;

@Entity
@Table(name = "empresas")
public class Empresa
{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true,nullable = false)
    private String nit;

    private String nombre;

    private String rutaRut;

    private String rutaRepresentante;

    private String rutaDocAcreditacion;

    private String sector;

    private long telefono;

    @Column(unique = true)
    private String correo;

    private String celular;

    public Empresa() {
    }

    public Empresa(Long id, String nit, String nombre, String rutaRut, String rutaRepresentante, String rutaDocAcreditacion, String sector, long telefono, String correo, String celular) {
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

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
}
