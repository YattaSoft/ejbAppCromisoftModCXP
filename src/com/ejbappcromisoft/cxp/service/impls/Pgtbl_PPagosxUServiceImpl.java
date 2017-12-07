package com.ejbappcromisoft.cxp.service.impls;

import java.util.List;

import com.appmodbasico.common.constants.AppBaseConstants;
import com.appmodbasico.common.domains.Pgtbl_ppagosxu;
import com.ejbappcromisoft.cxp.dao.Pgtbl_PPagosxUDao;
import com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosxUDaoImpl;
import com.ejbappcromisoft.cxp.service.Pgtbl_PPagosxUService;

public class Pgtbl_PPagosxUServiceImpl implements Pgtbl_PPagosxUService {
	Pgtbl_PPagosxUDao dao = new Pgtbl_PPagosxUDaoImpl();

	public List<Pgtbl_ppagosxu> listAllPgtbl_PPagosxU(String... iEstado_fl) {
		return dao.listAll(AppBaseConstants.DELETED_VALUE_FALSE, iEstado_fl);
	}

	public List<Object> listAllPgtbl_PPagosxUPk(String... iEstado_fl) {
		return dao.listAllPk(AppBaseConstants.DELETED_VALUE_FALSE, iEstado_fl);
	}

	public long totalRecordsPgtbl_PPagosxU(String... iEstado_fl) {
		return dao.countTotalRecords(AppBaseConstants.DELETED_VALUE_FALSE, iEstado_fl);
	}

	public Pgtbl_ppagosxu insertPgtbl_PPagosxU(String sCreated_by, int lUsuario_id, int iPPago_id) {
		Pgtbl_ppagosxu newObject = new Pgtbl_ppagosxu();
		newObject.setSCreated_by(sCreated_by);
		newObject.setIEliminado_fl(AppBaseConstants.DELETED_VALUE_FALSE);
		newObject.setIConcurrencia_id(AppBaseConstants.CONCURRENCY_INITIAL_VALUE);
		newObject.setIEstado_fl(AppBaseConstants.STATUS_VALUE_ACTIVE);
		newObject.setLUsuario_id(lUsuario_id);
		newObject.setIPPago_id(iPPago_id);
		return dao.save(newObject);
	}

	public boolean updatePgtbl_PPagosxU(int lPPagoxU_id, String sCreated_by, int iConcurrencia_id, int lUsuario_id, int iPPago_id) {
		if (dao.getConcurrencyById(lPPagoxU_id) == iConcurrencia_id) {
			return dao.updateByQuery(lPPagoxU_id, sCreated_by, iConcurrencia_id + 1, lUsuario_id, iPPago_id) != 0;
		} else {
			return false;
		}
	}

	public boolean deletePgtbl_PPagosxU(int lPPagoxU_id, String sCreated_by, int iConcurrencia_id) {
		if (dao.getConcurrencyById(lPPagoxU_id) == iConcurrencia_id) {
			return dao.deleteLogicalByQuery(lPPagoxU_id, AppBaseConstants.DELETED_VALUE_TRUE, sCreated_by, iConcurrencia_id + 1) != 0;
		} else {
			return false;
		}
	}

	public Pgtbl_ppagosxu getByIdPgtbl_PPagosxU(int lPPagoxU_id) {
		return dao.getById(lPPagoxU_id);
	}

	// Master Detail
	public List<Pgtbl_ppagosxu> listAllPgtbl_PPagosxUMD(Object mdPkValue, String... iEstado_fl) {
		return dao.listAllMD(mdPkValue, AppBaseConstants.DELETED_VALUE_FALSE, iEstado_fl);
	}

	public List<Object> listAllPgtbl_PPagosxUPkMD(Object mdPkValue, String... iEstado_fl) {
		return dao.listAllPkMD(mdPkValue, AppBaseConstants.DELETED_VALUE_FALSE, iEstado_fl);
	}

	public long totalRecordsPgtbl_PPagosxUMD(Object mdPkValue, String... iEstado_fl) {
		return dao.countTotalRecordsMD(mdPkValue, AppBaseConstants.DELETED_VALUE_FALSE, iEstado_fl);
	}
}
