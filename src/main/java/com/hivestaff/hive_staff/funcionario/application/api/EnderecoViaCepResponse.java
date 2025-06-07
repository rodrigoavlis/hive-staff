package com.hivestaff.hive_staff.funcionario.application.api;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EnderecoViaCepResponse {
    private String cep;
    private String logradouro;
    private String complemento;
    private String numeroCasa;
    private String bairro;
    private String localidade;
    private String uf;
}



