package com.github.danimaniarqsoft.service.impl;

import com.github.danimaniarqsoft.service.MensajeErrorService;
import com.github.danimaniarqsoft.domain.MensajeError;
import com.github.danimaniarqsoft.repository.MensajeErrorRepository;
import com.github.danimaniarqsoft.service.dto.MensajeErrorDTO;
import com.github.danimaniarqsoft.service.mapper.MensajeErrorMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * Service Implementation for managing {@link MensajeError}.
 */
@Service
public class MensajeErrorServiceImpl implements MensajeErrorService {

    private final Logger log = LoggerFactory.getLogger(MensajeErrorServiceImpl.class);

    private final MensajeErrorRepository mensajeErrorRepository;

    private final MensajeErrorMapper mensajeErrorMapper;

    public MensajeErrorServiceImpl(MensajeErrorRepository mensajeErrorRepository, MensajeErrorMapper mensajeErrorMapper) {
        this.mensajeErrorRepository = mensajeErrorRepository;
        this.mensajeErrorMapper = mensajeErrorMapper;
    }

    /**
     * Save a mensajeError.
     *
     * @param mensajeErrorDTO the entity to save.
     * @return the persisted entity.
     */
    @Override
    public MensajeErrorDTO save(MensajeErrorDTO mensajeErrorDTO) {
        log.debug("Request to save MensajeError : {}", mensajeErrorDTO);
        MensajeError mensajeError = mensajeErrorMapper.toEntity(mensajeErrorDTO);
        mensajeError = mensajeErrorRepository.save(mensajeError);
        return mensajeErrorMapper.toDto(mensajeError);
    }

    /**
     * Get all the mensajeErrors.
     *
     * @param pageable the pagination information.
     * @return the list of entities.
     */
    @Override
    public Page<MensajeErrorDTO> findAll(Pageable pageable) {
        log.debug("Request to get all MensajeErrors");
        return mensajeErrorRepository.findAll(pageable)
            .map(mensajeErrorMapper::toDto);
    }


    /**
     * Get one mensajeError by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Override
    public Optional<MensajeErrorDTO> findOne(String id) {
        log.debug("Request to get MensajeError : {}", id);
        return mensajeErrorRepository.findById(id)
            .map(mensajeErrorMapper::toDto);
    }

    /**
     * Delete the mensajeError by id.
     *
     * @param id the id of the entity.
     */
    @Override
    public void delete(String id) {
        log.debug("Request to delete MensajeError : {}", id);
        mensajeErrorRepository.deleteById(id);
    }
}
