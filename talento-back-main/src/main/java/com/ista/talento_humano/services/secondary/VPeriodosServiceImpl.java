package com.ista.talento_humano.services.secondary;

import com.ista.talento_humano.model.secondary.vperiodos;
import com.ista.talento_humano.repository.secondary.VPeriodosRepository;
import com.ista.talento_humano.services.primary.ServiceImpl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class
VPeriodosServiceImpl extends GenericServiceImpl<vperiodos,Long>implements VPeriodosService {

    @Autowired
    VPeriodosRepository periodosRepository;

    @Override
    public CrudRepository<vperiodos, Long> getDao() {
        return periodosRepository;
    }
}
