package com.hivestaff.hive_staff.funcionario.infra;

import com.hivestaff.hive_staff.funcionario.domain.Funcionario;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.UUID;

public interface FuncionarioMongoSpringRepository extends MongoRepository<Funcionario, UUID> {
}
