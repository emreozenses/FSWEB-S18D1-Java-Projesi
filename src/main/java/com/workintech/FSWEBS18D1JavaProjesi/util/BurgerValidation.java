package com.workintech.FSWEBS18D1JavaProjesi.util;

import com.workintech.FSWEBS18D1JavaProjesi.exceptions.BurgerException;
import org.springframework.http.HttpStatus;

public class BurgerValidation {
    public static void checkName(String name){
        if(name == null || name.isEmpty()){
            throw new BurgerException("name is null or empty", HttpStatus.BAD_REQUEST);
        }

    }

}
