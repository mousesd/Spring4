package net.homenet.domain;

import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;

@SuppressWarnings("unused")
@XmlRootElement
public class Customer {
    private Integer id;

    @NotNull
    @Size(max = 20)
    private String name;

    @NotNull
    @Pattern(regexp = ".+@.+")
    private String emailAddress;

    @NotNull
    @DateTimeFormat(pattern = "yyyy/MM/dd")
    private Date birthDate;

    @Min(0)
    @Max(9)
    private Integer favoriteNumber;

    public Customer() { }

    public Customer(String name, String emailAddress, Date birthDate, Integer favoriteNumber) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.birthDate = birthDate;
        this.favoriteNumber = favoriteNumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public Integer getFavoriteNumber() {
        return favoriteNumber;
    }

    public void setFavoriteNumber(Integer favoriteNumber) {
        this.favoriteNumber = favoriteNumber;
    }

    //@AssertFalse(message = "{errors.emailAddress.ng}")
    //public Boolean isNgEmail() {
    //    if (emailAddress == null)
    //        return  false;
    //
    //    return emailAddress.matches(".*@ng.foo.baz$");
    //}

    @AssertFalse(message = "{errors.emailAddress.ng}")
    public Boolean getNgEmail() {
        if (emailAddress == null)
            return  false;

        return emailAddress.matches(".*@ng.foo.baz$");
    }
}
