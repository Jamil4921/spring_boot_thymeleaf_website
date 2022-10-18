package be.ehb.derdehandjes.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

@Entity
public class product {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "invulveld mag niet leeg zijn")
    private String naam;

    @NotBlank(message = "invulveld mag niet leeg zijn")
    private String categorie;

    @NotBlank(message = "invulveld mag niet leeg zijn")
    private String omschrijving;

    @NotBlank(message = "invulveld mag niet leeg zijn")
    private String userName;

    @NotBlank(message = "invulveld mag niet leeg zijn")
    @Email(message = "dit is een omgeldige email adress")
    private String email;


    @DecimalMin(value = "0.0", message = "Prijs mag niet negatief zijn")
    private double vraagPrijs;

    public product() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNaam() {
        return naam;
    }

    public void setNaam(String naam) {
        this.naam = naam;
    }

    public String getCategorie() {
        return categorie;
    }

    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public String getOmschrijving() {
        return omschrijving;
    }

    public void setOmschrijving(String omschrijving) {
        this.omschrijving = omschrijving;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getVraagPrijs() {
        return vraagPrijs;
    }

    public void setVraagPrijs(double vraagPrijs) {
        this.vraagPrijs = vraagPrijs;
    }
}
