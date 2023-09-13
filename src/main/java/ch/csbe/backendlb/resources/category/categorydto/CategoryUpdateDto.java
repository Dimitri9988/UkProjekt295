package ch.csbe.backendlb.resources.category.categorydto;

import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Data
public class CategoryUpdateDto {
    public Long id;
    public  String active;
    public String name;
}
