package com.hivestaff.hive_staff.funcionario.application.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hivestaff.hive_staff.funcionario.domain.Sexo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class FuncionarioRequest {

    @NotBlank(message = "Nome obrigatorio")
    private String nome;
    @CPF
    @NotBlank
    @Size(min = 11, max = 14, message = "CPF deve conter 11 digitos")
    private String cpf;
    private Sexo sexo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataAniversario;
    @NotBlank
    private String cep;
    private String complemento;
    @NotBlank(message = "Número da casa é obrigatório")
    private String numeroCasa;
    private String telefone;
    private Double salarioFuncionario;
    private String designacao;
    @Email(message = "Email inválido")
    @NotBlank(message = "Email obrigatório")
    private String email;
}
