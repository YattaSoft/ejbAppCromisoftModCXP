package com.ejbappcromisoft.cxp.service.impls;

import java.util.List;

import com.appmodbasico.common.constants.AppBaseConstants;
import com.ejbappcromisoft.cxp.dao.Petbl_PersonasDao;
import com.ejbappcromisoft.cxp.dao.impls.Petbl_PersonasDaoImpl;
import com.ejbappcromisoft.cxp.service.Petbl_PersonasService;

public class Petbl_PersonasServiceImpl implements Petbl_PersonasService {
    Petbl_PersonasDao dao = new Petbl_PersonasDaoImpl();

    public List<Object[]> listAllPetbl_PersonasWithName(String... iEstado_fl) {
        return dao.listAllWithName(AppBaseConstants.DELETED_VALUE_FALSE, iEstado_fl);
    }

    
    public List<Object[]> listPetbl_PersonasByGroupWithName(int grupoId, String... iEstado_fl) {
        return dao.listPetbl_PersonasByGroupWithName(AppBaseConstants.DELETED_VALUE_FALSE, grupoId, iEstado_fl);
    }
}
