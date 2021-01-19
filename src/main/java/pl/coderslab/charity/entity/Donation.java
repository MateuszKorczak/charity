package pl.coderslab.charity.entity;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "donations")
public class Donation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Min(value = 1, message = "Minimum quantity is 1.")
    private Integer quantity;

    @NotEmpty
    @ManyToMany
    @JoinTable(name = "donation_categories", joinColumns = @JoinColumn(name = "donation_id"), inverseJoinColumns = @JoinColumn(name = "category_id"))
    private List<Category> categoryList = new ArrayList<>();

    @NotNull
    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;

    @Pattern(regexp = "([św\\.\\s]*[A-ZŻŹĆĄŚĘŁÓŃ]*[a-zżźćńółęąś\\s-]+([IXV\\s]+)*){1,3}\\d+[a-gA-G]?", message = "Add Street and Number")
    @NotBlank(message = "Street name is required")
    private String street;

    @NotBlank(message = "City name is required")
    @Pattern(regexp = "([A-ZŻŹĆĄŚĘŁÓŃ]*[a-zżźćńółęąś\\s-]+){1,2}", message = "Add City")
    private String city;

    @NotBlank
    @Pattern(regexp = "\\d{2}-\\d{3}", message = "Add zipCode in format 11-111")
    private String zipCode;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull
    private LocalDate pickUpDate;

    @NotNull
    private LocalTime pickUpTime;

    private String pickUpComment;

    /* constructor */

    public Donation() {
    }

    public Donation(@Min(value = 1, message = "Minimum quantity is 1.") Integer quantity, List<Category> categoryList, Institution institution, @Pattern(regexp = "([św\\.\\s]*[A-ZŻŹĆĄŚĘŁÓŃ]*[a-zżźćńółęąś\\s-]+([IXV\\s]+)*){1,3}\\d+[a-gA-G]?", message = "Add Street and Number") @NotBlank(message = "Street name is required") String street, @NotBlank(message = "City name is required") @Pattern(regexp = "([A-ZŻŹĆĄŚĘŁÓŃ]*[a-zżźćńółęąś\\s-]+){1,2}", message = "Add City") String city, @Pattern(regexp = "\\d{2}-\\d{3}", message = "Add zipCode in format 11-111") String zipCode, @NotBlank(message = "Pick Up Date name is required") LocalDate pickUpDate, @NotBlank(message = "Pick Up Time name is required") LocalTime pickUpTime, String pickUpComment) {
        this.quantity = quantity;
        this.categoryList = categoryList;
        this.institution = institution;
        this.street = street;
        this.city = city;
        this.zipCode = zipCode;
        this.pickUpDate = pickUpDate;
        this.pickUpTime = pickUpTime;
        this.pickUpComment = pickUpComment;
    }

    /* getters and setters */

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Category> getCategoryList() {
        return categoryList;
    }

    public void setCategoryList(List<Category> categoryList) {
        this.categoryList = categoryList;
    }

    public Institution getInstitution() {
        return institution;
    }

    public void setInstitution(Institution institution) {
        this.institution = institution;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    public LocalTime getPickUpTime() {
        return pickUpTime;
    }

    public void setPickUpTime(LocalTime pickUpTime) {
        this.pickUpTime = pickUpTime;
    }

    public String getPickUpComment() {
        return pickUpComment;
    }

    public void setPickUpComment(String pickUpComment) {
        this.pickUpComment = pickUpComment;
    }
}