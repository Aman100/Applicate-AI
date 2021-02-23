package com.applicateAI.cool;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.ModelAndView;
import com.applicateAI.cool.model.*;
import com.applicateAI.cool.service.*;
import java.util.*;
@Controller
public class CatalogController
{
@Autowired
private CatalogService catalogService;
@Autowired
private SupplierService supplierService;

@RequestMapping(value="/redirectToAddCatalog")
public ModelAndView redirectToAddCatalog()
{
ModelAndView modelAndView=new ModelAndView();
Iterable<Supplier> suppliers=supplierService.findAll();
modelAndView.addObject("suppliers",suppliers);
modelAndView.setViewName("AddCatalog");
return modelAndView;
}

@RequestMapping(value="/redirectToAddSupplier")
public String redirectToAddSupplier()
{
return "AddSupplier";
}


@RequestMapping(value="/addSupplier", method=RequestMethod.POST)
public String addCatalog(Supplier supplier)
{
System.out.println(supplier.getSupplier_name());
supplierService.save(supplier);
return "index";
}

@RequestMapping(value="/redirectToGetSKU")
public String redirectToGetSKU()
{
return "GetSKU";
}

@RequestMapping(value="/addCatalog", method=RequestMethod.POST)
public String addCatalog(Catalog catalog, @RequestParam(name="id") int sid)
{
System.out.println(catalog.getSku_name());
System.out.println(catalog.getSku_description());
System.out.println(catalog.getBrand_name());
System.out.println(catalog.getBrand_description());
System.out.println("SID : " + sid);
Supplier supplier=new Supplier();
supplier.setId(sid);
catalog.setSupplier(supplier);
catalogService.save(catalog);
return "index";
}

@RequestMapping(value="/getSKUNames", method=RequestMethod.GET)
public ModelAndView getSKUNames(@RequestParam(name="keyword") String keyword)
{
ModelAndView modelAndView=new ModelAndView();
List<Catalog> catalogs=catalogService.searchInCatalog(keyword);
modelAndView.setViewName("GetSKU");
modelAndView.addObject("catalogs",catalogs);
return modelAndView;
}

@RequestMapping(value="/getCatalogs", method=RequestMethod.GET)
@ResponseBody
public List<Catalog> getCatalogs(@RequestParam(name="keyword") String keyword)
{
List<Catalog> catalogs=catalogService.searchInCatalog(keyword);
return catalogs;
}

}