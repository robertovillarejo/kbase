package com.github.danimaniarqsoft.repository;
import com.github.danimaniarqsoft.domain.Usuario;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


/**
 * Spring Data MongoDB repository for the Usuario entity.
 */
@SuppressWarnings("unused")
@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {

}
