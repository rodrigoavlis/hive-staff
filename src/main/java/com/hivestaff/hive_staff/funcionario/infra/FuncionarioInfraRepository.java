package com.hivestaff.hive_staff.funcionario.infra;

import com.hivestaff.hive_staff.funcionario.application.api.FuncionarioAlteracaoRequest;
import com.hivestaff.hive_staff.funcionario.application.repository.FuncionarioRepository;
import com.hivestaff.hive_staff.funcionario.domain.Funcionario;
import com.hivestaff.hive_staff.funcionario.handler.APIException;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
@Log4j2
@RequiredArgsConstructor
@EnableMongoRepositories
public class FuncionarioInfraRepository implements FuncionarioRepository {
    private final FuncionarioMongoSpringRepository funcionarioMongoSpringRepository;
    @Override
    public Funcionario salva(Funcionario funcionario) {
        log.info("[inicia] FuncionarioMongoSpringRepository - salva");
        Funcionario novoFuncionario = funcionarioMongoSpringRepository.save(funcionario);
        log.info("[finaliza] FuncionarioMongoSpringRepository - salva");
        return funcionario;
    }

    @Override
    public Funcionario buscaFuncionarioPorId(UUID idFuncionario) {
        log.info("[inicia] FuncionarioMongoSpringRepository - buscaFuncionarioPorId");
        Funcionario funcionario = funcionarioMongoSpringRepository.findById(idFuncionario)
                .orElseThrow(() -> APIException.build(HttpStatus.NOT_FOUND,"Funcionario não encontrado"));
        log.info("[finaliza] FuncionarioMongoSpringRepository - buscaFuncionarioPorId");
        return funcionario;
    }

    @Override
    public List<Funcionario> listaTodosFuncionarios() {
        log.info("[inicia] FuncionarioMongoSpringRepository - listaTodosFuncionarios");
        List<Funcionario> todosFuncionarios = funcionarioMongoSpringRepository.findAll();
        log.info("[finaliza] FuncionarioMongoSpringRepository - listaTodosFuncionarios");
        return todosFuncionarios;
    }

    @Override
    public void deletaFuncionario(Funcionario funcionario) {
        log.info("[inicia] FuncionarioMongoSpringRepository - deletaFuncionario");
        funcionarioMongoSpringRepository.delete(funcionario);
        log.info("[finaliza] FuncionarioMongoSpringRepository - deletaFuncionario");
    }

    @Override
    public void altera(Funcionario funcionario) {
        log.info("[inicia] FuncionarioMongoSpringRepository - funcionarioAlterado");
        funcionarioMongoSpringRepository.save(funcionario);
        log.info("[finaliza] FuncionarioMongoSpringRepository - funcionarioAlterado");
    }
}
