package com.ejbappcromisoft.cxp.dao;

import java.util.List;

import com.appmodbasico.common.domains.Pgtbl_ppagosxu;

public interface Pgtbl_PPagosxUDao {
    public List<Pgtbl_ppagosxu> listAll(String iEliminado_fl, String... iEstado_fl);

    public List<Object> listAllPk(String iEliminado_fl, String... iEstado_fl);

    public long countTotalRecords(String iEliminado_fl, String... iEstado_fl);

    public int updateByQuery(int lPPagoxU_id, String sCreated_by, int iConcurrencia_id, int lUsuario_id, int iPPago_id);

    public Pgtbl_ppagosxu save(Pgtbl_ppagosxu newObject);

    public int getConcurrencyById(int lPPagoxU_id);

    public int deleteLogicalByQuery(int lPPagoxU_id, String iEliminado_fl, String sCreated_by, int iConcurrencia_id);

    public Pgtbl_ppagosxu getById(int lPPagoxU_id);

    // Master Detail
    public List<Pgtbl_ppagosxu> listAllMD(Object mdPkValue, String iEliminado_fl, String... iEstado_fl);

    public List<Object> listAllPkMD(Object mdPkValue, String iEliminado_fl, String... iEstado_fl);

    public long countTotalRecordsMD(Object mdPkValue, String iEliminado_fl, String... iEstado_fl);
}
