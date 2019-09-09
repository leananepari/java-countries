package com.lambdaschool.countries;

public class Country
{
    private String name;
    private long population;
    private long massSize;
    private int medianAge;

    public Country(String name, long population, long massSize, int medianAge) {
        this.name = name;
        this.population = population;
        this.massSize = massSize;
        this.medianAge = medianAge;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getPopulation() {
        return population;
    }

    public void setPopulation(long population) {
        this.population = population;
    }

    public long getMassSize() {
        return massSize;
    }

    public void setMassSize(long massSize) {
        this.massSize = massSize;
    }

    public int getMedianAge() {
        return medianAge;
    }

    public void setMedianAge(int medianAge) {
        this.medianAge = medianAge;
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", population=" + population +
                ", massSize=" + massSize +
                ", medianAge=" + medianAge +
                '}';
    }
}
