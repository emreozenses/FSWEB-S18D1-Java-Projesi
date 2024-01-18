package com.workintech.FSWEBS18D1JavaProjesi.dao;

import com.workintech.FSWEBS18D1JavaProjesi.entity.BreadType;
import com.workintech.FSWEBS18D1JavaProjesi.entity.Burger;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public class BurgerDaoImpl implements BurgerDao{
    @Override
    public Burger save(Burger burger) {
        return null;
    }

    @Override
    public Optional<Burger> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public List<Burger> findAll() {
        return null;
    }

    @Override
    public Set<Burger> findByPrice(double price) {
        return null;
    }

    @Override
    public Set<Burger> findByBreadType(BreadType breadType) {
        return null;
    }

    @Override
    public List<Burger> findByContent(String content) {
        return null;
    }

    @Override
    public Burger update(Burger burger) {
        return null;
    }

    @Override
    public Burger remove(Long id) {
        return null;
    }
}
