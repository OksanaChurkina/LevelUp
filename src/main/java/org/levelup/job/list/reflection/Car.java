package org.levelup.job.list.reflection;

public class Car {

    public String brand;
    private String model;
    public String name;

    public Car(String model)
    {
        this.model = model;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel(){
        return model;
    }

    public Car(String model, String brand)
    {
        this.model = model;
        this.brand = brand;
    }

    private void changeModel(String model)
    {
        this.model = model;
    }

    public String getName() {
        return name;
    }
}
