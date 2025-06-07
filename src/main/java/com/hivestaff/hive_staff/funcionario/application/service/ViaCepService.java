package com.hivestaff.hive_staff.funcionario.application.service;


import com.hivestaff.hive_staff.funcionario.application.api.EnderecoViaCepResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class ViaCepService {

    private final WebClient webClient;

    public ViaCepService(WebClient.Builder builder) {
        this.webClient = builder.baseUrl("https://viacep.com.br/ws").build();
    }

    public EnderecoViaCepResponse buscarEnderecoPorCep(String cep) {
        return webClient.get()
                .uri("/{cep}/json", cep)
                .retrieve()
                .bodyToMono(EnderecoViaCepResponse.class)
                .block(); // ou use async se quiser
    }
}

