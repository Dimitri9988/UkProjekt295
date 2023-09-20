package ch.csbe.backendlb.resources.category;

import ch.csbe.backendlb.resources.product.ProductEntitie;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class CategoryEntities {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = ("int"),nullable = false)
    private Long id;

    @Column(columnDefinition = ("tinyint"),nullable = false)
    private int active;

    @Column(columnDefinition = ("varchar(255)"),nullable = false)
    private String name;

    @OneToMany()
    private List<ProductEntitie> ProductEntitie;


    public List<ch.csbe.backendlb.resources.product.ProductEntitie> getProductEntitie() {
        return ProductEntitie;
    }

    public void setProductEntitie(List<ch.csbe.backendlb.resources.product.ProductEntitie> productEntitie) {
        ProductEntitie = productEntitie;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getActive() {
        return active;
    }

    public void setActive(int active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
