package com.colo.dao;

import com.colo.data.items.Item;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by rehacek on 9/1/2017.
 */
@Repository
@Transactional
public class DaoImpl {

//    @Autowired
//    private SessionFactory sessionFactory;

    @PersistenceContext
    private EntityManager entityManger;

//    private Session getSession() {
//        return sessionFactory.getCurrentSession();
//    }

    public List<Item> getItems(int offset, int limit) {
        return entityManger
                .createQuery("from Item")
                .setFirstResult(offset)
                .setMaxResults(limit)
                .getResultList();

//        return null;
    }

//    public Item getByCode(String code) {
//        return (Item) getSession().createQuery("from Item where code=:code")
//                .setParameter(code, "code").uniqueResult();
//    }
//
//    public Item getById(String id) {
//        return (Item) getSession().createQuery("from Item where id=:id")
//                .setParameter(id, "id").uniqueResult();
//    }

}
