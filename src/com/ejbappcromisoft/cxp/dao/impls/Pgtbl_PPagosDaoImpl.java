package com.ejbappcromisoft.cxp.dao.impls;

import java.util.Arrays;
import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import com.appmodbasico.common.domains.Pgtbl_ppagos;
import com.ejbappcromisoft.cxp.common.AbstractBaseDao;
import com.ejbappcromisoft.cxp.dao.Pgtbl_PPagosDao;

@SuppressWarnings("rawtypes")
public class Pgtbl_PPagosDaoImpl extends AbstractBaseDao implements Pgtbl_PPagosDao {
	public List<Pgtbl_ppagos> listAll(String iEliminado_fl, String... iEstado_fl) {
		return super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosDaoImpl.listAll", iEliminado_fl, Arrays.asList(iEstado_fl));
	}

	public List<Object> listAllPk(String iEliminado_fl, String... iEstado_fl) {
		return super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosDaoImpl.listAllPk", iEliminado_fl, Arrays.asList(iEstado_fl));
	}

	public long countTotalRecords(String iEliminado_fl, String... iEstado_fl) {
		return super.verifyNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosDaoImpl.countTotalRecords", iEliminado_fl, Arrays.asList(iEstado_fl));
	}

	@SuppressWarnings("unchecked")
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Pgtbl_ppagos save(Pgtbl_ppagos newObject) {
		return (Pgtbl_ppagos) super.store(newObject);
	}

	public int getConcurrencyById(int iPPago_id) {
		return super.verifyNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosDaoImpl.getConcurrencyById", iPPago_id);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public int updateByQuery(int iPPago_id, String sCreated_by, int iConcurrencia_id, String sPPago_desc, int iCuotas_num, int iPeriodicidad_num, int iTolerancia_num, int iVencido_num) {
		return super.executeByQueryName("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosDaoImpl.updateByQuery", iPPago_id, sCreated_by, iConcurrencia_id, sPPago_desc, iCuotas_num, iPeriodicidad_num,
		        iTolerancia_num, iVencido_num);
	}

	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public int deleteLogicalByQuery(int iPPago_id, String iEliminado_fl, String sCreated_by, int iConcurrencia_id) {
		return super.executeByQueryName("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosDaoImpl.deleteLogicalByQuery", iPPago_id, iEliminado_fl, sCreated_by, iConcurrencia_id);
	}

	public Pgtbl_ppagos getById(int iPPago_id) {
		return super.verifyNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosDaoImpl.getById", iPPago_id);
	}

	// Master Detail
	public List<Pgtbl_ppagos> listAllMD(Object mdPkValue, String iEliminado_fl, String... iEstado_fl) {
		return super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosDaoImpl.listAllMD", iEliminado_fl, Arrays.asList(iEstado_fl), mdPkValue);
	}

	public List<Object> listAllPkMD(Object mdPkValue, String iEliminado_fl, String... iEstado_fl) {
		return super.verifyListNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosDaoImpl.listAllPkMD", iEliminado_fl, Arrays.asList(iEstado_fl), mdPkValue);
	}

	public long countTotalRecordsMD(Object mdPkValue, String iEliminado_fl, String... iEstado_fl) {
		return super.verifyNamedQueryAll("com.ejbappcromisoft.cxp.dao.impls.Pgtbl_PPagosDaoImpl.countTotalRecordsMD", iEliminado_fl, Arrays.asList(iEstado_fl), mdPkValue);
	}
}
