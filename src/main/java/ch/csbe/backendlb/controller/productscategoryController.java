package ch.csbe.backendlb.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("productscategory")
public class productscategoryController {

    @GetMapping("{id}")
    public String getProductcategoryByid(@PathVariable String id){
        return "hier währe meine producktkategory mit der id = " + id;
    }

    @GetMapping("{id}/products")
    public String getProductcategoryProductsByid(@PathVariable String id){
        return "hier währe meine producktkategory mit der id und passende Produkte= " + id;
    }

    @PutMapping("{id}")
    public String putProductcategoryByid(@PathVariable String id) { return "hier währe meine aktualisirtes producktktegory mit der id = " + id;
    }

    @DeleteMapping("{id}")
    public String deleteProductcategoryByid(@PathVariable String id) { return "hier wird meine producktkategory mit der id = " + id + " gelöscht";
    }

    @PostMapping("")
    public String PostProductcategory(){
        return "Hier wird ein neue Produktkategory erstelt";
    }

    @GetMapping("")
    public String getProductscategorycategory(){ return "hier währen meine producktkategoryen ";
    }

}
