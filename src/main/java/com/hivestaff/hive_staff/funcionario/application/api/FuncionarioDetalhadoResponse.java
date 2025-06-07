package com.hivestaff.hive_staff.funcionario.application.api;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hivestaff.hive_staff.funcionario.domain.Endereco;
import com.hivestaff.hive_staff.funcionario.domain.Funcionario;
import lombok.Value;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Value
public class FuncionarioDetalhadoResponse {
    private UUID idFuncionario;
    private String nome;
    private Endereco endereco;
    private Double salarioFuncionario;
    private String designacao;
    private String  telefone;
    private String cpf;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataAniversario;
    private LocalDateTime dataHoraDoCadastro;
    private String email;

    public FuncionarioDetalhadoResponse(Funcionario funcionario) {
        this.telefone = funcionario.getTelefone();
        this.idFuncionario = funcionario.getIdFuncionario();
        this.nome = funcionario.getNome();
        this.endereco = funcionario.getEndereco();
        this.salarioFuncionario = funcionario.getSalarioFuncionario();
        this.designacao = funcionario.getDesignacao();
        this.cpf = funcionario.getCpf();
        this.dataAniversario = funcionario.getDataAniversario();
        this.dataHoraDoCadastro = funcionario.getDataHoraDoCadastro();
        this.email = funcionario.getEmail();
    }
}
