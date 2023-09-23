package ch.csbe.backendlb.resource.category.categorydto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

// ist DTO zum Anzeigen einer Kategory
@Data
@Schema(description = "DTO zum anzeigen einer Kategory")
public class CategoryShowDto {
    @NotNull
    @Schema(description = "einmalige Id zum identifiziren einer Kategory")
    public Long id;
    @NotNull
    @Schema(description = "aktivitäts status einer Kategory")
    public String active;
    @NotNull
    @Schema(description = "Name einer Kategory")
    public String name;
}
