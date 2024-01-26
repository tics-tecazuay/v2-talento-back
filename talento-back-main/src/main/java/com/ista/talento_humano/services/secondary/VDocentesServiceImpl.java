package com.ista.talento_humano.services.secondary;

import com.ista.talento_humano.model.secondary.Vdocentespppall;
import com.ista.talento_humano.repository.secondary.VDocentesRepository;
import com.ista.talento_humano.services.primary.ServiceImpl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class VDocentesServiceImpl extends GenericServiceImpl<Vdocentespppall,Long>implements VDocentesService {
    @Autowired
    VDocentesRepository docentesRepository;
    @Override
    public CrudRepository<Vdocentespppall, Long> getDao() {
        return docentesRepository;
    }
}
