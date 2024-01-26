package com.ista.talento_humano.services.secondary;

import com.ista.talento_humano.model.secondary.Vcarreras;
import com.ista.talento_humano.repository.secondary.VCarrerasRepository;
import com.ista.talento_humano.services.primary.ServiceImpl.GenericServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class VCarrerasServiceImpl extends GenericServiceImpl<Vcarreras, Long> implements VCarrerasService  {
    @Autowired
    VCarrerasRepository vCarrerasRepository;

    @Override
    public CrudRepository<Vcarreras, Long> getDao() {
        return vCarrerasRepository;
    }
}
