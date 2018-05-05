package com.training.reportsystem.model.entity.user;

import com.training.reportsystem.model.entity.Builder;

import java.util.Optional;

public class User {

    private Long id;
    private String username;
    private String password;
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
                ", role=" + role +
                '}';
    }

    protected static abstract class GenericUserBuilder<T extends GenericUserBuilder<T>> implements Builder<User> {

        private final Class<T> builderClass;
        protected Long id;
        protected String username;
        protected String password;
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
