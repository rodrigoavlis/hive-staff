package com.hivestaff.hive_staff.pdf_generate.application.service;

import com.hivestaff.hive_staff.funcionario.application.api.FuncionarioListResponse;
import com.lowagie.text.*;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;
import org.apache.tomcat.util.http.fileupload.ByteArrayOutputStream;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.util.Comparator;
import java.util.List;

@Service
public class GeradorPdfService {

    public byte[] gerarPdfFuncionarios(List<FuncionarioListResponse> funcionarios) {
        try (ByteArrayOutputStream baos = new ByteArrayOutputStream()) {
            Document documento = new Document();
            PdfWriter.getInstance(documento, baos);
            documento.open();

            // Título
            Font tituloFont = new Font(Font.HELVETICA, 16, Font.BOLD);
            Paragraph titulo = new Paragraph("Relatório de Funcionários", tituloFont);
            titulo.setAlignment(Element.ALIGN_CENTER);
            documento.add(titulo);
            documento.add(Chunk.NEWLINE);

            // 👉 Ordena a lista por nome
            funcionarios.sort(Comparator.comparing(FuncionarioListResponse::getNome));

            // Tabela
            PdfPTable tabela = new PdfPTable(4);
            tabela.addCell("Nome");
            tabela.addCell("Designação");
            tabela.addCell("Telefone");
            tabela.addCell("CPF");

            for (FuncionarioListResponse f : funcionarios) {
                tabela.addCell(f.getNome());
                tabela.addCell(f.getDesignacao());
                tabela.addCell(f.getTelefone());
                tabela.addCell(f.getCpf());
            }

            documento.add(tabela);
            documento.close();
            return baos.toByteArray();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao gerar PDF", e);
        }
    }

    public void gerar(HttpServletResponse response, List<FuncionarioListResponse> funcionarios) {
        try {
            byte[] pdfBytes = gerarPdfFuncionarios(funcionarios);
            response.setContentType("application/pdf");
            response.setHeader("Content-Disposition", "attachment; filename=funcionarios.pdf");
            response.getOutputStream().write(pdfBytes);
            response.getOutputStream().flush();
        } catch (Exception e) {
            throw new RuntimeException("Erro ao escrever o PDF na resposta", e);
        }
    }
}
