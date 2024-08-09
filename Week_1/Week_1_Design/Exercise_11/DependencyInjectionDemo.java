public class DependencyInjectionDemo {

    public static class User {
        private int userId;
        private String userName;

        public User(int userId, String userName) {
            this.userId = userId;
            this.userName = userName;
        }

        public int getUserId() {
            return userId;
        }

        public String getUserName() {
            return userName;
        }
    }

    public interface UserRepository {
        User findUserById(int id);
    }

    public static class UserRepositoryImpl implements UserRepository {
        @Override
        public User findUserById(int id) {
            return new User(id, "John Doe");
        }
    }

    public static class UserService {
        private final UserRepository userRepository;

        public UserService(UserRepository userRepository) {
            this.userRepository = userRepository;
        }

        public User getUserById(int id) {
            return userRepository.findUserById(id);
        }
    }

    public static void main(String[] args) {
        UserRepository userRepository = new UserRepositoryImpl();
        UserService userService = new UserService(userRepository);
        User user = userService.getUserById(1);
        System.out.println("User ID: " + user.getUserId());
        System.out.println("User Name: " + user.getUserName());
    }
}
