package com.zserg.jpa.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue
    private Integer id;

    private String name;

    private String country;

}
