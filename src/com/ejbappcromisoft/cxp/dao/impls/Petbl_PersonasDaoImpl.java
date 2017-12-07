package com.ejbappcromisoft.cxp.dao.impls;

import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections.ListUtils;

import com.ejbappcromisoft.cxp.common.AbstractBaseDao;
import com.ejbappcromisoft.cxp.dao.Petbl_PersonasDao;

@SuppressWarnings("rawtypes")
public class Petbl_PersonasDaoImpl extends AbstractBaseDao implements Petbl_PersonasDao {
    public List<Object[]> listAllWithName(String iEliminado_fl, String... iEstado_fl) {
        List<Object[]> lista = ListUtils.union(
                super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Petbl_PersonasDaoImpl.listAllPJWithName", iEliminado_fl, Arrays.asList(iEstado_fl)),
                ListUtils.union(
                        super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Petbl_PersonasDaoImpl.listAllPF1WithName", iEliminado_fl, Arrays.asList(iEstado_fl)),
                        ListUtils.union(super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Petbl_PersonasDaoImpl.listAllPF2WithName", iEliminado_fl, Arrays.asList(iEstado_fl)),
                                super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Petbl_PersonasDaoImpl.listAllPF3WithName", iEliminado_fl, Arrays.asList(iEstado_fl)))));
        return lista;
    }

    
    public List<Object[]> listPetbl_PersonasByGroupWithName(String iEliminado_fl, int grupoId, String... iEstado_fl) {
		/*List<Object[]> lista = ListUtils.union(super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Petbl_PersonasDaoImpl.listAllPJByGroupWithName", iEliminado_fl,
                Arrays.asList(iEstado_fl), grupoId), ListUtils.union(super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Petbl_PersonasDaoImpl.listAllPF1ByGroupWithName", iEliminado_fl,
                Arrays.asList(iEstado_fl), grupoId), ListUtils.union(
                super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Petbl_PersonasDaoImpl.listAllPF2ByGroupWithName", iEliminado_fl, Arrays.asList(iEstado_fl), grupoId),
                super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Petbl_PersonasDaoImpl.listAllPF3ByGroupWithName", iEliminado_fl, Arrays.asList(iEstado_fl), grupoId))));
       */
    	return ListUtils.union(super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Petbl_PersonasDaoImpl.listAllPJByGroupWithName", iEliminado_fl,
                Arrays.asList(iEstado_fl)), ListUtils.union(super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Petbl_PersonasDaoImpl.listAllPF1ByGroupWithName", iEliminado_fl,
                Arrays.asList(iEstado_fl)), ListUtils.union(
                super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Petbl_PersonasDaoImpl.listAllPF2ByGroupWithName", iEliminado_fl, 
                		Arrays.asList(iEstado_fl)), super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Petbl_PersonasDaoImpl.listAllPF3ByGroupWithName", iEliminado_fl, Arrays.asList(iEstado_fl)))));
    	//return lista;
    }
}
