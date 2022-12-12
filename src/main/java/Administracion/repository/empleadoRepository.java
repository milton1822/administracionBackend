package Administracion.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import Administracion.model.Empleado;

@Repository
public interface empleadoRepository extends MongoRepository<Empleado, String>{

}
