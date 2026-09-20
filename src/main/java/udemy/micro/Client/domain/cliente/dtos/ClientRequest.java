package udemy.micro.Client.domain.cliente.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record ClientRequest(@NotBlank(message = "Name não deve ser vazio.") String name,
                            @NotBlank
                            @Pattern(regexp = "\\d{11}", message = "CPF deve conter 11 digítos.")
                            String cpf) {
}
