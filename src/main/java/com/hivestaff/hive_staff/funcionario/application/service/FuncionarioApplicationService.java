package com.hivestaff.hive_staff.funcionario.application.service;

import com.hivestaff.hive_staff.funcionario.application.api.*;
import com.hivestaff.hive_staff.funcionario.application.repository.FuncionarioRepository;
import com.hivestaff.hive_staff.funcionario.domain.Endereco;
import com.hivestaff.hive_staff.funcionario.domain.Funcionario;
import com.hivestaff.hive_staff.pdf_generate.application.api.FuncionarioPDF;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
@Log4j2
public class FuncionarioApplicationService implements FuncionarioService {
    private final FuncionarioRepository funcionarioRepository;
    private final ViaCepService viaCepService; // 👈 injetando o serviço ViaCEP

    @Override
    public FuncionarioResponse criaFuncionario(FuncionarioRequest novoFuncionario) {
        log.info("[inicia] FuncionarioApplicationService - criaFuncionario");
        // Busca o endereço pelo CEP
        EnderecoViaCepResponse enderecoViaCep = viaCepService.buscarEnderecoPorCep(novoFuncionario.getCep());
        // Cria o funcionário com os dados do endereço preenchidos automaticamente
        Endereco enderecoCompleto = new Endereco(enderecoViaCep, novoFuncionario.getComplemento(), novoFuncionario.getNumeroCasa());
        Funcionario funcionario = new Funcionario(novoFuncionario, enderecoCompleto);
        funcionarioRepository.salva(funcionario);
        log.info("[finaliza] FuncionarioApplicationService - criaFuncionario");
        return new FuncionarioResponse(funcionario);
    }

    @Override
    public FuncionarioDetalhadoResponse buscaPorId(UUID idFuncionario) {
        log.info("[inicia] FuncionarioApplicationService - buscaPorId");
        log.info("[idFuncionario] {}" , idFuncionario);
        Funcionario funcionario = funcionarioRepository.buscaFuncionarioPorId(idFuncionario);
        log.info("[finaliza] FuncionarioApplicationService - buscaPorId");
        return new FuncionarioDetalhadoResponse(funcionario);
    }

    @Override
    public List<FuncionarioListResponse> listarTodosFuncionarios() {
        log.info("[inicia] FuncionarioApplicationService - listarTodosFuncionarios");
        List<Funcionario> funcionarios = funcionarioRepository.listaTodosFuncionarios();
        log.info("[finaliza] FuncionarioApplicationService - listarTodosFuncionarios");
        return FuncionarioListResponse.converte(funcionarios);
    }

    @Override
    public void deleteFuncionarioPorId(UUID idFuncionario) {
        log.info("[inicia] FuncionarioApplicationService - deleteFuncionarioPorId");
        Funcionario funcionario = funcionarioRepository.buscaFuncionarioPorId(idFuncionario);
        funcionarioRepository.deletaFuncionario(funcionario);
        log.info("[finaliza] FuncionarioApplicationService - deleteFuncionarioPorId");

    }

    @Override
    public void alteraFuncionario(UUID idFuncionario, FuncionarioAlteracaoRequest alterarFuncionarioPorId) {
        log.info("[inicia] FuncionarioApplicationService - alteraFuncionario");
        Funcionario funcionario = funcionarioRepository.buscaFuncionarioPorId(idFuncionario);
        funcionario.altera(alterarFuncionarioPorId);
        funcionarioRepository.altera(funcionario);
        log.info("[finaliza] FuncionarioApplicationService - alteraFuncionario");

    }


}



