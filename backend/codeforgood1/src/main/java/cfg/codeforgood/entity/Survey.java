package cfg.codeforgood.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "survey")
public class Survey{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "country")
    private String country;

    @Column(name = "value")
    private float value;

    @Column(name = "company")
    private String company;

    @JsonIgnore
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "survey",cascade = CascadeType.ALL)
    private Set<AgeGroup> agegroups;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "indicator_id_fk")
    private Indicator indicator;

    public Survey(String country, float value, String company) {
        this.country = country;
        this.value = value;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Set<AgeGroup> getAgegroups() {
        return agegroups;
    }

    public void setAgegroups(Set<AgeGroup> agegroups) {
        this.agegroups = agegroups;
    }

    @Override
    public String toString() {
        return "Survey{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", value=" + value +
                ", company='" + company + '\'' +
                ", agegroups=" + agegroups +
                '}';
    }
}
