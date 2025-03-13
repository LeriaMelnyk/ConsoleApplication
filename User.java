public class User {
    public final int id;
    public final String name;
    public final int age;
    public final String email;
    public User(int id, String name, int age, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.email = email;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public int getAge() {
        return age;
    }
    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "User: id="+id+", name="+name+", age="+age+", email="+email;
    }
}
