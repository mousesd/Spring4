package net.homenet.repository;

import net.homenet.domain.Owner;

public interface OwnerDao {
    int getOwnerCount();
    Owner getOwner(String ownerName);
}
