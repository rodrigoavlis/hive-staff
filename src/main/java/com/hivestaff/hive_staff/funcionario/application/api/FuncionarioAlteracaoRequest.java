package com.hivestaff.hive_staff.funcionario.application.api;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Email;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioAlteracaoRequest {

    private String nome;
    private String cep;
    private String complemento;
    private String numeroCasa;
    private String telefone;
    private Double salarioFuncionario;
    private String designacao;
    @Email(message = "Email inválido")
    private String email;

}
