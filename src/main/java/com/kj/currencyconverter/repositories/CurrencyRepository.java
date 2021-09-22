package com.kj.currencyconverter.repositories;

import com.kj.currencyconverter.models.Currency;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrencyRepository extends CrudRepository<Currency,String> {
}
