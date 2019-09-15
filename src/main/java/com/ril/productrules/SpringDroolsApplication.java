package com.ril.productrules;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.io.IOException;
import java.util.ArrayList;


import static springfox.documentation.builders.PathSelectors.any;

//import static com.ril.productrules.SpringDroolsApplication.BrandsFromFile.importBrands;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.ril.productrules.domain.Brand;
import com.ril.productrules.domain.BrandPK;
import com.ril.productrules.domain.CommercialType;
import com.ril.productrules.repo.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
@EnableSwagger2
public class SpringDroolsApplication {
    //implements CommandLineRunner {

    @Autowired
    private BrandRepository brandRepository;

    public static void main(String[] args) {
        SpringApplication.run(SpringDroolsApplication.class, args);
    }

    @Bean
    public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors.basePackage("com.ril.productrules.controller")).paths(any()).build()
                .apiInfo(new ApiInfo("Product Rules API's",
                        "API's for the Product Rules Service", "2.0", null,
                        new Contact("Suhas Nair","https://www.ajio.com", ""),
                        null, null, new ArrayList<>()));
    }

    /**
     * Method invoked after this class has been instantiated by Spring container
     * Initializes the in-memory database with all the TourPackages and Tours.
     *
     * @param strings nothing as input
     * @throws Exception if problem occurs.
     */
    /*public void run(String... strings) throws Exception {
        //Create the default brands
        //Persist the Brands to the database
        importBrands().forEach(t-> brandRepository.save(new Brand(
                t.name, CommercialType.findByLabel(t.commericalType))));
        System.out.println("Number of brands =" + brandRepository.count());
    }*/

    /**
     * Helper class to import the records in the ExploreCalifornia.json
     */
    //static class BrandsFromFile {
        //attributes as listed in the .json file
        //private String name, commericalType;

        /**
         * Open the ExploreCalifornia.json, unmarshal every entry into a TourFromFile Object.
         *
         * @return a List of TourFromFile objects.
         * @throws IOException if ObjectMapper unable to open file.
         */
        /*static List<BrandsFromFile> importBrands() throws IOException {
            return new ObjectMapper().
                    setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY).
                    readValue(BrandsFromFile.class.
                            getResourceAsStream("/Brands.json"),
                            new TypeReference<List<BrandsFromFile>>(){});
        }
    }*/

}
