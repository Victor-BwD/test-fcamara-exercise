package com.victorbwd.desafiofcamara.services;

import com.victorbwd.desafiofcamara.domain.establishment.Establishment;
import com.victorbwd.desafiofcamara.domain.establishment.EstablishmentDTO;
import com.victorbwd.desafiofcamara.domain.establishment.exceptions.EstablishmentNotFoundException;
import com.victorbwd.desafiofcamara.repositories.EstablishmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EstablishmentService {
    private EstablishmentRepository establishmentRepository;

    public EstablishmentService(EstablishmentRepository establishmentRepository) {
        this.establishmentRepository = establishmentRepository;
    }

    public Establishment insert(EstablishmentDTO establishmentData) {
        Establishment establishment = new Establishment(establishmentData);
        this.establishmentRepository.save(establishment);
        return establishment;
    }

    public List<Establishment> getAll() {
        return this.establishmentRepository.findAll();
    }

    public Establishment update(String id, EstablishmentDTO establishmentData) {
        Establishment establishment = this.establishmentRepository.findById(id).orElseThrow(EstablishmentNotFoundException::new);

        if (establishmentData.name() != null && !establishmentData.name().isEmpty()) {
            establishment.setName(establishmentData.name());
        }

        if (establishmentData.address() != null && !establishmentData.address().isEmpty()) {
            establishment.setAddress(establishmentData.address());
        }

        if (establishmentData.cnpj() != null && !establishmentData.cnpj().isEmpty()) {
            establishment.setCnpj(establishmentData.cnpj());
        }

        if (establishmentData.phone() != null && !establishmentData.phone().isEmpty()) {
            establishment.setPhone(establishmentData.phone());
        }

        if (establishmentData.bikes_capacity() != null && !establishmentData.bikes_capacity().isEmpty()) {
            establishment.setBikes_capacity(establishmentData.bikes_capacity());
        }

        if (establishmentData.cars_capacity() != null && !establishmentData.cars_capacity().isEmpty()) {
            establishment.setCars_capacity(establishmentData.cars_capacity());
        }

        this.establishmentRepository.save(establishment);

        return establishment;
    }

    public void delete(String id) {
        Establishment establishment = this.establishmentRepository.findById(id).orElseThrow(EstablishmentNotFoundException::new);
        this.establishmentRepository.delete(establishment);
    }
}
