package ch.csbe.backendlb.resources.category.categorydto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class CategoryShowDto {
    @NotNull
    public Long id;
    @NotNull
    public  String active;
    @NotNull
    public String name;

}
