package com.ril.productrules.controller;

import com.ril.productrules.domain.ProductRulesObject;
import com.ril.productrules.domain.Brand;
import com.ril.productrules.domain.CommercialType;
import com.ril.productrules.domain.ErrorDTO;
import com.ril.productrules.domain.ProductDTO;
import com.ril.productrules.repo.BrandRepository;
import org.kie.api.runtime.KieSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(path = "/productrules")
public class ProductRulesController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductRulesController.class);

	@Autowired
	private KieSession session;

	@Autowired
	private BrandRepository brandRepository;

	@PostMapping("/calculateProductAttributes")
	public ProductDTO calculateProductAttributes(@RequestBody ProductDTO productDTO) {

		LOGGER.info("POST /calculateProductAttributes " + productDTO.getProductId());
		if(productDTO.getProductId().isEmpty() || productDTO.getProductId() == null)
			throw new NoSuchElementException("Product Id cannot be null");

		ProductRulesObject productRulesObject = new ProductRulesObject();

		CommercialType byLabel = CommercialType.findByLabel(productDTO.getCommercialType());
		if(byLabel!= null) LOGGER.info("Label : " + byLabel.toString());
		List<Brand> brandList = brandRepository.findByCommercialType(byLabel);

		Set<String> brands = new HashSet<>();

		for (Brand b: brandList){
			LOGGER.info(b.getName());
			brands.add(b.getName());
		}

		productRulesObject.setBrands(brands);
		productRulesObject.setProductDTO(productDTO);

		session.insert(productRulesObject);
		session.fireAllRules();

		LOGGER.info("POST /calculateProductAttributes " + productDTO.getProductId() + " Droppable is " +
				productDTO.getDroppableAtStore() + " Pickable is " + productDTO.getPickableAtStore());
		return productDTO;
	}

	/**
	 * Exception handler if NoSuchElementException is thrown in this Controller
	 *
	 * @param ex exception
	 * @return Error message String.
	 */
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NoSuchElementException.class)
	public ErrorDTO return404(NoSuchElementException ex) {
		return new ErrorDTO(ex.getMessage(), HttpStatus.NOT_FOUND.getReasonPhrase());
	}

}
