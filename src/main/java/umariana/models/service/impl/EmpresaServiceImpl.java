package umariana.models.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;
import umariana.models.commons.GenericServiceApi;
import umariana.models.commons.GenericServiceImpl;
import umariana.models.dao.EmpresaDao;
import umariana.models.entity.Empresa;
import umariana.models.service.api.EmpresaService;

@Service("EmpresaService")
public class EmpresaServiceImpl extends GenericServiceImpl<Empresa,Long> implements EmpresaService
{
    @Autowired
    private EmpresaDao dao;

    @Override
    public CrudRepository<Empresa, Long> getDao()
    {
        return dao;
    }
}


