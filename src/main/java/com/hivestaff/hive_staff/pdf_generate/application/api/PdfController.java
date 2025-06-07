package com.hivestaff.hive_staff.pdf_generate.application.api;

import com.hivestaff.hive_staff.funcionario.application.api.FuncionarioListResponse;
import com.hivestaff.hive_staff.funcionario.application.service.FuncionarioService;
import com.hivestaff.hive_staff.pdf_generate.application.service.GeradorPdfService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.web.bind.annotation.RestController;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RequiredArgsConstructor
@RestController
@Log4j2
public class PdfController implements PdfAPI {
    private final GeradorPdfService geradorPdfService;
    private final FuncionarioService funcionarioService;

    @Override
    public void gerarPdf(HttpServletResponse response) throws IOException {
        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=funcionarios.pdf");
        List<FuncionarioListResponse> funcionarios = funcionarioService.listarTodosFuncionarios();
        geradorPdfService.gerar(response, funcionarios);
    }
}
