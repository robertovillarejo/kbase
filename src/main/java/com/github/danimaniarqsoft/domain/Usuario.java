package com.github.danimaniarqsoft.domain;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.*;

import java.io.Serializable;

/**
 * A Usuario.
 */
@Document(collection = "usuario")
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("nombre")
    private String nombre;

    @Field("primer_apellido")
    private String primerApellido;

    @Field("segundo_apellido")
    private String segundoApellido;

    @Field("rfc")
    private String rfc;

    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @Field("correo")
    private String correo;

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Usuario nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public Usuario primerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
        return this;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public Usuario segundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
        return this;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getRfc() {
        return rfc;
    }

    public Usuario rfc(String rfc) {
        this.rfc = rfc;
        return this;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getCorreo() {
        return correo;
    }

    public Usuario correo(String correo) {
        this.correo = correo;
        return this;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Usuario)) {
            return false;
        }
        return id != null && id.equals(((Usuario) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        return "Usuario{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", primerApellido='" + getPrimerApellido() + "'" +
            ", segundoApellido='" + getSegundoApellido() + "'" +
            ", rfc='" + getRfc() + "'" +
            ", correo='" + getCorreo() + "'" +
            "}";
    }
}
