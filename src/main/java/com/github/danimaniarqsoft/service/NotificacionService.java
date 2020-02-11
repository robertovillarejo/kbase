package com.github.danimaniarqsoft.service;

import com.github.danimaniarqsoft.service.dto.NotificacionDTO;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

/**
 * Service Interface for managing {@link com.github.danimaniarqsoft.domain.Notificacion}.
 */
public interface NotificacionService {

    /**
     * Save a notificacion.
     *
     * @param notificacionDTO the entity to save.
     * @return the persisted entity.
     */
    NotificacionDTO save(NotificacionDTO notificacionDTO);

    /**
     * Get all the notificacions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    Page<NotificacionDTO> findAll(Pageable pageable);


    /**
     * Get the "id" notificacion.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    Optional<NotificacionDTO> findOne(String id);

    /**
     * Delete the "id" notificacion.
     *
     * @param id the id of the entity.
     */
    void delete(String id);
}
