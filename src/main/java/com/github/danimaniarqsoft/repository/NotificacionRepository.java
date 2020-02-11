package com.github.danimaniarqsoft.repository;
import com.github.danimaniarqsoft.domain.Notificacion;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the Notificacion entity.
 */
@SuppressWarnings("unused")
@Repository
public interface NotificacionRepository extends MongoRepository<Notificacion, String> {

}
