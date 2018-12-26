package net.homenet.domain;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

@SuppressWarnings("unused")
@Entity
public class Pet {
    @Id
    private Integer petId;
    private String petName;
    private Integer price;
    private Date birthDate;
    @ManyToOne
    @JoinColumn(name = "owner_id")
    private Owner owner;

    public Pet() { }

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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    @Override
    public String toString() {
        return "Pet{" +
            "petId=" + petId +
            ", petName='" + petName + '\'' +
            ", price=" + price +
            ", birthDate=" + birthDate +
            ", owner=" + owner +
            '}';
    }
}
