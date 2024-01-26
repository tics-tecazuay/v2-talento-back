package com.ista.talento_humano.services.primary.ServiceImpl;

import com.ista.talento_humano.model.primary.VFiltros;
import com.ista.talento_humano.repository.primary.VFiltrosRepository;
import com.ista.talento_humano.services.primary.Service.GenericService;
import com.ista.talento_humano.services.primary.Service.VFiltrosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Service;

@Service
public class VFiltrosServiceImpl extends GenericServiceImpl<VFiltros,Long>implements VFiltrosService {

    @Autowired
    VFiltrosRepository vFiltrosRepository;
    @Override
    public CrudRepository<VFiltros, Long> getDao() {
        return vFiltrosRepository;
    }
}
