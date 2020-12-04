package com.lambdaschool.piggybank.piggybank.repositories;

import com.lambdaschool.piggybank.piggybank.models.Coin;
import org.springframework.data.repository.CrudRepository;

public interface CoinRepository extends CrudRepository<Coin, Long>
{
}
