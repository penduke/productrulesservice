package com.ril.productrules.repo;

import com.ril.productrules.domain.Brand;
import com.ril.productrules.domain.BrandPK;
import com.ril.productrules.domain.CommercialType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.Optional;

@RepositoryRestResource(collectionResourceRel = "brands", path = "brands")
public interface BrandRepository extends JpaRepository<Brand, BrandPK> {

    /**
     * Lookup a tour package by the name.
     *
     * @param name name of the tour.
     * @return TourPackage if found, null otherwise.
     */
    Optional<Brand> findByName(@Param("name") String name);

    /**
     * Lookup a tour package by the name.
     *
     * @param commercialType name of the tour.
     * @return TourPackage if found, null otherwise.
     */
    List<Brand> findByCommercialType(@Param("commercialType") CommercialType commercialType);

}
