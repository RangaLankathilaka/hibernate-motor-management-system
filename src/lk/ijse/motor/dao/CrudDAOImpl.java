package lk.ijse.motor.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public abstract class CrudDAOImpl<T,ID> implements CrudDAO<T,ID> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<T> entity;

    public CrudDAOImpl() {
      //  entity = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        entity = (Class<T>)(((ParameterizedType)this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
    }
    public Session getSession(){
        return sessionFactory.getCurrentSession();
    }

    @Override
    public void save(T entity) throws Exception {
     // session.persist(entity);
        getSession().persist(entity);
    }

    @Override
    public void update(T entity) throws Exception {
        getSession().persist(entity);
    }

    @Override
    public void delete(ID id) throws Exception {
        T t = getSession().find(entity, id);
        getSession().remove(t);
    }

    @Override
    public T find(ID id) throws Exception {
       // return session.find(entity,id);
        return getSession().find(entity, id);
    }

    @Override
    public List<T> getAll() throws Exception {
        //return session.createQuery("FROM"+entity.getName()).list();
        return getSession().createQuery("FROM "+ entity.getName()).list();
    }
}
