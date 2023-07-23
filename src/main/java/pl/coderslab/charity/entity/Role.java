package pl.coderslab.charity.entity;
import jakarta.persistence.*;
import lombok.Data;
import lombok.ToString;


@Entity
@Data
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
}
