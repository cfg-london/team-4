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

    public AgeGroup(String agerange, float value, Survey survey) {
        this.agerange = agerange;
        this.value = value;
        this.survey = survey;
    }

    @Column(name = "agerange")
    private String agerange;

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

    public String getAgerange() {
        return agerange;
    }

    public void setAgerange(String agerange) {
        this.agerange = agerange;
    }

    public Survey getSurvey() {
        return survey;
    }

    public void setSurvey(Survey survey) {
        this.survey = survey;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
}
