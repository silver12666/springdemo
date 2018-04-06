package com.akhambir.model;

import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static javax.persistence.EnumType.STRING;

@Data
@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(generator = "USER_GEN")
    @SequenceGenerator(name = "USER_GEN", sequenceName = "USER_SEQ", allocationSize = 1)
    private Long id;
    @NotEmpty
    @Size(min = 8)
    @Column(name = "PASSWORD")
    private String password;
    @Email(regexp = "[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?")
    @NotEmpty
    @Column(name = "EMAIL")
    private String email;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "ACTIVATION_TOKEN")
    private String activationToken;
    @Enumerated(STRING)
    @Column(name = "ACCOUNT_STATUS")
    private AccountStatus status;
    @Column(name = "REGISTER_DATE")
    private LocalDateTime registerDate;
    @JoinColumn(name = "FK_USER_ROLE")
    @ManyToOne(fetch = FetchType.EAGER)
    private Role role;


    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "user")
    private List<ProductOrder> productOrders = new ArrayList<>();

    public User() {}

    public void setProductOrder(ProductOrder productOrder) {
        this.productOrders.add(productOrder);
        productOrder.setUser(this);
    }

    public enum AccountStatus {
        PENDING_ACTIVATION,
        ACTIVE,
        BLOCKED
    }
}
