package net.homenet.domain;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("WeakerAccess")
public class Owner {
    private String ownerName;
    private List<Pet> pets = new ArrayList<>();

    public Owner() { }

    public Owner(String ownerName, List<Pet> pets) {
        this.ownerName = ownerName;
        this.pets = pets;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public List<Pet> getPets() {
        return pets;
    }

    public void setPets(List<Pet> pets) {
        this.pets = pets;
    }
}
