package com.ejbappcromisoft.cxp.dao;

import java.util.List;

import com.appmodbasico.common.domains.Pgtbl_ppagos;

public interface Pgtbl_PPagosDao {
	public List<Pgtbl_ppagos> listAll(String iEliminado_fl, String... iEstado_fl);

	public List<Object> listAllPk(String iEliminado_fl, String... iEstado_fl);

	public long countTotalRecords(String iEliminado_fl, String... iEstado_fl);

	public int updateByQuery(int iPPago_id, String sCreated_by, int iConcurrencia_id, String sPPago_desc, int iCuotas_num, int iPeriodicidad_num, int iTolerancia_num, int iVencido_num);

	public Pgtbl_ppagos save(Pgtbl_ppagos newObject);

	public int getConcurrencyById(int iPPago_id);

	public int deleteLogicalByQuery(int iPPago_id, String iEliminado_fl, String sCreated_by, int iConcurrencia_id);

	public Pgtbl_ppagos getById(int iPPago_id);

	// Master Detail
	public List<Pgtbl_ppagos> listAllMD(Object mdPkValue, String iEliminado_fl, String... iEstado_fl);

	public List<Object> listAllPkMD(Object mdPkValue, String iEliminado_fl, String... iEstado_fl);

	public long countTotalRecordsMD(Object mdPkValue, String iEliminado_fl, String... iEstado_fl);
}
