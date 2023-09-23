package ch.csbe.backendlb.resource.category.categorydto;

import ch.csbe.backendlb.resource.product.productdto.ProductShowDto;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

//DTO für die Detailansicht einer Kategory
@Data
@Schema (description = "DTO zur Detailansicht einer Kategory")
public class CategoryDetailDto {
    @NotNull
    @Schema(description = "einmalige Id zum identifiziren einer Kategory")
    public Long id;
    @NotNull
    @Schema (description = "aktivitäts status einer Kategory")
    public  String active;
    @NotNull
    @Schema (description = "Name einer Kategory")
    public String name;
    @NotNull
    @Schema (description = "Produkte einer Kategory")
    private ProductShowDto product;
}
