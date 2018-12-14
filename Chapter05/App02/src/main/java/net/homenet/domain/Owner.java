package net.homenet.domain;

import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("unused")
public class Owner {
    private String ownerName;
    private List<Pet> pets = new ArrayList<>();

    public Owner() { }

    public Owner(String ownerName) {
        this.ownerName = ownerName;
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
