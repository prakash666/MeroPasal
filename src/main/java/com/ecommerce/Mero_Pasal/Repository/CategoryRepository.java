package com.ecommerce.Mero_Pasal.Repository;

import com.ecommerce.Mero_Pasal.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
}
