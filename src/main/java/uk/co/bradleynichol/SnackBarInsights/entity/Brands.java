package uk.co.bradleynichol.SnackBarInsights.entity;


import javax.persistence.*;

@Entity
@Table(name = "brands")
public class Brands {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private String Id;

    @Column(name = "name")
    private String name;

    public Brands() {
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
