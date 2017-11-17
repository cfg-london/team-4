package cfg.codeforgood.entity;

import javax.persistence.*;

@Entity
@Table(name = "agegroups")
public class AgeGroups {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "lower_bound")
    private long lower_bound;

    @Column(name = "upper_bound")
    private long upper_bound;

    @Column(name = "val")
    private float value;

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
