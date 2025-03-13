import java.util.ArrayList;
import java.util.List;

public class UserService {
    private final List<User> users=new ArrayList<>();
    private int userIdCounter=0;

    public void addUser(String name, String email, int age){
        users.add(new User(userIdCounter++, name, age, email));
    }

    public User readUser(int userId) {
        for (User user : users) {
            if (user.getId() == userId) {
                return user;
            }
        }
        return null;
    }

    public void deleteUser(int id) {
        users.removeIf(user -> user.getId() == id);
    }

    public boolean updateUser(int id, String newName,int newAge, String newEmail) {
        for (int i = 0; i < users.size(); i++) {
            if (users.get(i).getId() == id) {
                User updatedUser = new User(id, newName, newAge, newEmail);
                users.set(i, updatedUser);
                return true;
            }
        }
        return false;
    }

    public List<User> listUsers() {
        return users;
    }
}
