package com.ejbappcromisoft.cxp.ejb;

import java.util.List;

import javax.ejb.Remote;

import com.appmodbasico.common.domains.Pgtbl_ppagos;
import com.appmodbasico.common.domains.Pgtbl_ppagosxu;

@Remote
public interface AppCromisoftModCxPEjbRemote {
    public void setPageNumber(int pageNumber);

    public int getDATA_PAGINATION_MAX_RESULTS_DISPLAY();

    public void setDATA_PAGINATION_MAX_RESULTS_DISPLAY(int dATA_PAGINATION_MAX_RESULTS_DISPLAY);

    public List<Object[]> listAllPetbl_PersonasWithName(String... iEstado_fl);

    public List<Object[]> listPetbl_PersonasByGroupWithName(int grupoId, String... iEstado_fl);

    // Pgtbl_PPagos
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

    // End Pgtbl_PPagos
    // Pgtbl_PPagosxU
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
    // End Pgtbl_PPagosxU
}
