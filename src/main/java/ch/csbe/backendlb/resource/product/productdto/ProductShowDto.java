package ch.csbe.backendlb.resource.product.productdto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

// ist DTO zum Anzeigen eines Produktes
@Data
public class ProductShowDto {
    @NotNull
    @Schema(description = "einmalige Id eines Produktes zum identifiziren")
    public Long id;
    @NotNull
    @Schema(description = "sku eines Produktes")
    public String sku;
    @NotNull
    @Schema(description = "aktivitäts status eines Produktes")
    public String active;
    @NotNull
    @Schema(description = "Name eines Produktes")
    public String name;
    @NotNull
    @Schema(description = "Das Bild zu einem Produkt")
    public String images;
    @NotNull
    @Schema(description = "BEschreibung eines Produktes")
    public String description;
    @NotNull
    @Schema(description = "Preis eines Produktes")
    public Double prise;
    @NotNull
    @Schema(description = "Lagerbestand eines Produktes")
    public String stock;


}
