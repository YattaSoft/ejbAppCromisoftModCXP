package com.ejbappcromisoft.cxp.dao;

import java.util.List;

public interface Petbl_PersonasDao {
    public List<Object[]> listAllWithName(String iEliminado_fl, String... iEstado_fl);

    public List<Object[]> listPetbl_PersonasByGroupWithName(String iEliminado_fl, int grupoId, String... iEstado_fl);
}
