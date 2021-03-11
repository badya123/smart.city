package com.smart_city.controllers;

import com.smart_city.entities.Currency;
import com.smart_city.repositories.interfaces.ICurrencyRepository;

import java.util.List;

public class CurrencyController {
    private final ICurrencyRepository repo1;

    public CurrencyController(ICurrencyRepository repo1) {
        this.repo1 = repo1;
    }

    public String createCurrency(String nameCurrency1, double currency1, String nameCurrency2, double currency2, double growthCoefficient){
        Currency currencies = new Currency(nameCurrency1, currency1, nameCurrency2, currency2, growthCoefficient);

        boolean created = repo1.createCurrency(currencies);
        return (created ? "Currency was created" : "Currency was not created!");
    }

    public String getCurrency(int id) {
        Currency currencies =repo1.getCurrency(id);
        return (currencies == null? "Currency was not found" : currencies.toString());
    }

    public String getAllCurrencies() {
        List<Currency> currencies = repo1.getAllCurrencies();
        return currencies.toString();
    }

    public boolean deleteCurrency(String currencyName){
        return repo1.deleteCurrency(currencyName);
    }
}
