package com.smart_city.repositories.interfaces;

import com.smart_city.entities.Currency;

import java.util.List;

public interface ICurrencyRepository {
    boolean createCurrency(Currency Currencies);
    Currency getCurrency(int id);
    List<Currency> getAllCurrencies();
    boolean deleteCurrency(String nameCurrency);
}
