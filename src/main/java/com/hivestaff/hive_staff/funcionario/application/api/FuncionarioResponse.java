package com.hivestaff.hive_staff.funcionario.application.api;

import com.hivestaff.hive_staff.funcionario.domain.Funcionario;
import lombok.Data;

import java.util.UUID;

@Data
public class FuncionarioResponse {
    private UUID idFuncionario;

    public FuncionarioResponse(Funcionario funcionario) {
        this.idFuncionario = funcionario.getIdFuncionario();
    }
}
