package com.workintech.FSWEBS18D1JavaProjesi.dao;

import com.workintech.FSWEBS18D1JavaProjesi.entity.BreadType;
import com.workintech.FSWEBS18D1JavaProjesi.entity.Burger;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BurgerDao {

    Burger save(Burger burger);
    Optional<Burger> findById(Long id);
    List<Burger> findAll();
    Set<Burger> findByPrice(double price);
    Set<Burger> findByBreadType(BreadType breadType);
    List<Burger> findByContent(String content);
    Burger update(Burger burger);
    Burger remove(Long id);


}
