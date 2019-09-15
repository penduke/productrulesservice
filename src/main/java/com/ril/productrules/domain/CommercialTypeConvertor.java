package com.ril.productrules.domain;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;


//@Converter(autoApply = true)
public class CommercialTypeConvertor implements AttributeConverter<CommercialType, String> {
    @Override
    public String convertToDatabaseColumn(CommercialType commercialType) {
        return commercialType.getLabel();
    }

    @Override
    public CommercialType convertToEntityAttribute(String s) {
        return CommercialType.findByLabel(s);
    }
}