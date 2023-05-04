package com.thomas.module_2.assignment_1;

/**
 A class representing a planet.
 */
@SuppressWarnings({"FieldCanBeLocal", "FieldMayBeFinal", "CanBeFinal", "unused"})
public class Planet {
    private String designation; // the designation of the planet
    private double massKg; // the mass of the planet in kilograms
    private double orbitEarthYears; // the time it takes for the planet to orbit the Earth in years
    private PlanetType type; // the type of the planet

    /**
     Constructs a new Planet object with the given designation and type.

     @param designation the designation of the planet
     @param type the type of the planet
     */
    public Planet(String designation, PlanetType type){
        this.designation = designation;
        this.type = type;
    }

    /**
     Constructs a new Planet object with the given designation, mass, orbit time and type.

     @param designation the designation of the planet
     @param massKg the mass of the planet in kilograms
     @param orbitEarthYears the time it takes for the planet to orbit the Earth in years
     @param type the type of the planet
     */
    public Planet(String designation, double massKg, double orbitEarthYears, PlanetType type) {
        this.designation = designation;
        this.massKg = massKg;
        this.orbitEarthYears = orbitEarthYears;
        this.type = type;
    }

    /**
     Compares this planet to the specified object. The result is true if and only if the
     argument is not null and is a Planet object with the same designation as this planet.

     @param obj the object to compare this planet against
     @return true if the given object represents a Planet equivalent to this planet, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        return obj instanceof Planet && ((Planet) obj).designation.equals(designation);
    }

    /**
     Returns a hash code value for the planet based on its designation.

     @return a hash code value for this planet
     */
    @Override
    public int hashCode() {
        return designation.hashCode();
    }

    /**
     Returns a string representation of the planet, including its designation and type.

     @return a string representation of the planet
     */
    @Override
    public String toString() {
        return "Planet[" +
                "designation=" + designation +
                ",type=" + type +
                "]";
    }
}