package net.homenet.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@Entity
public class Pet {
    @Id
    private Integer petId;
    private String petName;

    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;
    private Integer price;
    private Date birthDate;

    public Pet() { }

    public Pet(Integer petId, String petName, Owner owner, Integer price, Date birthDate) {
        this.petId = petId;
        this.petName = petName;
        this.owner = owner;
        this.price = price;
        this.birthDate = birthDate;
    }

    public Integer getPetId() {
        return petId;
    }

    public void setPetId(Integer petId) {
        this.petId = petId;
    }

    public String getPetName() {
        return petName;
    }

    public void setPetName(String petName) {
        this.petName = petName;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public String toString() {
        return "Pet{" +
            "petId=" + petId +
            ", petName='" + petName + '\'' +
            ", owner=" + owner +
            ", price=" + price +
            ", birthDate=" + birthDate +
            '}';
    }
}
