package com.ejbappcromisoft.cxp.common;

import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;

import org.apache.log4j.Logger;

import com.ejbappcromisoft.cxp.utility.ConfigManager;

public abstract class AbstractBaseDao<T extends Object> extends AbstractJpaDao {
    private static final Logger LOGGER = ConfigManager.getLogger(AbstractBaseDao.class);

    @SuppressWarnings("hiding")
    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public <T extends Object> T store(final T entity) {
        try {
            T returnValue = null;
            returnValue = (T) super.store(entity);
            return returnValue;
        } catch (final Exception e) {
            ConfigManager.printException(LOGGER, e);
        }
        return null;
    }

    @TransactionAttribute(TransactionAttributeType.REQUIRED)
    public void remove(final Object entity) {
        try {
            super.remove(entity);
        } catch (final Exception e) {
            ConfigManager.printException(LOGGER, e);
        }
    }
}
