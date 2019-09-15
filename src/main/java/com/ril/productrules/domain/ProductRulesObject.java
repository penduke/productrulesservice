package com.ril.productrules.domain;

import java.util.Set;

public class ProductRulesObject {


	public Set<String> getBrands() {
		return brands;
	}

	public void setBrands(Set<String> brands) {
		this.brands = brands;
	}

	private ProductDTO productDTO;

	public ProductDTO getProductDTO() {
		return productDTO;
	}

	public void setProductDTO(ProductDTO productDTO) {
		this.productDTO = productDTO;
	}

	private Set<String> brands;

}
