package cfg.codeforgood.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "agegroup")
public class AgeGroup {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    public AgeGroup() {
    }

    public AgeGroup(long lower_bound, long upper_bound, float value, Survey survey) {

        this.lower_bound = lower_bound;
        this.upper_bound = upper_bound;
        this.value = value;
        this.survey = survey;
    }

    @Column(name = "lower_bound")
    private long lower_bound;

    @Column(name = "upper_bound")
    private long upper_bound;

    @Column(name = "val")
    private float value;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "survey_id_fk")
    private Survey survey;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getLower_bound() {
        return lower_bound;
    }

    public void setLower_bound(long lower_bound) {
        this.lower_bound = lower_bound;
    }

    public long getUpper_bound() {
        return upper_bound;
    }

    public void setUpper_bound(long upper_bound) {
        this.upper_bound = upper_bound;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
