package udemy.micro.Client.adapter.output.repository.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Client {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cpf;

    @Column
    private String name;

    public Client(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }
}