package ch.csbe.backendlb.resources.product.productdto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class ProductCreateDto {
    @NotNull
    public Long id;
    @NotNull
    public String sku;
    @NotNull
    public  String active;
    @NotNull
    public String name;
    @NotNull
    public String images;
    @NotNull
    public String description;
    @NotNull
    public Double prise;
    @NotNull
    public String stock;
    //@NotNull
    //private CategoryShowDto toDos;

}
