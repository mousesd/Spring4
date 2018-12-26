package net.homenet.domain;

import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("unused")
@Entity
public class Owner {
    @Id
    private Integer ownerId;
    private String ownerName;

    public Owner() { }

    public Owner(Integer ownerId, String ownerName) {
        this.ownerId = ownerId;
        this.ownerName = ownerName;
    }

    public Integer getOwnerId() {
        return ownerId;
    }

    public void setOwnerId(Integer ownerId) {
        this.ownerId = ownerId;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    @Override
    public String toString() {
        return "Owner{" +
            "ownerId=" + ownerId +
            ", ownerName='" + ownerName + '\'' +
            '}';
    }
}
