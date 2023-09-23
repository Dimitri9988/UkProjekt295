package ch.csbe.backendlb.resource.product.productdto;

import ch.csbe.backendlb.resource.category.categorydto.CategoryShowDto;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

// DTO zum Aktualisirten eines Produktes
@Getter
@Setter
@Data
public class ProductUpdateDto {
    @Schema(description = "einmalige Id eines Produktes zum identifiziren")
    public Long id;
    @Schema (description = "sku eines Produktes")
    public String sku;
    @Schema (description = "aktivitäts status eines Produktes")
    public  String active;
    @Schema (description = "Name eines Produktes")
    public String name;
    @Schema (description = "Das Bild zu einem Produkt")
    public String images;
    @Schema (description = "BEschreibung eines Produktes")
    public String description;
    @Schema (description = "Preis eines Produktes")
    public Double prise;
    @Schema (description = "Lagerbestand eines Produktes")
    public String stock;
    @Schema (description = "Kategory eines Produktes")
    private CategoryShowDto category_id;

}
