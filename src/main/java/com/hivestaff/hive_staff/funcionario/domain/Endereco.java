package com.hivestaff.hive_staff.funcionario.domain;

import com.hivestaff.hive_staff.funcionario.application.api.EnderecoViaCepResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String cep;
    private String logradouro;
    private String complemento;
    private String bairro;
    private String localidade;
    private String uf;
    private String numeroCasa;
    public Endereco(EnderecoViaCepResponse viaCepResponse ) {
        this.cep = viaCepResponse.getCep();
        this.logradouro = viaCepResponse.getLogradouro();
        this.bairro = viaCepResponse.getBairro();
        this.localidade = viaCepResponse.getLocalidade();
        this.uf = viaCepResponse.getUf();

    }

    public Endereco(EnderecoViaCepResponse viaCepResponse, String complemento, String numeroCasa) {
        this.cep = viaCepResponse.getCep();
        this.logradouro = viaCepResponse.getLogradouro();
        this.bairro = viaCepResponse.getBairro();
        this.localidade = viaCepResponse.getLocalidade();
        this.uf = viaCepResponse.getUf();
        this.complemento = complemento;
        this.numeroCasa = numeroCasa;
    }

}
