/******************************************************************************
 *                         Philips Medical Systems
 *               © 2016 Koninklijke Philips Electronics N.V.
 *
 *  All rights are reserved. Reproduction in whole or in part is
 *  prohibited without the written consent of the copyright owner.
 *****************************************************************************/

package com.philips.h2h.bama.platform.core.dal.dao;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.NonUniqueResultException;
import org.hibernate.Session;
import org.hibernate.criterion.CriteriaSpecification;
import org.hibernate.criterion.Criterion;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projection;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.internal.CriteriaImpl;
import org.hibernate.transform.ResultTransformer;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.hibernate4.HibernateCallback;
import org.springframework.util.Assert;

import com.philips.h2h.bama.platform.core.orm.hibernate.LibraHibernateDaoSupport;
import com.philips.h2h.bama.platform.core.query.pagination.Pager;
import com.philips.h2h.bama.platform.core.util.ReflectionUtil;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * BaseDao implementation based on HibernateDaoSupport.
 */
public class BaseDaoImpl<T, PK extends Serializable> extends LibraHibernateDaoSupport implements BaseDao <T, PK> {

    private Class <T> entityClass;

    public BaseDaoImpl() {
        Class c = getClass();
        Type type = c.getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            Type[] parameterizedType = ((ParameterizedType) type).getActualTypeArguments();
            this.entityClass = (Class <T>) parameterizedType[0];
        }
    }

    protected T uniqueResult(List <T> list) throws NonUniqueResultException {
        int size = list.size();
        if (size == 0)
            return null;
        T first = list.get(0);
        for (int i = 1; i < size; i++) {
            if (list.get(i) != first) {
                throw new NonUniqueResultException(list.size());
            }
        }
        return first;
    }

    @Override
    public T get(Class <T> entityClass, PK id) throws DataAccessException {
        return getHibernateTemplate().get(entityClass, id);
    }

    @Override
    public T load(Class <T> entityClass, PK id) throws DataAccessException {
        return getHibernateTemplate().load(entityClass, id);
    }

    @Override
    public List <T> loadAll(Class <T> entityClass) throws DataAccessException {
        return getHibernateTemplate().loadAll(entityClass);
    }

    @Override
    public void load(Object entity, PK id) throws DataAccessException {
        getHibernateTemplate().load(entity, id);
    }

    @Override
    public void refresh(Object entity) throws DataAccessException {
        getHibernateTemplate().refresh(entity);
    }

    @Override
    public PK save(Object entity) throws DataAccessException {
        return (PK) getHibernateTemplate().save(entity);
    }

    @Override
    public void update(Object entity) throws DataAccessException {
        getHibernateTemplate().update(entity);
    }

    @Override
    public void persist(Object entity) throws DataAccessException {
        getHibernateTemplate().persist(entity);
    }

    @Override
    public T merge(T entity) throws DataAccessException {
        return getHibernateTemplate().merge(entity);
    }

    @Override
    public void delete(Object entity) throws DataAccessException {
        getHibernateTemplate().delete(entity);
    }

    @Override
    public void deleteAll(Collection <?> entities) throws DataAccessException {
        getHibernateTemplate().deleteAll(entities);
    }

    @Override
    public void flush() throws DataAccessException {
        getHibernateTemplate().flush();
    }

    @Override
    public void clear() throws DataAccessException {
        getHibernateTemplate().clear();
    }

    @Override
    public List <?> find(String queryString, Object... values) throws DataAccessException {
        return getHibernateTemplate().find(queryString, values);
    }

    @Override
    public List <?> findByNamedParam(String queryString, String paramName, Object value) throws DataAccessException {
        return getHibernateTemplate().findByNamedParam(queryString, paramName, value);
    }

    @Override
    public List <?> findByNamedParam(String queryString, String[] paramNames, Object[] values)
            throws DataAccessException {
        return getHibernateTemplate().findByNamedParam(queryString, paramNames, values);
    }

    @Override
    public List <?> findByCriteria(DetachedCriteria criteria) throws DataAccessException {
        return getHibernateTemplate().findByCriteria(criteria);
    }

    @Override
    public List <?> findByCriteria(DetachedCriteria criteria, int firstResult, int maxResults)
            throws DataAccessException {
        return getHibernateTemplate().findByCriteria(criteria, firstResult, maxResults);
    }

    // TODO below page methods to be debug later
    @Override
    public Pager findPager(final Pager pager) {
        return getHibernateTemplate().executeWithNativeSession(new HibernateCallback <Pager>() {
            @Override
            @SuppressWarnings("unchecked")
            public Pager doInHibernate(Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(entityClass);
                return findPager(pager, criteria);
            }
        });
    }

    @Override
    public Pager findPager(final Pager pager, final Criterion... criterions) {
        return getHibernateTemplate().executeWithNativeSession(new HibernateCallback <Pager>() {
            @Override
            @SuppressWarnings("unchecked")
            public Pager doInHibernate(Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(entityClass);
                for (Criterion criterion : criterions) {
                    criteria.add(criterion);
                }
                return findPager(pager, criteria);
            }
        });
    }

    @Override
    public Pager findPager(final Pager pager, final Order... orders) {
        return getHibernateTemplate().executeWithNativeSession(new HibernateCallback <Pager>() {
            @Override
            @SuppressWarnings("unchecked")
            public Pager doInHibernate(Session session) throws HibernateException {
                Criteria criteria = session.createCriteria(entityClass);
                for (Order order : orders) {
                    criteria.addOrder(order);
                }
                return findPager(pager, criteria);
            }
        });
    }

    @Override
    public Pager findPager(Pager pager, Criteria criteria) {
        Assert.notNull(pager, "pager is required");
        Assert.notNull(criteria, "criteria is required");

        Integer pageNumber = pager.getPageNumber();
        Integer pageSize = pager.getPageSize();
        String searchBy = pager.getSearchBy();
        String keyword = pager.getKeyword();
        String orderBy = pager.getOrderBy();
        Pager.Order order = pager.getOrder();

        if (StringUtils.isNotEmpty(searchBy) && StringUtils.isNotEmpty(keyword)) {
            if (searchBy.contains(".")) {
                String alias = StringUtils.substringBefore(searchBy, ".");
                criteria.createAlias(alias, alias);
            }
            criteria.add(Restrictions.like(searchBy, "%" + keyword + "%"));
        }

        pager.setTotalCount(criteriaResultTotalCount(criteria));

        if (StringUtils.isNotEmpty(orderBy) && order != null) {
            if (order == Pager.Order.ASC) {
                criteria.addOrder(Order.asc(orderBy));
            } else {
                criteria.addOrder(Order.desc(orderBy));
            }
        }

        // TODO to be identified below usage in development
        // ClassMetadata classMetadata =
        // sessionFactory.getClassMetadata(entityClass);
        // if (!StringUtils.equals(orderBy, ORDER_LIST_PROPERTY_NAME) &&
        // ArrayUtils.contains(classMetadata.getPropertyNames(),
        // ORDER_LIST_PROPERTY_NAME)) {
        // criteria.addOrder(Order.asc(ORDER_LIST_PROPERTY_NAME));
        // criteria.addOrder(Order.desc(CREATE_DATE_PROPERTY_NAME));
        // if (StringUtils.isEmpty(orderBy) || order == null) {
        // pager.setOrderBy(ORDER_LIST_PROPERTY_NAME);
        // pager.setOrder(Pager.Order.asc);
        // }
        // } else if (!StringUtils.equals(orderBy, CREATE_DATE_PROPERTY_NAME) &&
        // ArrayUtils.contains(classMetadata.getPropertyNames(),
        // CREATE_DATE_PROPERTY_NAME)) {
        // criteria.addOrder(Order.desc(CREATE_DATE_PROPERTY_NAME));
        // if (StringUtils.isEmpty(orderBy) || order == null) {
        // pager.setOrderBy(CREATE_DATE_PROPERTY_NAME);
        // pager.setOrder(Pager.Order.desc);
        // }
        // }

        criteria.setFirstResult((pageNumber - 1) * pageSize);
        criteria.setMaxResults(pageSize);

        pager.setResult(criteria.list());
        return pager;
    }

    private int criteriaResultTotalCount(Criteria criteria) {
        Assert.notNull(criteria, "criteria is required");

        int criteriaResultTotalCount = 0;
        try {
            // TODO Below impl to be refined, it's a bit ugly
            CriteriaImpl criteriaImpl = (CriteriaImpl) criteria;

            // ? useless get here and set later for projection and
            // resultTransformer
            Projection projection = criteriaImpl.getProjection();
            ResultTransformer resultTransformer = criteriaImpl.getResultTransformer();

            // Remove order criteria in criteria for count total results
            List <CriteriaImpl.OrderEntry> orderEntries = (List) ReflectionUtil.getFieldValue(criteriaImpl,
                    "orderEntries");
            ReflectionUtil.setFieldValue(criteriaImpl, "orderEntries", new ArrayList());
            // get total count of search results
            Integer totalCount = ((Long) criteriaImpl.setProjection(Projections.rowCount()).uniqueResult()).intValue();
            if (totalCount != null) {
                criteriaResultTotalCount = totalCount;
            }

            // set back the projection and resultTransformer
            criteriaImpl.setProjection(projection);
            if (projection == null) {
                criteriaImpl.setResultTransformer(CriteriaSpecification.ROOT_ENTITY);
            }
            if (resultTransformer != null) {
                criteriaImpl.setResultTransformer(resultTransformer);
            }
            // set back the order criteria
            ReflectionUtil.setFieldValue(criteriaImpl, "orderEntries", orderEntries);
        } catch (Exception e) {

        }
        return criteriaResultTotalCount;
    }
}
