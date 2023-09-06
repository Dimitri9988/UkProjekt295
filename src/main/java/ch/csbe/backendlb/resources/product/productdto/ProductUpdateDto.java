package ch.csbe.backendlb.resources.product.productdto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class ProductUpdateDto {
    public Long id;
    public String sku;
    public  String active;
    public String name;
    public String images;
    public String description;
    public Double prise;
    public String stock;
    //public CategoryShowDto toDos;
}
