package com.github.danimaniarqsoft.service.impl;

import com.github.danimaniarqsoft.service.NotificacionService;
import com.github.danimaniarqsoft.domain.Notificacion;
import com.github.danimaniarqsoft.repository.NotificacionRepository;
import com.github.danimaniarqsoft.service.dto.NotificacionDTO;
import com.github.danimaniarqsoft.service.mapper.NotificacionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link Notificacion}.
 */
@Service
public class NotificacionServiceImpl implements NotificacionService {

    private final Logger log = LoggerFactory.getLogger(NotificacionServiceImpl.class);

    private final NotificacionRepository notificacionRepository;

    private final NotificacionMapper notificacionMapper;

    public NotificacionServiceImpl(NotificacionRepository notificacionRepository, NotificacionMapper notificacionMapper) {
        this.notificacionRepository = notificacionRepository;
        this.notificacionMapper = notificacionMapper;
    }

    /**
     * Save a notificacion.
     *
     * @param notificacionDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public NotificacionDTO save(NotificacionDTO notificacionDTO) {
        log.debug("Request to save Notificacion : {}", notificacionDTO);
        Notificacion notificacion = notificacionMapper.toEntity(notificacionDTO);
        notificacion = notificacionRepository.save(notificacion);
        return notificacionMapper.toDto(notificacion);
    }

    /**
     * Get all the notificacions.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    public Page<NotificacionDTO> findAll(Pageable pageable) {
        log.debug("Request to get all Notificacions");
        return notificacionRepository.findAll(pageable)
            .map(notificacionMapper::toDto);
    }


    /**
     * Get one notificacion by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<NotificacionDTO> findOne(String id) {
        log.debug("Request to get Notificacion : {}", id);
        return notificacionRepository.findById(id)
            .map(notificacionMapper::toDto);
    }

    /**
     * Delete the notificacion by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete Notificacion : {}", id);
        notificacionRepository.deleteById(id);
    }
}
