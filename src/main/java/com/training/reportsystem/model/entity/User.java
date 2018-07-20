package com.training.reportsystem.model.entity;

import javax.persistence.*;
import java.util.Objects;
import java.util.Optional;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;
    private String username;
    private String password;
    private String firstName;
    private String lastName;

    @Enumerated(EnumType.STRING)
    private Role role;

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

    public Optional<Role> getRole() {
        return Optional.ofNullable(role);
    }

    public void setRole(Role role) {
        this.role = role;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", role=" + role +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User)) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) &&
                Objects.equals(username, user.username) &&
                Objects.equals(password, user.password) &&
                Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                role == user.role;
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, username, password, firstName, lastName, role);
    }

    protected static abstract class GenericUserBuilder<T extends GenericUserBuilder<T>> implements Builder<User> {

        private final Class<T> builderClass;
        protected Long id;
        protected String username;
        protected String password;
        protected String firstName;
        protected String lastName;
        protected Role role;


        GenericUserBuilder(Class<T> builderClass) {
            this.builderClass = builderClass;
        }

        public T setId(Long id) {
            this.id = id;
            return builderClass.cast(this);
        }

        public T setUsername(String username) {
            this.username = username;
            return builderClass.cast(this);
        }

        public T setPassword(String password) {
            this.password = password;
            return builderClass.cast(this);
        }

        public T setFirstName(String firstName) {
            this.firstName = firstName;
            return builderClass.cast(this);
        }

        public T setLastName(String lastName) {
            this.lastName = lastName;
            return builderClass.cast(this);
        }

        public T setRole(Role role) {
            this.role = role;
            return builderClass.cast(this);
        }


        @Override
        public User build() {
            User user = new User();
            user.setId(id);
            user.setUsername(username);
            user.setPassword(password);
            user.setFirstName(firstName);
            user.setLastName(lastName);
            user.setRole(role);
            return user;
        }
    }

    public static class UserBuilder extends GenericUserBuilder<UserBuilder> {

        public UserBuilder() {
            super(UserBuilder.class);
        }
    }
}
