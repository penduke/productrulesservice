package com.ril.productrules.domain;

public class ProductDTO {

    private String productId;
    private String commercialType;
    private String brandName;
    private int droppableAtStore;
    private int pickableAtStore;

    public String getProductId() {
        return productId;
    }

    public void setProductId(String productId) {
        this.productId = productId;
    }
    public String getCommercialType() {
        return commercialType;
    }

    public void setCommercialType(String commercialType) {
        this.commercialType = commercialType;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public int getDroppableAtStore() {
        return droppableAtStore;
    }

    public void setDroppableAtStore(int droppableAtStore) {
        this.droppableAtStore = droppableAtStore;
    }

    public int getPickableAtStore() {
        return pickableAtStore;
    }

    public void setPickableAtStore(int pickableAtStore) {
        this.pickableAtStore = pickableAtStore;
    }

}
