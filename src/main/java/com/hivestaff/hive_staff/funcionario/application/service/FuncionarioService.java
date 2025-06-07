package com.hivestaff.hive_staff.funcionario.application.service;

import com.hivestaff.hive_staff.funcionario.application.api.*;
import com.hivestaff.hive_staff.pdf_generate.application.api.FuncionarioPDF;

import java.util.List;
import java.util.UUID;

public interface FuncionarioService {
    FuncionarioResponse criaFuncionario(FuncionarioRequest novoFuncionario);
    FuncionarioDetalhadoResponse buscaPorId(UUID idFuncionario);
    List<FuncionarioListResponse> listarTodosFuncionarios();
    void deleteFuncionarioPorId(UUID idFuncionario);
    void alteraFuncionario(UUID idFuncionario, FuncionarioAlteracaoRequest alterarFuncionarioPorId);
}
