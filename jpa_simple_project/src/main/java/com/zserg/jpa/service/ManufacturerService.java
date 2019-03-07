package com.zserg.jpa.service;

import com.zserg.jpa.model.Manufacturer;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Component
public class ManufacturerService {

    @PersistenceContext
    protected EntityManager em;

    @Transactional
    public Manufacturer createManufacturer(String name, String country) {
        Manufacturer manufacturer = new Manufacturer();
        manufacturer.setName(name);
        manufacturer.setCountry(country);

        em.persist(manufacturer);
        return manufacturer;
    }

    public List<Manufacturer> getManufacturersByCountry(String country) {
        String query = "SELECT m FROM manufacturer m where m.country = ?1";
        return em.createQuery(query).setParameter(1, country).getResultList();
        }
}



