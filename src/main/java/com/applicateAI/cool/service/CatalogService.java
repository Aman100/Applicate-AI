package com.applicateAI.cool.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.applicateAI.cool.model.*;
import com.applicateAI.cool.repository.*;
import java.util.*;

@Service
public class CatalogService
{
@Autowired
private CatalogRepository catalogRepository;
	
public List<Catalog> searchInCatalog(String keyword)
{		
return catalogRepository.searchInCatalog(keyword);
}
	
public void save(Catalog catalog)
{
catalogRepository.save(catalog);
}
}