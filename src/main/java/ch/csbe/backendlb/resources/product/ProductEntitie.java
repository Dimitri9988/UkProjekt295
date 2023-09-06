package ch.csbe.backendlb.resources.product;

import ch.csbe.backendlb.resources.category.CategoryEntities;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class ProductEntitie {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = ("int"),nullable = false)
    private Long id;

    @Column(columnDefinition = "varchar(100)",nullable = false)
    private String sku;

    @Column(columnDefinition = "tinyint",nullable = false)
    private String active;

    @Column(columnDefinition = "varchar(500)",nullable = false)
    private String name;

    @Column(columnDefinition = "varchar(1000)",nullable = false)
    private String images;

    @Column(columnDefinition = "mediumtext",nullable = false)
    private String description;

    @Column(columnDefinition = "float",nullable = false)
    private Double prise;

    @Column(columnDefinition = "int",nullable = false)
    private String stock;


    @ManyToOne()

    private CategoryEntities CategoryEntities;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
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

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrise() {
        return prise;
    }

    public void setPrise(Double prise) {
        this.prise = prise;
    }

    public String getStock() {
        return stock;
    }

    public void setStock(String stock) {
        this.stock = stock;
    }


}
