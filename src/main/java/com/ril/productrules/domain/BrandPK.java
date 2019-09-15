package com.ril.productrules.domain;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class BrandPK implements Serializable {

    @Column
    private String name;

    @Column(insertable = false, updatable = false,nullable = false)
    private CommercialType commercialType;

    public BrandPK(String name, CommercialType commercialType) {
        this.name = name;
        this.commercialType = commercialType;
    }

    public BrandPK() {
    }

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
}
