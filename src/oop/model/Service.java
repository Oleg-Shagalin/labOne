package oop.model;

public class Service {

    private String name;
    private double cost;

    public Service() {
        name = "интернет 100мб\\сек";
        cost = 300;
    }

    public Service(String name, int cost) {
        this.name = name;
        this.cost = cost;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

}
