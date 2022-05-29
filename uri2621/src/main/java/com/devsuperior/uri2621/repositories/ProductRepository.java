package com.devsuperior.uri2621.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.devsuperior.uri2621.dto.ProductMinDTO;
import com.devsuperior.uri2621.entities.Product;
import com.devsuperior.uri2621.projections.ProductMinProjection;

public interface ProductRepository extends JpaRepository<Product, Long> {
	
	@Query(nativeQuery = true, value = "SELECT products.name "
			+ "FROM products "
			+ "INNER JOIN providers ON products.id_providers = providers.id "
			+ "WHERE products.amount BETWEEN :min and :max "
			+ "AND LOWER(providers.name) LIKE LOWER(CONCAT(:firstCharName, '%'))")
	List<ProductMinProjection> search1(Integer min, Integer max, String firstCharName);
	
	@Query("SELECT new com.devsuperior.uri2621.dto.ProductMinDTO(obj.name) "
			+ "FROM Product obj "
			+ "WHERE obj.amount BETWEEN :min and :max "
			+ "AND LOWER(obj.provider.name) LIKE LOWER(CONCAT(:firstCharName, '%'))")
	List<ProductMinDTO> search2(Integer min, Integer max, String firstCharName);

}
