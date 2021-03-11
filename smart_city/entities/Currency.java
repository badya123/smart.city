package com.smart_city.entities;

public class Currency {
    private int id;
    private String nameCurrency1;
    private double currency1;
    private String nameCurrency2;
    private double currency2;
    private double growthCoefficient;

    public Currency() {

    }

    public Currency(String nameCurrency1, double currency1, String nameCurrency2, double currency2, double growthCoefficient){
        this.nameCurrency1 = nameCurrency1;
        this.currency1 = currency1;
        this.nameCurrency2 = nameCurrency2;
        this.currency2 = currency2;
        this.growthCoefficient = growthCoefficient;
    }

    public Currency(int id, String nameCurrency1, double currency1, String nameCurrency2, double currency2, double growthCoefficient){
        this.nameCurrency1 = nameCurrency1;
        this.currency1 = currency1;
        this.nameCurrency2 = nameCurrency2;
        this.currency2 = currency2;
        this.growthCoefficient = growthCoefficient;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setCurrency1(double currency1) {
        this.currency1 = currency1;
    }

    public void setCurrency2(double currency2) {
        this.currency2 = currency2;
    }

    public void setGrowthCoefficient(double growthCoefficient) {
        this.growthCoefficient = growthCoefficient;
    }

    public void setNameCurrency1(String nameCurrency1) {
        this.nameCurrency1 = nameCurrency1;
    }

    public void setNameCurrency2(String nameCurrency2) {
        this.nameCurrency2 = nameCurrency2;
    }

    public int getId() {
        return id;
    }

    public double getCurrency1() {
        return currency1;
    }

    public double getCurrency2() {
        return currency2;
    }

    public double getGrowthCoefficient() {
        return growthCoefficient;
    }

    public String getNameCurrency1() {
        return nameCurrency1;
    }

    public String getNameCurrency2() {
        return nameCurrency2;
    }

    @Override
    public String toString() {
        return
                "id=" + id +
                ", nameCurrency1='" + nameCurrency1 + '\'' +
                ", currency1=" + currency1 +
                ", nameCurrency2='" + nameCurrency2 + '\'' +
                ", currency2=" + currency2 +
                ", growthCoefficient=" + growthCoefficient + '\n';
    }
}
