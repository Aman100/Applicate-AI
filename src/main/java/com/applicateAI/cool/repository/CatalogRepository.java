package com.applicateAI.cool.repository;

import org.springframework.data.repository.CrudRepository;
import com.applicateAI.cool.model.*;
import org.springframework.data.jpa.repository.Query;
import java.util.*;

public interface CatalogRepository extends CrudRepository<Catalog, Integer> {

@Query(value="SELECT * FROM catalog WHERE MATCH(sku_name) AGAINST(?1) UNION SELECT * FROM catalog where LOCATE(?1,sku_name)", nativeQuery=true)
public List<Catalog> searchInCatalog(String keyword);
}
