package com.hivestaff.hive_staff.funcionario.application.api;

import com.hivestaff.hive_staff.funcionario.application.service.FuncionarioService;
import com.hivestaff.hive_staff.funcionario.application.service.ViaCepService;
import com.hivestaff.hive_staff.funcionario.domain.Endereco;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.UUID;

@RequiredArgsConstructor
@RestController
@Log4j2
public class FuncionarioController implements FuncionarioAPI {
    private final FuncionarioService funcionarioService;
    private final ViaCepService viaCepService;
    @Override
    public FuncionarioResponse criaFuncionario(FuncionarioRequest novoFuncionario) {
        log.info("[inicia] FuncionarioController - criaFuncionario");
        FuncionarioResponse funcionarioNovo = funcionarioService.criaFuncionario(novoFuncionario);
        log.info("[finaliza] FuncionarioController - criaFuncionario");
        return funcionarioNovo;
    }

    @Override
    public FuncionarioDetalhadoResponse buscaFuncionarioPorId(UUID idFuncionario) {
        log.info("[inicia] FuncionarioController - buscaFuncionarioPorId");
        log.info("[idFuncionario] {}", idFuncionario);
        FuncionarioDetalhadoResponse funcionarioDetalhado = funcionarioService.buscaPorId(idFuncionario);
        log.info("[finaliza] FuncionarioController - buscaFuncionarioPorId");
        return funcionarioDetalhado;
    }

    @Override
    public List<FuncionarioListResponse> listarFuncionarios() {
        log.info("[inicia] FuncionarioController - listarFuncionarios");
        List<FuncionarioListResponse> funcionarios = funcionarioService.listarTodosFuncionarios();
        log.info("[finaliza] FuncionarioController - listarFuncionarios");
        return funcionarios;
    }

    @Override
    public void deletaFuncionarioPorId(UUID idFuncionario) {
        log.info("[inicia] FuncionarioController - deletaFuncionarioPorId");
        log.info("[idFuncionario] {}", idFuncionario);
        funcionarioService.deleteFuncionarioPorId(idFuncionario);
        log.info("[finaliza] FuncionarioController - deletaFuncionarioPorId");
    }

    @Override
    public void alteraFuncionario(UUID idFuncionario, FuncionarioAlteracaoRequest alterarFuncionarioPorId) {
        log.info("[inicia] FuncionarioController - alteraFuncionario");
        log.info("[idFuncionario] {}", idFuncionario);
        funcionarioService.alteraFuncionario(idFuncionario, alterarFuncionarioPorId);
        log.info("[finaliza] FuncionarioController - alteraFuncionario");
    }

    @Override
    public Endereco buscarEndereco(String cep) {
        log.info("[inicia] FuncionarioController - buscarEndereco");
        EnderecoViaCepResponse response = viaCepService.buscarEnderecoPorCep(cep);
        log.info("[finaliza] FuncionarioController - buscarEndereco");
        return new Endereco(response);
    }
}
