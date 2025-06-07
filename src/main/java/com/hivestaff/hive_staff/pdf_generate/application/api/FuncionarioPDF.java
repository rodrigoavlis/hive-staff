package com.hivestaff.hive_staff.pdf_generate.application.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class FuncionarioPDF {
    private String nome;
    private String designacao;
    private String telefone;
    private String cpf;
}
