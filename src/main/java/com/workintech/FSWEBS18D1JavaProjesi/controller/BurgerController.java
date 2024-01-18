package com.workintech.FSWEBS18D1JavaProjesi.controller;


import com.workintech.FSWEBS18D1JavaProjesi.dao.BurgerDao;
import com.workintech.FSWEBS18D1JavaProjesi.entity.BreadType;
import com.workintech.FSWEBS18D1JavaProjesi.entity.Burger;
import com.workintech.FSWEBS18D1JavaProjesi.exceptions.BurgerException;
import com.workintech.FSWEBS18D1JavaProjesi.util.BurgerValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/workintech/burgers")
public class BurgerController {

    private BurgerDao burgerDao;

    @Autowired
    public BurgerController(BurgerDao burgerDao) {
        this.burgerDao = burgerDao;
    }

    @GetMapping("/")
    public List<Burger> findAll(){
        return burgerDao.findAll();
    }

    @GetMapping("/{id}")
    public Burger findById(@PathVariable Long id){
        Burger burger = burgerDao.findById(id);
        if(burger != null){
            return burger;
        }
        throw new BurgerException("Burger with given id is not exist"+id, HttpStatus.NOT_FOUND);

    }
    @PostMapping("/")
    public Burger save(@RequestBody Burger burger){
        BurgerValidation.checkName(burger.getName());
        Burger savedBurger = burgerDao.save(burger);
        return savedBurger;

    }

    @PutMapping("/{id}")
    public Burger update (@PathVariable Long id,@RequestBody Burger burger){
        Burger foundBurger = burgerDao.findById(id);
        if(foundBurger != null){
            return burgerDao.update(burger);
        }
        throw new BurgerException("Burger with given id is not exist.It can't be updated"+id,HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public Burger delete(@PathVariable Long id){
        Burger deletedBurger = burgerDao.remove(id);
        return deletedBurger;
    }

    @GetMapping("/findByPrice/{price}")
    public List<Burger> findByPrice(@PathVariable double price){
        return burgerDao.findByPrice(price);
    }

    @GetMapping("/findByBreadType/{breadType}")
    public List<Burger> findByBreadType(@PathVariable BreadType breadType){
        return burgerDao.findByBreadType(breadType);
    }

    @GetMapping("/findByContent/{content}")
    public List<Burger> findByContent(@PathVariable String content){
        return burgerDao.findByContent(content);
    }















}
