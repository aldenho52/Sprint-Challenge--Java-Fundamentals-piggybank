package com.lambdaschool.piggybank.piggybank.controllers;


import com.lambdaschool.piggybank.piggybank.models.Coin;
import com.lambdaschool.piggybank.piggybank.repositories.CoinRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CoinController
{
    @Autowired
    CoinRepository coinrepos;

    private List<Coin> findCoins(List<Coin> myList, CheckCoin tester)
    {
        List<Coin> tempList = new ArrayList<>();

        for (Coin c : myList)
        {
            if(tester.test(c))
            {
                tempList.add(c);
            }
        }
        return tempList;
    }

    //    http://localhost:2019/total
    @GetMapping(value = "/total", produces = "application/json")
    public ResponseEntity<?> listTotalCoins()
    {
        List<Coin> myList = new ArrayList<>();
        coinrepos.findAll().iterator().forEachRemaining(myList::add);
        for (Coin c : myList)
        {
            if (c.getQuantity() > 1) {
                System.out.println(c.getQuantity() + " " + c.getNameplural());
            } else {
                System.out.println(c.getQuantity() + " " + c.getName());
            }
        }
        double total = 0.0;
        for (Coin c : myList)
        {
            total += (c.getQuantity()*c.getValue());
        }

        System.out.println("The piggy bank holds " + total);

        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    //    http://localhost:2019/money/{amount}
    @PutMapping(value = "/money/{amount}", produces = "application/json")

}
