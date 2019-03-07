package com.zserg.jpa.service;

import com.sun.xml.bind.v2.ContextFactory;
import com.zserg.jpa.model.Manufacturer;
import com.zserg.jpa.spring.DbConfigBean;
import com.zserg.jpa.spring.EntityManagerFactoriesConfiguration;
import com.zserg.jpa.spring.TransactionManagersConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.support.AnnotationConfigContextLoader;
import lombok.extern.slf4j.Slf4j;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(SpringExtension.class)
@ContextConfiguration(loader = AnnotationConfigContextLoader.class,
        classes = {EntityManagerFactoriesConfiguration.class,
                   DbConfigBean.class,
                   TransactionManagersConfig.class,
                   ManufacturerServiceTest.MyConfig.class})
@Slf4j
class ManufacturerServiceTest {

    @Configuration
    static public class MyConfig {

        @Bean
        public ManufacturerService manufacturerService() {
            return new ManufacturerService();

        }

        @Bean
        public static PropertySourcesPlaceholderConfigurer propertyConfigInDev() {
            return new PropertySourcesPlaceholderConfigurer();
        }
    }


    @Autowired
    protected BeanFactory beanFactory;

    @Test
    void createManufacturer() {
        log.info("start");
        ManufacturerService ms = beanFactory.getBean(ManufacturerService.class);
        Manufacturer m = ms.createManufacturer("Volvo", "Sweden");
        assertEquals(m.getName(), "Volvo");
    }
}