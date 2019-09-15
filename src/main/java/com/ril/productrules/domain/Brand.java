package com.ril.productrules.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

/**
 * A Classification of Tours.
 *
 * Created by Mary Ellen Bowman
 */
@Table(name="brand")
@Entity
public class Brand implements Serializable {


    // -----//

    /*

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", commercialType=" + commercialType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(id, brand.id) &&
                Objects.equals(name, brand.name) &&
                commercialType == brand.commercialType;
    }*/

    // -----//


    // -----//

    @EmbeddedId
    private BrandPK pk;

    public Brand(BrandPK pk) {
        this.pk = pk;
    }

    public BrandPK getPk() {
        return pk;
    }

    public void setPk(BrandPK pk) {
        this.pk = pk;
    }

    @Override
    public String toString() {
        return "Brand{" +
                "pk=" + pk +
                ", name='" + name + '\'' +
                ", commercialType=" + commercialType +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(pk, brand.pk) &&
                Objects.equals(name, brand.name) &&
                commercialType == brand.commercialType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pk, name, commercialType);
    }

    public Brand(String name, CommercialType commercialType) {
        this.name = name;
        this.commercialType = commercialType;
    }

    // -----//

    //@Column(name = "name")
    @Column(insertable = false, updatable = false,nullable = false)
    private String name;

    //@Column(name = "commercial_type")
    @Column(insertable = false, updatable = false,nullable = false)
    private CommercialType commercialType;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public CommercialType getCommercialType() {
        return commercialType;
    }

    public void setCommercialType(CommercialType commercialType) {
        this.commercialType = commercialType;
    }

    public Brand() {
    }

}
