package pl.coderslab.charity.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Table(name = "institutions")
public class Institution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Institution name is required")
    @Size(min = 3, max = 50)
    @Column(nullable = false, unique = true, length = 50)
    private String name;

    @NotBlank
    @Column(nullable = false)
    private String description;

    /* constructor */

    public Institution() {
    }

    public Institution(@NotBlank(message = "Institution name is required") @Size(min = 3, max = 50) String name) {
        this.name = name;
    }
    /* getters and setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Institution)) return false;
        Institution that = (Institution) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}






