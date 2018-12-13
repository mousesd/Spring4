package net.homenet.dao;

import net.homenet.domain.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PetDao extends JpaRepository<Pet, Integer>, CustomPetDao {
    List<Pet> findByPetName(String petName);
    List<Pet> findByPetNameAndPriceLessThanEqual(String petName, int price);

    //# 1.
    //@Query("SELECT p FROM Pet p WHERE p.owner.ownerName = ?1")
    //List<Pet> findByOwnerName(String ownerName);

    //# 2.
    @Query("SELECT p FROM Pet p WHERE p.owner.ownerName = :ownerName")
    List<Pet> findByOwnerName(@Param("ownerName") String ownerName);

    //# 1.
    //@Modifying
    //@Query("UPDATE Pet p SET p.price = ?1 WHERE p.petName = ?2")
    //int updatePetPrice(Integer price, String petName);

    //# 2.
    @Modifying
    @Query("UPDATE Pet p SET p.price = :price WHERE p.petName = :petName")
    int updatePetPrice(@Param("price") Integer price, @Param("petName") String petName);
}
