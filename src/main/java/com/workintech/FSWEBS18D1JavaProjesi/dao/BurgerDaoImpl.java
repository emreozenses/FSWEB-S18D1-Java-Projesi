package com.workintech.FSWEBS18D1JavaProjesi.dao;

import com.workintech.FSWEBS18D1JavaProjesi.entity.BreadType;
import com.workintech.FSWEBS18D1JavaProjesi.entity.Burger;
import com.workintech.FSWEBS18D1JavaProjesi.exceptions.BurgerException;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

@Repository
public class BurgerDaoImpl implements BurgerDao{

    private EntityManager entityManager;

    @Autowired
    public BurgerDaoImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Transactional
    @Override
    public Burger save(Burger burger) {
        entityManager.persist(burger);
        return burger;
    }

    @Override
    public Burger findById(Long id) {
       return entityManager.find(Burger.class,id);

    }

    @Override
    public List<Burger> findAll() {
       TypedQuery<Burger> query =  entityManager.createQuery("SELECT b FROM Burger b", Burger.class);
       return query.getResultList();
    }

    @Override
    public List<Burger> findByPrice(double price) {
        TypedQuery<Burger> query = entityManager
                .createQuery("SELECT b FROM Burger b WHERE b.price > :price ORDER BY b.price desc", Burger.class);
        query.setParameter("price",price);
        return query.getResultList();
    }

    @Override
    public List<Burger> findByBreadType(BreadType breadType) {
        TypedQuery<Burger> query = entityManager
                .createQuery("SELECT b FROM Burger b WHERE b.breadType = :breadType ORDER BY b.name", Burger.class);
        query.setParameter("breadType", breadType);
        return query.getResultList();
    }


    @Override
    public List<Burger> findByContent(String content) {
        TypedQuery<Burger> query = entityManager
                .createQuery("SELECT b FROM Burger b WHERE b.contents LIKE CONCAT('%',:content,'%') ORDER BY b.name desc", Burger.class);
        query.setParameter("content",content);
        return query.getResultList();
    }

    @Transactional
    @Override
    public Burger update(Burger burger) {
        return entityManager.merge(burger);
    }

    @Transactional
    @Override
    public Burger remove(Long id) {
        Burger burger = findById(id);
        if(burger != null){
            entityManager.remove(burger);
            return burger;
        }
        throw new BurgerException("Burger with given id is not exist"+id, HttpStatus.NOT_FOUND);
    }
}
