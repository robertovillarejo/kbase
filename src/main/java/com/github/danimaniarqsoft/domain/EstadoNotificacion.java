package com.github.danimaniarqsoft.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * A EstadoNotificacion.
 */
public enum EstadoNotificacion {

    PENDIENTE, ENVIANDO, ENVIADA, FALLO;

    private static final Map<String, EstadoNotificacion> MAP;

    static {
        MAP = new HashMap<>();
        for (EstadoNotificacion tipo : values()) {
            MAP.put(tipo.toString(), tipo);
        }
    }

    public static EstadoNotificacion fromId(String id) {
        return MAP.get(id);
    }

}