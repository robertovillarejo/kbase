package com.github.danimaniarqsoft.web.rest;

import com.github.danimaniarqsoft.KbaseApp;
import com.github.danimaniarqsoft.domain.EstadoNotificacion;
import com.github.danimaniarqsoft.domain.Notificacion;
import com.github.danimaniarqsoft.repository.NotificacionRepository;
import com.github.danimaniarqsoft.service.NotificacionService;
import com.github.danimaniarqsoft.service.dto.NotificacionDTO;
import com.github.danimaniarqsoft.service.mapper.NotificacionMapper;
import com.github.danimaniarqsoft.web.rest.errors.ExceptionTranslator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.web.PageableHandlerMethodArgumentResolver;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.validation.Validator;


import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.List;

import static com.github.danimaniarqsoft.web.rest.TestUtil.createFormattingConversionService;
import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.hasItem;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Integration tests for the {@link NotificacionResource} REST controller.
 */
@SpringBootTest(classes = KbaseApp.class)
public class NotificacionResourceIT {

    private static final String DEFAULT_DESTINATARIOS = "AAAAAAAAAA";
    private static final String UPDATED_DESTINATARIOS = "BBBBBBBBBB";

    private static final String DEFAULT_REMITENTE = "Y.@3";
    private static final String UPDATED_REMITENTE = "n@Q";

    private static final Instant DEFAULT_FECHA_ENVIO = Instant.ofEpochMilli(0L);
    private static final Instant UPDATED_FECHA_ENVIO = Instant.now().truncatedTo(ChronoUnit.MILLIS);

    private static final String DEFAULT_ASUNTO = "AAAAAAAAAA";
    private static final String UPDATED_ASUNTO = "BBBBBBBBBB";

    private static final String DEFAULT_MENSAJE = "AAAAAAAAAA";
    private static final String UPDATED_MENSAJE = "BBBBBBBBBB";

    private static final String DEFAULT_CC = "AAAAAAAAAA";
    private static final String UPDATED_CC = "BBBBBBBBBB";

    private static final String DEFAULT_CCO = "AAAAAAAAAA";
    private static final String UPDATED_CCO = "BBBBBBBBBB";

    private static final EstadoNotificacion DEFAULT_ESTADO = EstadoNotificacion.PENDIENTE;
    private static final EstadoNotificacion UPDATED_ESTADO = EstadoNotificacion.ENVIADA;

    @Autowired
    private NotificacionRepository notificacionRepository;

    @Autowired
    private NotificacionMapper notificacionMapper;

    @Autowired
    private NotificacionService notificacionService;

    @Autowired
    private MappingJackson2HttpMessageConverter jacksonMessageConverter;

    @Autowired
    private PageableHandlerMethodArgumentResolver pageableArgumentResolver;

    @Autowired
    private ExceptionTranslator exceptionTranslator;

    @Autowired
    private Validator validator;

    private MockMvc restNotificacionMockMvc;

    private Notificacion notificacion;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
        final NotificacionResource notificacionResource = new NotificacionResource(notificacionService);
        this.restNotificacionMockMvc = MockMvcBuilders.standaloneSetup(notificacionResource)
            .setCustomArgumentResolvers(pageableArgumentResolver)
            .setControllerAdvice(exceptionTranslator)
            .setConversionService(createFormattingConversionService())
            .setMessageConverters(jacksonMessageConverter)
            .setValidator(validator).build();
    }

    /**
     * Create an entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Notificacion createEntity() {
        Notificacion notificacion = new Notificacion()
            .destinatarios(DEFAULT_DESTINATARIOS)
            .remitente(DEFAULT_REMITENTE)
            .fechaEnvio(DEFAULT_FECHA_ENVIO)
            .asunto(DEFAULT_ASUNTO)
            .mensaje(DEFAULT_MENSAJE)
            .cc(DEFAULT_CC)
            .cco(DEFAULT_CCO)
            .estado(DEFAULT_ESTADO);
        return notificacion;
    }
    /**
     * Create an updated entity for this test.
     *
     * This is a static method, as tests for other entities might also need it,
     * if they test an entity which requires the current entity.
     */
    public static Notificacion createUpdatedEntity() {
        Notificacion notificacion = new Notificacion()
            .destinatarios(UPDATED_DESTINATARIOS)
            .remitente(UPDATED_REMITENTE)
            .fechaEnvio(UPDATED_FECHA_ENVIO)
            .asunto(UPDATED_ASUNTO)
            .mensaje(UPDATED_MENSAJE)
            .cc(UPDATED_CC)
            .cco(UPDATED_CCO)
            .estado(UPDATED_ESTADO);
        return notificacion;
    }

    @BeforeEach
    public void initTest() {
        notificacionRepository.deleteAll();
        notificacion = createEntity();
    }

    @Test
    public void createNotificacion() throws Exception {
        int databaseSizeBeforeCreate = notificacionRepository.findAll().size();

        // Create the Notificacion
        NotificacionDTO notificacionDTO = notificacionMapper.toDto(notificacion);
        restNotificacionMockMvc.perform(post("/api/notificacions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(notificacionDTO)))
            .andExpect(status().isCreated());

        // Validate the Notificacion in the database
        List<Notificacion> notificacionList = notificacionRepository.findAll();
        assertThat(notificacionList).hasSize(databaseSizeBeforeCreate + 1);
        Notificacion testNotificacion = notificacionList.get(notificacionList.size() - 1);
        assertThat(testNotificacion.getDestinatarios()).isEqualTo(DEFAULT_DESTINATARIOS);
        assertThat(testNotificacion.getRemitente()).isEqualTo(DEFAULT_REMITENTE);
        assertThat(testNotificacion.getFechaEnvio()).isEqualTo(DEFAULT_FECHA_ENVIO);
        assertThat(testNotificacion.getAsunto()).isEqualTo(DEFAULT_ASUNTO);
        assertThat(testNotificacion.getMensaje()).isEqualTo(DEFAULT_MENSAJE);
        assertThat(testNotificacion.getCc()).isEqualTo(DEFAULT_CC);
        assertThat(testNotificacion.getCco()).isEqualTo(DEFAULT_CCO);
    }

    @Test
    public void createNotificacionWithExistingId() throws Exception {
        int databaseSizeBeforeCreate = notificacionRepository.findAll().size();

        // Create the Notificacion with an existing ID
        notificacion.setId("existing_id");
        NotificacionDTO notificacionDTO = notificacionMapper.toDto(notificacion);

        // An entity with an existing ID cannot be created, so this API call must fail
        restNotificacionMockMvc.perform(post("/api/notificacions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(notificacionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Notificacion in the database
        List<Notificacion> notificacionList = notificacionRepository.findAll();
        assertThat(notificacionList).hasSize(databaseSizeBeforeCreate);
    }


    @Test
    public void getAllNotificacions() throws Exception {
        // Initialize the database
        notificacionRepository.save(notificacion);

        // Get all the notificacionList
        restNotificacionMockMvc.perform(get("/api/notificacions?sort=id,desc"))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.[*].id").value(hasItem(notificacion.getId())))
            .andExpect(jsonPath("$.[*].destinatarios").value(hasItem(DEFAULT_DESTINATARIOS)))
            .andExpect(jsonPath("$.[*].remitente").value(hasItem(DEFAULT_REMITENTE)))
            .andExpect(jsonPath("$.[*].fechaEnvio").value(hasItem(DEFAULT_FECHA_ENVIO.toString())))
            .andExpect(jsonPath("$.[*].asunto").value(hasItem(DEFAULT_ASUNTO)))
            .andExpect(jsonPath("$.[*].mensaje").value(hasItem(DEFAULT_MENSAJE)))
            .andExpect(jsonPath("$.[*].cc").value(hasItem(DEFAULT_CC)))
            .andExpect(jsonPath("$.[*].cco").value(hasItem(DEFAULT_CCO)));
    }
    
    @Test
    public void getNotificacion() throws Exception {
        // Initialize the database
        notificacionRepository.save(notificacion);

        // Get the notificacion
        restNotificacionMockMvc.perform(get("/api/notificacions/{id}", notificacion.getId()))
            .andExpect(status().isOk())
            .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8_VALUE))
            .andExpect(jsonPath("$.id").value(notificacion.getId()))
            .andExpect(jsonPath("$.destinatarios").value(DEFAULT_DESTINATARIOS))
            .andExpect(jsonPath("$.remitente").value(DEFAULT_REMITENTE))
            .andExpect(jsonPath("$.fechaEnvio").value(DEFAULT_FECHA_ENVIO.toString()))
            .andExpect(jsonPath("$.asunto").value(DEFAULT_ASUNTO))
            .andExpect(jsonPath("$.mensaje").value(DEFAULT_MENSAJE))
            .andExpect(jsonPath("$.cc").value(DEFAULT_CC))
            .andExpect(jsonPath("$.cco").value(DEFAULT_CCO));
    }

    @Test
    public void getNonExistingNotificacion() throws Exception {
        // Get the notificacion
        restNotificacionMockMvc.perform(get("/api/notificacions/{id}", Long.MAX_VALUE))
            .andExpect(status().isNotFound());
    }

    @Test
    public void updateNotificacion() throws Exception {
        // Initialize the database
        notificacionRepository.save(notificacion);

        int databaseSizeBeforeUpdate = notificacionRepository.findAll().size();

        // Update the notificacion
        Notificacion updatedNotificacion = notificacionRepository.findById(notificacion.getId()).get();
        updatedNotificacion
            .destinatarios(UPDATED_DESTINATARIOS)
            .remitente(UPDATED_REMITENTE)
            .fechaEnvio(UPDATED_FECHA_ENVIO)
            .asunto(UPDATED_ASUNTO)
            .mensaje(UPDATED_MENSAJE)
            .cc(UPDATED_CC)
            .cco(UPDATED_CCO)
            .estado(UPDATED_ESTADO);
        NotificacionDTO notificacionDTO = notificacionMapper.toDto(updatedNotificacion);

        restNotificacionMockMvc.perform(put("/api/notificacions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(notificacionDTO)))
            .andExpect(status().isOk());

        // Validate the Notificacion in the database
        List<Notificacion> notificacionList = notificacionRepository.findAll();
        assertThat(notificacionList).hasSize(databaseSizeBeforeUpdate);
        Notificacion testNotificacion = notificacionList.get(notificacionList.size() - 1);
        assertThat(testNotificacion.getDestinatarios()).isEqualTo(UPDATED_DESTINATARIOS);
        assertThat(testNotificacion.getRemitente()).isEqualTo(UPDATED_REMITENTE);
        assertThat(testNotificacion.getFechaEnvio()).isEqualTo(UPDATED_FECHA_ENVIO);
        assertThat(testNotificacion.getAsunto()).isEqualTo(UPDATED_ASUNTO);
        assertThat(testNotificacion.getMensaje()).isEqualTo(UPDATED_MENSAJE);
        assertThat(testNotificacion.getCc()).isEqualTo(UPDATED_CC);
        assertThat(testNotificacion.getCco()).isEqualTo(UPDATED_CCO);
        assertThat(testNotificacion.getEstado()).isEqualTo(UPDATED_ESTADO);
    }

    @Test
    public void updateNonExistingNotificacion() throws Exception {
        int databaseSizeBeforeUpdate = notificacionRepository.findAll().size();

        // Create the Notificacion
        NotificacionDTO notificacionDTO = notificacionMapper.toDto(notificacion);

        // If the entity doesn't have an ID, it will throw BadRequestAlertException
        restNotificacionMockMvc.perform(put("/api/notificacions")
            .contentType(TestUtil.APPLICATION_JSON_UTF8)
            .content(TestUtil.convertObjectToJsonBytes(notificacionDTO)))
            .andExpect(status().isBadRequest());

        // Validate the Notificacion in the database
        List<Notificacion> notificacionList = notificacionRepository.findAll();
        assertThat(notificacionList).hasSize(databaseSizeBeforeUpdate);
    }

    @Test
    public void deleteNotificacion() throws Exception {
        // Initialize the database
        notificacionRepository.save(notificacion);

        int databaseSizeBeforeDelete = notificacionRepository.findAll().size();

        // Delete the notificacion
        restNotificacionMockMvc.perform(delete("/api/notificacions/{id}", notificacion.getId())
            .accept(TestUtil.APPLICATION_JSON_UTF8))
            .andExpect(status().isNoContent());

        // Validate the database contains one less item
        List<Notificacion> notificacionList = notificacionRepository.findAll();
        assertThat(notificacionList).hasSize(databaseSizeBeforeDelete - 1);
    }

    @Test
    public void equalsVerifier() throws Exception {
        TestUtil.equalsVerifier(Notificacion.class);
        Notificacion notificacion1 = new Notificacion();
        notificacion1.setId("id1");
        Notificacion notificacion2 = new Notificacion();
        notificacion2.setId(notificacion1.getId());
        assertThat(notificacion1).isEqualTo(notificacion2);
        notificacion2.setId("id2");
        assertThat(notificacion1).isNotEqualTo(notificacion2);
        notificacion1.setId(null);
        assertThat(notificacion1).isNotEqualTo(notificacion2);
    }

    @Test
    public void dtoEqualsVerifier() throws Exception {
        TestUtil.equalsVerifier(NotificacionDTO.class);
        NotificacionDTO notificacionDTO1 = new NotificacionDTO();
        notificacionDTO1.setId("id1");
        NotificacionDTO notificacionDTO2 = new NotificacionDTO();
        assertThat(notificacionDTO1).isNotEqualTo(notificacionDTO2);
        notificacionDTO2.setId(notificacionDTO1.getId());
        assertThat(notificacionDTO1).isEqualTo(notificacionDTO2);
        notificacionDTO2.setId("id2");
        assertThat(notificacionDTO1).isNotEqualTo(notificacionDTO2);
        notificacionDTO1.setId(null);
        assertThat(notificacionDTO1).isNotEqualTo(notificacionDTO2);
    }
}
