package com.victorbwd.desafiofcamara.domain.establishment;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "establishment")
@Getter
@Setter
@NoArgsConstructor
public class Establishment {
    @Id
    private String id;
    private String name;
    private String cnpj;
    private String address;
    private String phone;
    private String bikes_capacity;
    private String cars_capacity;

    public Establishment(EstablishmentDTO establishmentDTO) {
        this.name = establishmentDTO.name();
        this.cnpj = establishmentDTO.cnpj();
        this.address = establishmentDTO.address();
        this.phone = establishmentDTO.phone();
        this.bikes_capacity = establishmentDTO.bikes_capacity();
        this.cars_capacity = establishmentDTO.cars_capacity();
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setBikes_capacity(String bikes_capacity) {
        this.bikes_capacity = bikes_capacity;
    }

    public void setCars_capacity(String cars_capacity) {
        this.cars_capacity = cars_capacity;
    }
}
