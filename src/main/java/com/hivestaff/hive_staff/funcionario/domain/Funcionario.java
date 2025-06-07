package com.hivestaff.hive_staff.funcionario.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.hivestaff.hive_staff.funcionario.application.api.EnderecoViaCepResponse;
import com.hivestaff.hive_staff.funcionario.application.api.FuncionarioAlteracaoRequest;
import com.hivestaff.hive_staff.funcionario.application.api.FuncionarioRequest;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@Document(collection = "Functionary")
public class Funcionario {

    @Id
    private UUID idFuncionario;
    @NotBlank
    private String nome;
    private Endereco endereco;
    private Double salarioFuncionario;
    private String designacao;
    @Email
    private String email;
    @NotBlank
    private String  telefone;
    private Sexo sexo;
    @CPF
    private String cpf;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd/MM/yyyy")
    private LocalDate dataAniversario;

    private LocalDateTime dataHoraDoCadastro;
    private LocalDateTime dataHoraUltimaAlteracao;

    public Funcionario(FuncionarioRequest funcionarioRequest, Endereco endereco) {
        this.idFuncionario = UUID.randomUUID();
        this.nome = funcionarioRequest.getNome();
        this.salarioFuncionario = funcionarioRequest.getSalarioFuncionario();
        this.designacao = funcionarioRequest.getDesignacao();
        this.telefone = funcionarioRequest.getTelefone();
        this.sexo = funcionarioRequest.getSexo();
        this.email = funcionarioRequest.getEmail();
        this.cpf = funcionarioRequest.getCpf();
        this.dataAniversario = funcionarioRequest.getDataAniversario();
        this.dataHoraDoCadastro = LocalDateTime.now();
        this.endereco = endereco;
    }

    public Funcionario(FuncionarioRequest novoFuncionario, EnderecoViaCepResponse enderecoViaCep)  {
            this.idFuncionario = UUID.randomUUID();
            this.nome = novoFuncionario.getNome();
            this.cpf = novoFuncionario.getCpf();
            this.telefone = novoFuncionario.getTelefone();
            this.sexo = novoFuncionario.getSexo();
            this.email = novoFuncionario.getEmail();
            this.salarioFuncionario = novoFuncionario.getSalarioFuncionario();
            this.designacao = novoFuncionario.getDesignacao();
            this.dataAniversario = novoFuncionario.getDataAniversario();
            this.endereco = new Endereco(enderecoViaCep);
            this.dataHoraDoCadastro = LocalDateTime.now();
        }

        public void altera(FuncionarioAlteracaoRequest request) {
            if (request.getNome() != null) {
                this.nome = request.getNome();
            }
            if (request.getSalarioFuncionario() != null) {
                this.salarioFuncionario = request.getSalarioFuncionario();
            }
            if (request.getDesignacao() != null) {
                this.designacao = request.getDesignacao();
            }
            if (request.getEmail() != null) {
                this.email = request.getEmail();
            }
            if (request.getTelefone() != null) {
                this.telefone = request.getTelefone();
            }

            this.dataHoraUltimaAlteracao = LocalDateTime.now();

            if (this.endereco == null) {
                this.endereco = new Endereco();
            }
            if (request.getCep() != null) {
                this.endereco.setCep(request.getCep());
            }
            if (request.getNumeroCasa() != null) {
                this.endereco.setNumeroCasa(request.getNumeroCasa());
            }
            if (request.getComplemento() != null) {
                this.endereco.setComplemento(request.getComplemento());
            }
        }
    }

