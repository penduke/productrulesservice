package com.ril.productrules.domain;

public enum CommercialType {
    JIT("JIT"), DROPSHIP ("DROPSHIP"), OR("OR"), SOR("SOR");

    private String label;

    CommercialType(String label) {
        this.label = label;
    }

    public static CommercialType findByLabel(String byLabel) {
        for(CommercialType r:CommercialType.values()) {
            if (r.label.equalsIgnoreCase(byLabel))
                return r;
        }
        return null;
    }

    public String getLabel() {
        return label;
    }
}