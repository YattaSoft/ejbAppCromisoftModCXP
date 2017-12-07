package com.ejbappcromisoft.cxp.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionManagement;
import javax.ejb.TransactionManagementType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.appmodbasico.common.domains.Pgtbl_ppagos;
import com.appmodbasico.common.domains.Pgtbl_ppagosxu;
import com.ejbappcromisoft.cxp.constants.CxPConstants;
import com.ejbappcromisoft.cxp.service.Petbl_PersonasService;
import com.ejbappcromisoft.cxp.service.Pgtbl_PPagosService;
import com.ejbappcromisoft.cxp.service.Pgtbl_PPagosxUService;
import com.ejbappcromisoft.cxp.service.impls.Petbl_PersonasServiceImpl;
import com.ejbappcromisoft.cxp.service.impls.Pgtbl_PPagosServiceImpl;
import com.ejbappcromisoft.cxp.service.impls.Pgtbl_PPagosxUServiceImpl;

//Reserved For Imports
@Stateless
@TransactionManagement(TransactionManagementType.CONTAINER)
public class AppCromisoftModCxPEjb implements AppCromisoftModCxPEjbRemote {
    @PersistenceContext(unitName = CxPConstants.PERSISTENCE_UNIT_NAME)
    private static EntityManager entityManager;
    public static int pageNumber = 0;

    public static EntityManager getEntityManager() {
        return entityManager;
    }

    public void setPageNumber(int pageNumber) {
        this.pageNumber = pageNumber;
    }

    public int getDATA_PAGINATION_MAX_RESULTS_DISPLAY() {
        return CxPConstants.DATA_PAGINATION_MAX_RESULTS_DISPLAY;
    }

    public void setDATA_PAGINATION_MAX_RESULTS_DISPLAY(int dATA_PAGINATION_MAX_RESULTS_DISPLAY) {
        CxPConstants.DATA_PAGINATION_MAX_RESULTS_DISPLAY = dATA_PAGINATION_MAX_RESULTS_DISPLAY;
    }

    private Petbl_PersonasService servicePetbl_Personas = new Petbl_PersonasServiceImpl();

    public List<Object[]> listAllPetbl_PersonasWithName(String... iEstado_fl) {
        return servicePetbl_Personas.listAllPetbl_PersonasWithName(iEstado_fl);
    }
    
    public List<Object[]> listPetbl_PersonasByGroupWithName(int grupoId,String... iEstado_fl) {
        return servicePetbl_Personas.listPetbl_PersonasByGroupWithName(grupoId,iEstado_fl);
    }

    // Pgtbl_PPagos
    private Pgtbl_PPagosService servicePgtbl_PPagos = new Pgtbl_PPagosServiceImpl();

    public List<Pgtbl_ppagos> listAllPgtbl_PPagos(String... iEstado_fl) {
        return servicePgtbl_PPagos.listAllPgtbl_PPagos(iEstado_fl);
    }

    public List<Object> listAllPgtbl_PPagosPk(String... iEstado_fl) {
        return servicePgtbl_PPagos.listAllPgtbl_PPagosPk(iEstado_fl);
    }

    public long totalRecordsPgtbl_PPagos(String... iEstado_fl) {
        return servicePgtbl_PPagos.totalRecordsPgtbl_PPagos(iEstado_fl);
    }

    public Pgtbl_ppagos insertPgtbl_PPagos(String sCreated_by, String sPPago_desc, int iCuotas_num, int iPeriodicidad_num, int iTolerancia_num, int iVencido_num) {
        return servicePgtbl_PPagos.insertPgtbl_PPagos(sCreated_by, sPPago_desc, iCuotas_num, iPeriodicidad_num, iTolerancia_num, iVencido_num);
    }

    public boolean updatePgtbl_PPagos(int iPPago_id, String sCreated_by, int iConcurrencia_id, String sPPago_desc, int iCuotas_num, int iPeriodicidad_num, int iTolerancia_num, int iVencido_num) {
        return servicePgtbl_PPagos.updatePgtbl_PPagos(iPPago_id, sCreated_by, iConcurrencia_id, sPPago_desc, iCuotas_num, iPeriodicidad_num, iTolerancia_num, iVencido_num);
    }

    public boolean deletePgtbl_PPagos(int iPPago_id, String sCreated_by, int iConcurrencia_id) {
        return servicePgtbl_PPagos.deletePgtbl_PPagos(iPPago_id, sCreated_by, iConcurrencia_id);
    }

    public Pgtbl_ppagos getByIdPgtbl_PPagos(int iPPago_id) {
        return servicePgtbl_PPagos.getByIdPgtbl_PPagos(iPPago_id);
    }

    // Master Detail
    public List<Pgtbl_ppagos> listAllPgtbl_PPagosMD(Object mdPkValue, String... iEstado_fl) {
        return servicePgtbl_PPagos.listAllPgtbl_PPagosMD(mdPkValue, iEstado_fl);
    }

    public List<Object> listAllPgtbl_PPagosPkMD(Object mdPkValue, String... iEstado_fl) {
        return servicePgtbl_PPagos.listAllPgtbl_PPagosPkMD(mdPkValue, iEstado_fl);
    }

    public long totalRecordsPgtbl_PPagosMD(Object mdPkValue, String... iEstado_fl) {
        return servicePgtbl_PPagos.totalRecordsPgtbl_PPagosMD(mdPkValue, iEstado_fl);
    }

    // End Pgtbl_PPagos
    // Pgtbl_PPagosxU
    private Pgtbl_PPagosxUService servicePgtbl_PPagosxU = new Pgtbl_PPagosxUServiceImpl();

    public List<Pgtbl_ppagosxu> listAllPgtbl_PPagosxU(String... iEstado_fl) {
        return servicePgtbl_PPagosxU.listAllPgtbl_PPagosxU(iEstado_fl);
    }

    public List<Object> listAllPgtbl_PPagosxUPk(String... iEstado_fl) {
        return servicePgtbl_PPagosxU.listAllPgtbl_PPagosxUPk(iEstado_fl);
    }

    public long totalRecordsPgtbl_PPagosxU(String... iEstado_fl) {
        return servicePgtbl_PPagosxU.totalRecordsPgtbl_PPagosxU(iEstado_fl);
    }

    public Pgtbl_ppagosxu insertPgtbl_PPagosxU(String sCreated_by, int lUsuario_id, int iPPago_id) {
        return servicePgtbl_PPagosxU.insertPgtbl_PPagosxU(sCreated_by, lUsuario_id, iPPago_id);
    }

    public boolean updatePgtbl_PPagosxU(int lPPagoxU_id, String sCreated_by, int iConcurrencia_id, int lUsuario_id, int iPPago_id) {
        return servicePgtbl_PPagosxU.updatePgtbl_PPagosxU(lPPagoxU_id, sCreated_by, iConcurrencia_id, lUsuario_id, iPPago_id);
    }

    public boolean deletePgtbl_PPagosxU(int lPPagoxU_id, String sCreated_by, int iConcurrencia_id) {
        return servicePgtbl_PPagosxU.deletePgtbl_PPagosxU(lPPagoxU_id, sCreated_by, iConcurrencia_id);
    }

    public Pgtbl_ppagosxu getByIdPgtbl_PPagosxU(int lPPagoxU_id) {
        return servicePgtbl_PPagosxU.getByIdPgtbl_PPagosxU(lPPagoxU_id);
    }

    // Master Detail
    public List<Pgtbl_ppagosxu> listAllPgtbl_PPagosxUMD(Object mdPkValue, String... iEstado_fl) {
        return servicePgtbl_PPagosxU.listAllPgtbl_PPagosxUMD(mdPkValue, iEstado_fl);
    }

    public List<Object> listAllPgtbl_PPagosxUPkMD(Object mdPkValue, String... iEstado_fl) {
        return servicePgtbl_PPagosxU.listAllPgtbl_PPagosxUPkMD(mdPkValue, iEstado_fl);
    }

    public long totalRecordsPgtbl_PPagosxUMD(Object mdPkValue, String... iEstado_fl) {
        return servicePgtbl_PPagosxU.totalRecordsPgtbl_PPagosxUMD(mdPkValue, iEstado_fl);
    }
    // End Pgtbl_PPagosxU
}
