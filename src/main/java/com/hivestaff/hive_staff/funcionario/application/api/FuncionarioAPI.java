package com.hivestaff.hive_staff.funcionario.application.api;

import com.hivestaff.hive_staff.funcionario.domain.Endereco;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping(value = "/v1/funcionario")
public interface FuncionarioAPI {

    @GetMapping("/{cep}")
    Endereco buscarEndereco(@PathVariable String cep);

    @PostMapping(value = "/criar-funcionario")
    @ResponseStatus(HttpStatus.CREATED)
    FuncionarioResponse criaFuncionario(@RequestBody @Valid FuncionarioRequest novoFuncionario);

    @GetMapping(value = "/busca-funcionario-id/{idFuncionario}")
    @ResponseStatus(HttpStatus.OK)
    FuncionarioDetalhadoResponse buscaFuncionarioPorId(@PathVariable UUID idFuncionario);

    @GetMapping(value = "/listar-funcionarios")
    @ResponseStatus(HttpStatus.OK)
    List<FuncionarioListResponse> listarFuncionarios();

    @DeleteMapping(value = "/deleta-funcionario-id/{idFuncionario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void deletaFuncionarioPorId(@PathVariable UUID idFuncionario);

    @PatchMapping(value = "alterar-funcionario-id/{idFuncionario}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    void alteraFuncionario (@PathVariable UUID idFuncionario,
                            @Valid @RequestBody FuncionarioAlteracaoRequest alterarFuncionarioPorId);

}
