package com.hivestaff.hive_staff.funcionario.application.repository;

import com.hivestaff.hive_staff.funcionario.application.api.FuncionarioAlteracaoRequest;
import com.hivestaff.hive_staff.funcionario.domain.Funcionario;

import java.util.List;
import java.util.UUID;

public interface FuncionarioRepository {
    public Funcionario salva(Funcionario funcionario);
    Funcionario buscaFuncionarioPorId(UUID idFuncionario);
    List<Funcionario> listaTodosFuncionarios();
    void deletaFuncionario(Funcionario funcionario);
    void altera(Funcionario funcionario);
}
