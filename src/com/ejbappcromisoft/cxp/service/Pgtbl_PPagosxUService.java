package com.ejbappcromisoft.cxp.service;

import java.util.List;

import com.appmodbasico.common.domains.Pgtbl_ppagosxu;

public interface Pgtbl_PPagosxUService {
	public List<Pgtbl_ppagosxu> listAllPgtbl_PPagosxU(String... iEstado_fl);

	public List<Object> listAllPgtbl_PPagosxUPk(String... iEstado_fl);

	public long totalRecordsPgtbl_PPagosxU(String... iEstado_fl);

	public boolean updatePgtbl_PPagosxU(int lPPagoxU_id, String sCreated_by, int iConcurrencia_id, int lUsuario_id, int iPPago_id);

	public Pgtbl_ppagosxu insertPgtbl_PPagosxU(String sCreated_by, int lUsuario_id, int iPPago_id);

	public boolean deletePgtbl_PPagosxU(int lPPagoxU_id, String sCreated_by, int iConcurrencia_id);

	public Pgtbl_ppagosxu getByIdPgtbl_PPagosxU(int lPPagoxU_id);

	// Master Detail
	public List<Pgtbl_ppagosxu> listAllPgtbl_PPagosxUMD(Object mdPkValue, String... iEstado_fl);

	public List<Object> listAllPgtbl_PPagosxUPkMD(Object mdPkValue, String... iEstado_fl);

	public long totalRecordsPgtbl_PPagosxUMD(Object mdPkValue, String... iEstado_fl);
}
