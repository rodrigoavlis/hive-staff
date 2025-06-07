package com.hivestaff.hive_staff.funcionario.application.api;

import com.hivestaff.hive_staff.funcionario.domain.Funcionario;
import lombok.Value;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Value
public class FuncionarioListResponse {
    private UUID idFuncionario;
    private String nome;
    private String designacao;
    private String  telefone;
    private String cpf;
    public static List<FuncionarioListResponse> converte(List<Funcionario> funcionarios) {
        return funcionarios.stream()
                .map(FuncionarioListResponse::new)
                .collect(Collectors.toList());
    }
    public FuncionarioListResponse(Funcionario funcionario) {
        this.cpf = funcionario.getCpf();
        this.idFuncionario = funcionario.getIdFuncionario();
        this.nome = funcionario.getNome();
        this.designacao = funcionario.getDesignacao();
        this.telefone = funcionario.getTelefone();
    }


}
