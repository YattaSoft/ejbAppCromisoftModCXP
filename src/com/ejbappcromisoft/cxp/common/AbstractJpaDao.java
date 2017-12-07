package com.ejbappcromisoft.cxp.common;

import java.util.List;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.ejbappcromisoft.cxp.constants.CxPConstants;
import com.ejbappcromisoft.cxp.ejb.AppCromisoftModCxPEjb;
import com.ejbappcromisoft.cxp.utility.ConfigManager;

/**
 * @class:AbstractJpaDao.java
 * @author:Percy Soliz
 * @date:18-09-2011
 * @version:1.0
 */
public abstract class AbstractJpaDao {
    private static Logger LOGGER = ConfigManager.getLogger(AbstractJpaDao.class);

    public static EntityManager getEntityManager() {
        return AppCromisoftModCxPEjb.getEntityManager();
    }

    private int DEFAULT_FIRST_RESULT_INDEX = 0;
    private int DEFAULT_MAX_RESULTS = 0;

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <T extends Object> T store(T entity) {
        return getEntityManager().merge(entity);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remove(Object entity) {
        getEntityManager().remove(getEntityManager().merge(entity));
    }

    public void flush() {
        getEntityManager().flush();
    }

    @SuppressWarnings("unchecked")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <T extends Object> T findByQueryName(boolean cacheable, String queryName) {
        return (T) findByQueryName(cacheable, queryName, (Object[]) null);
    }

    @SuppressWarnings("unchecked")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    private <T extends Object> T findByQueryName(boolean cacheable, String queryName, Object... parameters) {
        Query query = createNamedQuery(cacheable, queryName, DEFAULT_FIRST_RESULT_INDEX, 1, parameters);
        return (T) query.getSingleResult();
    }

    @SuppressWarnings("unchecked")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    private <T extends Object> List<T> findListByQueryName(boolean cacheable, String queryName, Object... parameters) {
        return createNamedQuery(cacheable, queryName, DEFAULT_FIRST_RESULT_INDEX, DEFAULT_MAX_RESULTS, parameters).getResultList();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public int executeByQueryName(String queryName, Object... parameters) {
        Query query = getEntityManager().createNamedQuery(queryName);
        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                query.setParameter(i + 1, parameters[i]);
            }
        }
        return query.executeUpdate();
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Query createNamedQuery(boolean cacheable, String queryName, Integer firstResult, Integer maxResults) {
        return createNamedQuery(cacheable, queryName, firstResult, maxResults, (Object[]) null);
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public Query createNamedQuery(boolean cacheable, String queryName, Integer firstResult, Integer maxResults, Object... parameters) {
        Query query = getEntityManager().createNamedQuery(queryName);
        if (parameters != null) {
            for (int i = 0; i < parameters.length; i++) {
                query.setParameter(i + 1, parameters[i]);
            }
        }
        if (firstResult == null || firstResult < 0) {
            query.setFirstResult(DEFAULT_FIRST_RESULT_INDEX);
        } else {
            if (AppCromisoftModCxPEjb.pageNumber != 0) {
                query.setFirstResult((AppCromisoftModCxPEjb.pageNumber * CxPConstants.DATA_PAGINATION_MAX_RESULTS_DISPLAY) - CxPConstants.DATA_PAGINATION_MAX_RESULTS_DISPLAY);
                AppCromisoftModCxPEjb.pageNumber = 0;
                maxResults = CxPConstants.DATA_PAGINATION_MAX_RESULTS_DISPLAY;
            } else {
                query.setFirstResult(firstResult);
                maxResults = 0;
            }
        }
        if (maxResults != null && maxResults > 0) {
            query.setMaxResults(maxResults);
        }
        query.setHint("org.hibernate.cacheable", cacheable);
        return query;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <T extends Object> List<T> verifyListNamedQueryAll(String queryName, Object... parameters) {
        try {
            return findListByQueryName(false, queryName, parameters);
        } catch (Exception e) {
            ConfigManager.printExceptionNamedQuery(LOGGER, e, queryName, parameters);
            return null;
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <T extends Object> List<T> verifyListNamedQueryAllCacheable(String queryName, Object... parameters) {
        try {
            return findListByQueryName(true, queryName, parameters);
        } catch (Exception e) {
            ConfigManager.printExceptionNamedQuery(LOGGER, e, queryName, parameters);
            return null;
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <T extends Object> T verifyNamedQueryAll(String queryName, Object... parameters) {
        try {
            return findByQueryName(false, queryName, parameters);
        } catch (Exception e) {
            ConfigManager.printExceptionNamedQuery(LOGGER, e, queryName, parameters);
            return null;
        }
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <T extends Object> T verifyNamedQueryAllCacheable(String queryName, Object... parameters) {
        try {
            return findByQueryName(true, queryName, parameters);
        } catch (Exception e) {
            ConfigManager.printExceptionNamedQuery(LOGGER, e, queryName, parameters);
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <T extends Object> T verifyCreateQuery(String textQuery, Object... parameters) {
        try {
            Query query = getEntityManager().createQuery(textQuery);
            if (parameters != null) {
                for (int i = 0; i < parameters.length; i++) {
                    query.setParameter(i + 1, parameters[i]);
                }
            }
            return (T) query.getSingleResult();
        } catch (Exception e) {
            ConfigManager.printExceptionNamedQuery(LOGGER, e, textQuery, parameters);
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <T extends Object> List<T> verifyListCreateQuery(String textQuery, Object... parameters) {
        try {
            Query query = getEntityManager().createQuery(textQuery);
            if (parameters != null) {
                for (int i = 0; i < parameters.length; i++) {
                    query.setParameter(i + 1, parameters[i]);
                }
            }
            if (AppCromisoftModCxPEjb.pageNumber != 0) {
                query.setFirstResult((AppCromisoftModCxPEjb.pageNumber * CxPConstants.DATA_PAGINATION_MAX_RESULTS_DISPLAY) - CxPConstants.DATA_PAGINATION_MAX_RESULTS_DISPLAY);
                AppCromisoftModCxPEjb.pageNumber = 0;
                query.setMaxResults(CxPConstants.DATA_PAGINATION_MAX_RESULTS_DISPLAY);
            } else {
                query.setFirstResult(DEFAULT_FIRST_RESULT_INDEX);
            }
            return query.getResultList();
        } catch (Exception e) {
            ConfigManager.printException(LOGGER, e);
            return null;
        }
    }

    @SuppressWarnings("unchecked")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <T extends Object> List<T> verifyListCreateNativeQuery(String textQuery, Object... parameters) {
        try {
            Query query = getEntityManager().createNativeQuery(textQuery);
            if (parameters != null) {
                for (int i = 0; i < parameters.length; i++) {
                    query.setParameter(i + 1, parameters[i]);
                }
            }
            if (AppCromisoftModCxPEjb.pageNumber != 0) {
                query.setFirstResult((AppCromisoftModCxPEjb.pageNumber * CxPConstants.DATA_PAGINATION_MAX_RESULTS_DISPLAY) - CxPConstants.DATA_PAGINATION_MAX_RESULTS_DISPLAY);
                AppCromisoftModCxPEjb.pageNumber = 0;
                query.setMaxResults(CxPConstants.DATA_PAGINATION_MAX_RESULTS_DISPLAY);
            } else {
                query.setFirstResult(DEFAULT_FIRST_RESULT_INDEX);
            }
            return query.getResultList();
        } catch (Exception e) {
            ConfigManager.printException(LOGGER, e);
            return null;
        }
    }
}
