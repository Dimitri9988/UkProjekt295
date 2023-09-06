package ch.csbe.backendlb.resources.product.productdto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
@Data
public class ProductDetailDto {
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
    //public CategoryShowDto toDos;
}
