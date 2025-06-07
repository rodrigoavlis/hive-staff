package com.hivestaff.hive_staff.pdf_generate.application.api;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("v2/pdf")
public interface PdfAPI {
    @GetMapping("/funcionarios")
    void gerarPdf(HttpServletResponse response) throws IOException;
}
