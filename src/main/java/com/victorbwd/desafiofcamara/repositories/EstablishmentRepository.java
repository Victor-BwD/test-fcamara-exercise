package com.victorbwd.desafiofcamara.repositories;

import com.victorbwd.desafiofcamara.domain.establishment.Establishment;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstablishmentRepository extends MongoRepository<Establishment, String> {
}
