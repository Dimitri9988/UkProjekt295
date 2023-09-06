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
    private String active;

    @Column(columnDefinition = ("varchar(255)"),nullable = false)
    private String name;

    @OneToMany()
    private List<ProductEntitie> ProductEntitie;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }





}
