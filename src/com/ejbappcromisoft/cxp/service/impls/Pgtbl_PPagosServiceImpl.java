package com.ejbappcromisoft.cxp.service.impls;

import java.util.List;

import com.appmodbasico.common.constants.AppBaseConstants;
import com.appmodbasico.common.domains.Pgtbl_ppagos;
import com.ejbappcromisoft.cxp.dao.Pgtbl_PPagosDao;
import com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosDaoImpl;
import com.ejbappcromisoft.cxp.service.Pgtbl_PPagosService;

public class Pgtbl_PPagosServiceImpl implements Pgtbl_PPagosService {
	Pgtbl_PPagosDao dao = new Pgtbl_PPagosDaoImpl();

	public List<Pgtbl_ppagos> listAllPgtbl_PPagos(String... iEstado_fl) {
		return dao.listAll(AppBaseConstants.DELETED_VALUE_FALSE, iEstado_fl);
	}

	public List<Object> listAllPgtbl_PPagosPk(String... iEstado_fl) {
		return dao.listAllPk(AppBaseConstants.DELETED_VALUE_FALSE, iEstado_fl);
	}

	public long totalRecordsPgtbl_PPagos(String... iEstado_fl) {
		return dao.countTotalRecords(AppBaseConstants.DELETED_VALUE_FALSE, iEstado_fl);
	}

	public Pgtbl_ppagos insertPgtbl_PPagos(String sCreated_by, String sPPago_desc, int iCuotas_num, int iPeriodicidad_num, int iTolerancia_num, int iVencido_num) {
		Pgtbl_ppagos newObject = new Pgtbl_ppagos();
		newObject.setSCreated_by(sCreated_by);
		newObject.setIEliminado_fl(AppBaseConstants.DELETED_VALUE_FALSE);
		newObject.setIConcurrencia_id(AppBaseConstants.CONCURRENCY_INITIAL_VALUE);
		newObject.setIEstado_fl(AppBaseConstants.STATUS_VALUE_ACTIVE);
		newObject.setSPPago_desc(sPPago_desc);
		newObject.setICuotas_num(iCuotas_num);
		newObject.setIPeriodicidad_num(iPeriodicidad_num);
		newObject.setITolerancia_num(iTolerancia_num);
		newObject.setIVencido_num(iVencido_num);
		return dao.save(newObject);
	}

	public boolean updatePgtbl_PPagos(int iPPago_id, String sCreated_by, int iConcurrencia_id, String sPPago_desc, int iCuotas_num, int iPeriodicidad_num, int iTolerancia_num, int iVencido_num) {
		if (dao.getConcurrencyById(iPPago_id) == iConcurrencia_id) {
			return dao.updateByQuery(iPPago_id, sCreated_by, iConcurrencia_id + 1, sPPago_desc, iCuotas_num, iPeriodicidad_num, iTolerancia_num, iVencido_num) != 0;
		} else {
			return false;
		}
	}

	public boolean deletePgtbl_PPagos(int iPPago_id, String sCreated_by, int iConcurrencia_id) {
		if (dao.getConcurrencyById(iPPago_id) == iConcurrencia_id) {
			return dao.deleteLogicalByQuery(iPPago_id, AppBaseConstants.DELETED_VALUE_TRUE, sCreated_by, iConcurrencia_id + 1) != 0;
		} else {
			return false;
		}
	}

	public Pgtbl_ppagos getByIdPgtbl_PPagos(int iPPago_id) {
		return dao.getById(iPPago_id);
	}

	// Master Detail
	public List<Pgtbl_ppagos> listAllPgtbl_PPagosMD(Object mdPkValue, String... iEstado_fl) {
		return dao.listAllMD(mdPkValue, AppBaseConstants.DELETED_VALUE_FALSE, iEstado_fl);
	}

	public List<Object> listAllPgtbl_PPagosPkMD(Object mdPkValue, String... iEstado_fl) {
		return dao.listAllPkMD(mdPkValue, AppBaseConstants.DELETED_VALUE_FALSE, iEstado_fl);
	}

	public long totalRecordsPgtbl_PPagosMD(Object mdPkValue, String... iEstado_fl) {
		return dao.countTotalRecordsMD(mdPkValue, AppBaseConstants.DELETED_VALUE_FALSE, iEstado_fl);
	}
}
