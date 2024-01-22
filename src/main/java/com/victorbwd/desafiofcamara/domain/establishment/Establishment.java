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
}
