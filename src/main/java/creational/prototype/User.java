package creational.prototype;

import java.util.ArrayList;
import java.util.List;

public record User(String name, List<String> roles) implements Prototype<User> {

    public User(User source) {
        this(source.name, new ArrayList<>(source.roles));
    }

    @Override
    public User copy() {
        return new User(this);
    }

    public User withName(String name) {
        return new User(name, roles);
    }

    public User withRoles(List<String> roles) {
        return new User(name, roles);
    }

    public User withRole(String role) {
        List<String> roles = new ArrayList<>();
        roles.add(role);
        return new User(name, roles);
    }

    public User withAddedRole(String role) {
        List<String> roles = new ArrayList<>(this.roles);
        roles.add(role);
        return new User(name, roles);
    }
}
