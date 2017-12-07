package com.ejbappcromisoft.cxp.service;

import java.util.List;

import com.appmodbasico.common.domains.Pgtbl_ppagos;

public interface Pgtbl_PPagosService {
	public List<Pgtbl_ppagos> listAllPgtbl_PPagos(String... iEstado_fl);

	public List<Object> listAllPgtbl_PPagosPk(String... iEstado_fl);

	public long totalRecordsPgtbl_PPagos(String... iEstado_fl);

	public boolean updatePgtbl_PPagos(int iPPago_id, String sCreated_by, int iConcurrencia_id, String sPPago_desc, int iCuotas_num, int iPeriodicidad_num, int iTolerancia_num, int iVencido_num);

	public Pgtbl_ppagos insertPgtbl_PPagos(String sCreated_by, String sPPago_desc, int iCuotas_num, int iPeriodicidad_num, int iTolerancia_num, int iVencido_num);

	public boolean deletePgtbl_PPagos(int iPPago_id, String sCreated_by, int iConcurrencia_id);

	public Pgtbl_ppagos getByIdPgtbl_PPagos(int iPPago_id);

	// Master Detail
	public List<Pgtbl_ppagos> listAllPgtbl_PPagosMD(Object mdPkValue, String... iEstado_fl);

	public List<Object> listAllPgtbl_PPagosPkMD(Object mdPkValue, String... iEstado_fl);

	public long totalRecordsPgtbl_PPagosMD(Object mdPkValue, String... iEstado_fl);
}
