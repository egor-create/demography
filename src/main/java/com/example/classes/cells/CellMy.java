package com.example.classes.cells;

// import java.util.HashMap;

public class CellMy {

    private int strata;
    private int age;

    private int money; // скок заработало клетка
    private int population; // изначально не ноль, а взят из экселя, а потом перезаписываем поле

    private int tempPopulation = 0; // временное поле для расчета популяции

    // private HashMap<Good, Integer> goodsConsumption; // Пока что без этого

    private CellMy upNeighbour;
    private CellMy directNeighbour;
    private CellMy downNeighbour;

    public CellMy() {
    }

    public CellMy(int strata, int age, int population) {
        this.strata = strata;
        this.age = age;
        this.population = population;
    }

    public void setPopulationFromTemp() {
        this.population = this.tempPopulation;
        this.tempPopulation = 0;
    }

    public int getTempPopulation() {
        return this.tempPopulation;
    }

    public void setTempPopulation(int tempPopulation) {
        this.tempPopulation = tempPopulation;
    }

    public void addTempPopulation(int tempPopulation) {
        this.tempPopulation += tempPopulation;
    }

    public void setStrata(int strata) {
        this.strata = strata;
    }

    public void setAge(int age) {
        this.age = age;
    }


    @Override
    public String toString() {
        return "{" +
                " class='" + this.getClass().getSimpleName() + "'" +
                " strata='" + getStrata() + "'" +
                ", age='" + getAge() + "'" +
                ", population='" + getPopulation() +
                ", upNeighbour='" + getUpNeighbour().getPosition() +
                ", directNeighbour='" + getDirectNeighbour().getPosition() +
                ", downNeighbour='" + getDownNeighbour().getPosition() +
                "}";
    }

    public String getPosition() {
        return "strata: " + getStrata() + " age: " + getAge();
    }

    public int getStrata() {
        return this.strata;
    }

    public int getAge() {
        return this.age;
    }

    public int getMoney() {
        return this.money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getPopulation() {
        return this.population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    // public HashMap<Good,Integer> getGoodsConsumption() {
    // return this.goodsConsumption;
    // }

    // public void setGoodsConsumption(HashMap<Good,Integer> goodsConsumption) {
    // this.goodsConsumption = goodsConsumption;
    // }

    public CellMy getUpNeighbour() {
        return this.upNeighbour;
    }

    public void setUpNeighbour(CellMy upNeighbour) {
        this.upNeighbour = upNeighbour;
    }

    public CellMy getDirectNeighbour() {
        return this.directNeighbour;
    }

    public void setDirectNeighbour(CellMy directNeighbour) {
        this.directNeighbour = directNeighbour;
    }

    public CellMy getDownNeighbour() {
        return this.downNeighbour;
    }

    public void setDownNeighbour(CellMy downNeighbour) {
        this.downNeighbour = downNeighbour;
    }

}
