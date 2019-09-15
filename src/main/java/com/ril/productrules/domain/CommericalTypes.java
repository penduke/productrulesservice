package com.ril.productrules.domain;


import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;

@Entity
public class CommericalTypes implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    @Enumerated(EnumType.STRING)
    private CommercialType commercialType;

    public CommercialType getCommercialType() {
        return commercialType;
    }

    public void setCommercialType(CommercialType commercialType) {
        this.commercialType = commercialType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CommericalTypes(Integer id, CommercialType commercialType) {
        this.id = id;
        this.commercialType = commercialType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CommericalTypes that = (CommericalTypes) o;
        return commercialType == that.commercialType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(commercialType);
    }

    @Override
    public String toString() {
        return "CommericalTypes{" +
                "id=" + id +
                ", commercialType=" + commercialType +
                '}';
    }
}
