package udemy.micro.cliente.adapter.output.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String cpf;

    @Column
    private String name;

    public Cliente(String name, String cpf) {
        this.name = name;
        this.cpf = cpf;
    }
}