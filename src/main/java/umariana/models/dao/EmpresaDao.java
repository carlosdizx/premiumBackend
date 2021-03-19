package umariana.models.dao;

import org.springframework.data.repository.CrudRepository;
import umariana.models.entity.Empresa;

public interface EmpresaDao extends CrudRepository<Empresa, Long> {
}
