package com.ejbappcromisoft.cxp.dao.impls;

import java.util.Arrays;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.appmodbasico.common.domains.Pgtbl_ppagosxu;
import com.ejbappcromisoft.cxp.common.AbstractBaseDao;
import com.ejbappcromisoft.cxp.dao.Pgtbl_PPagosxUDao;

@SuppressWarnings("rawtypes")
public class Pgtbl_PPagosxUDaoImpl extends AbstractBaseDao implements Pgtbl_PPagosxUDao {
	public List<Pgtbl_ppagosxu> listAll(String iEliminado_fl, String... iEstado_fl) {
		return super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosxUDaoImpl.listAll", iEliminado_fl, Arrays.asList(iEstado_fl));
	}

	public List<Object> listAllPk(String iEliminado_fl, String... iEstado_fl) {
		return super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosxUDaoImpl.listAllPk", iEliminado_fl, Arrays.asList(iEstado_fl));
	}

	public long countTotalRecords(String iEliminado_fl, String... iEstado_fl) {
		return super.verifyNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosxUDaoImpl.countTotalRecords", iEliminado_fl, Arrays.asList(iEstado_fl));
	}

	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Pgtbl_ppagosxu save(Pgtbl_ppagosxu newObject) {
		return (Pgtbl_ppagosxu) super.store(newObject);
	}

	public int getConcurrencyById(int lPPagoxU_id) {
		return super.verifyNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosxUDaoImpl.getConcurrencyById", lPPagoxU_id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public int updateByQuery(int lPPagoxU_id, String sCreated_by, int iConcurrencia_id, int lUsuario_id, int iPPago_id) {
		return super.executeByQueryName("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosxUDaoImpl.updateByQuery", lPPagoxU_id, sCreated_by, iConcurrencia_id, lUsuario_id, iPPago_id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public int deleteLogicalByQuery(int lPPagoxU_id, String iEliminado_fl, String sCreated_by, int iConcurrencia_id) {
		return super.executeByQueryName("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosxUDaoImpl.deleteLogicalByQuery", lPPagoxU_id, iEliminado_fl, sCreated_by, iConcurrencia_id);
	}

	public Pgtbl_ppagosxu getById(int lPPagoxU_id) {
		return super.verifyNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosxUDaoImpl.getById", lPPagoxU_id);
	}

	// Master Detail
	public List<Pgtbl_ppagosxu> listAllMD(Object mdPkValue, String iEliminado_fl, String... iEstado_fl) {
		return super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosxUDaoImpl.listAllMD", iEliminado_fl, Arrays.asList(iEstado_fl), mdPkValue);
	}

	public List<Object> listAllPkMD(Object mdPkValue, String iEliminado_fl, String... iEstado_fl) {
		return super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosxUDaoImpl.listAllPkMD", iEliminado_fl, Arrays.asList(iEstado_fl), mdPkValue);
	}

	public long countTotalRecordsMD(Object mdPkValue, String iEliminado_fl, String... iEstado_fl) {
		return super.verifyNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosxUDaoImpl.countTotalRecordsMD", iEliminado_fl, Arrays.asList(iEstado_fl), mdPkValue);
	}
}
