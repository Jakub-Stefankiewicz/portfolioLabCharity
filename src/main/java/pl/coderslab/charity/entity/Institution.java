package pl.coderslab.charity.entity;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import jakarta.persistence.*;


@Entity
@Data
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank
    private String name;
    @NotBlank
    private String description;

}
