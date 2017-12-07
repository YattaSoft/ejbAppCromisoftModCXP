package com.ejbappcromisoft.cxp.service;

import java.util.List;

public interface Petbl_PersonasService {
    public List<Object[]> listAllPetbl_PersonasWithName(String... iEstado_fl);

    public List<Object[]> listPetbl_PersonasByGroupWithName(int grupoId, String... iEstado_fl);
}
