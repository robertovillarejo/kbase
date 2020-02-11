package com.github.danimaniarqsoft.service.dto;
import java.time.Instant;
import javax.validation.constraints.*;

import com.github.danimaniarqsoft.domain.EstadoNotificacion;

import java.io.Serializable;
import java.util.Objects;

/**
 * A DTO for the {@link com.github.danimaniarqsoft.domain.Notificacion} entity.
 */
public class NotificacionDTO implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = 1L;

    private String id;

    private String destinatarios;

    @Pattern(regexp = "^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$")
    private String remitente;

    private Instant fechaEnvio;

    private String asunto;

    private String mensaje;

    private String cc;

    private String cco;

    private String estado;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDestinatarios() {
        return destinatarios;
    }

    public void setDestinatarios(String destinatarios) {
        this.destinatarios = destinatarios;
    }

    public String getRemitente() {
        return remitente;
    }

    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    public Instant getFechaEnvio() {
        return fechaEnvio;
    }

    public void setFechaEnvio(Instant fechaEnvio) {
        this.fechaEnvio = fechaEnvio;
    }

    public String getAsunto() {
        return asunto;
    }

    public void setAsunto(String asunto) {
        this.asunto = asunto;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getCco() {
        return cco;
    }

    public void setCco(String cco) {
        this.cco = cco;
    }

    /**
     * @return the estadoNotificacion
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estadoNotificacion the estadoNotificacion to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        NotificacionDTO notificacionDTO = (NotificacionDTO) o;
        if (notificacionDTO.getId() == null || getId() == null) {
            return false;
        }
        return Objects.equals(getId(), notificacionDTO.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getId());
    }

    @Override
    public String toString() {
        // @formatter:off
        return "NotificacionDTO{" +
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
