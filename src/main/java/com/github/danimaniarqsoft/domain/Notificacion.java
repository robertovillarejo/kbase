package com.github.danimaniarqsoft.domain;

import java.io.Serializable;
import java.time.Instant;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * A Notificacion.
 */
@Document(collection = "notificacion")
public class Notificacion implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    private String id;

    @Field("destinatarios")
    private String destinatarios;

    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    @Field("remitente")
    private String remitente;

    @Field("fecha_envio")
    private Instant fechaEnvio;

    @Field("asunto")
    private String asunto;

    @Field("mensaje")
    private String mensaje;

    @Field("cc")
    private String cc;

    @Field("cco")
    private String cco;

    @NotNull
    @Field("estado")
    private String estado = EstadoNotificacion.PENDIENTE.toString();

    // jhipster-needle-entity-add-field - JHipster will add fields here, do not
    // remove
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestinatarios() {
        return destinatarios;
    }

    public Notificacion destinatarios(String destinatarios) {
        this.destinatarios = destinatarios;
        return this;
    }

    public void setDestinatarios(String destinatarios) {
        this.destinatarios = destinatarios;
    }

    public String getRemitente() {
        return remitente;
    }

    public Notificacion remitente(String remitente) {
        this.remitente = remitente;
        return this;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public Instant getFechaEnvio() {
        return fechaEnvio;
    }

    public Notificacion fechaEnvio(Instant fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
        return this;
    }

    public void setFechaEnvio(Instant fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getAsunto() {
        return asunto;
    }

    public Notificacion asunto(String asunto) {
        this.asunto = asunto;
        return this;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public Notificacion mensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCc() {
        return cc;
    }

    public Notificacion cc(String cc) {
        this.cc = cc;
        return this;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCco() {
        return cco;
    }

    public Notificacion cco(String cco) {
        this.cco = cco;
        return this;
    }

    public void setCco(String cco) {
        this.cco = cco;
    }

    /**
     * @return the estado
     */
    public EstadoNotificacion getEstado() {
        return EstadoNotificacion.fromId(estado);
    }

    public Notificacion estado(EstadoNotificacion estado) {
        this.estado = estado.toString();
        return this;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(EstadoNotificacion estado) {
        this.estado = estado.toString();
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and
    // setters here, do not remove

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Notificacion)) {
            return false;
        }
        return id != null && id.equals(((Notificacion) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    @Override
    public String toString() {
        // @formatter:off
        return "Notificacion{" + 
            "id=" + getId() + 
            ", destinatarios='" + getDestinatarios() + "'" + 
            ", remitente='" + getRemitente() + "'" + 
            ", fechaEnvio='" + getFechaEnvio() + "'" + 
            ", asunto='" + getAsunto() + "'" + 
            ", mensaje='" + getMensaje() + "'" + 
            ", cc='" + getCc() + "'" + 
            ", cco='" + getCco() + "'" + 
            ", estado='" + getEstado() + "'" + 
            "}";
        // @formatter:on
    }
}
