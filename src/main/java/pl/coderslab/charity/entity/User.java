package pl.coderslab.charity.entity;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Set;

@Entity
@Table(name = "users")
public class User {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 60)
//    @Pattern(regexp = "^(?=.*[A-Za-z0-9]$)[A-Za-z][A-Za-z\\d.-]{0,19}$", flags = Pattern.Flag.UNICODE_CASE)
    private String username;


    private String password;

    private int enabled;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[A-ZÓŹŻĆŁŚĆ]{1}[a-zóżźćąęłśń]{2,}", message = "Imię musi zaczynać się Wielką literą. Nie może składać się z cyfr ani znaków specjalnych")
    private String firstName;

    @NotNull
    @NotEmpty
    @Pattern(regexp = "[A-ZÓŹŻĆŁŚĆ]{1}[a-zóżźćąęłśń]{2,}", message = "Nazwisko musi zaczynać się Wielką literą. Nie może składać się z cyfr ani znaków specjalnych")
    private String lastName;

    @NotNull
    @NotEmpty
    @Email
    @Column(unique = true, nullable = false)
    @Pattern(regexp = "[_a-zA-Z0-9-]+(\\.[_a-zA-Z0-9-]+)*@[a-zA-Z0-9-]+(\\.[a-zA-Z0-9-]+)*\\.([a-zA-Z]{2,})", flags = Pattern.Flag.UNICODE_CASE)
    private String email;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEnabled() {
        return enabled;
    }

    public void setEnabled(int enabled) {
        this.enabled = enabled;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}