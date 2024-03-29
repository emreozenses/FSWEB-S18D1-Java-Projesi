package com.workintech.FSWEBS18D1JavaProjesi.dao;

import com.workintech.FSWEBS18D1JavaProjesi.entity.BreadType;
import com.workintech.FSWEBS18D1JavaProjesi.entity.Burger;

import java.util.List;
import java.util.Optional;
import java.util.Set;

public interface BurgerDao {

    Burger save(Burger burger);
    Burger findById(Long id);
    List<Burger> findAll();
    List<Burger> findByPrice(double price);
    List<Burger> findByBreadType(BreadType breadType);
    List<Burger> findByContent(String content);
    Burger update(Burger burger);
    Burger remove(Long id);


}
