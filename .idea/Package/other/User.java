package Package.other;

public class User {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public User(String name) {
        this.name = name;
    }

    public void getCockSize(User user) {
        String name = user.getName();
        int nameHash = name.hashCode();

        System.out.println("CockSize name is " + nameHash);
    }
}
