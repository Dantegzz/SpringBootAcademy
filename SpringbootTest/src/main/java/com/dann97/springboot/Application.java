package com.dann97.springboot;

import com.dann97.springboot.bean.MyBean;
import com.dann97.springboot.component.MyComponent;
import com.dann97.springboot.entity.Posts;
import com.dann97.springboot.entity.User;
import com.dann97.springboot.repository.PostRepository;
import com.dann97.springboot.services.UserService;
import com.dann97.springboot.pojo.properties.UserProperties;
import com.dann97.springboot.repository.UserRepository;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

@SpringBootApplication
public class Application implements CommandLineRunner {

    private final Log logger = LogFactory.getLog(this.getClass());

    private MyBean myBean;
    private MyComponent myComponent;
    private UserProperties userProperties;
    private UserRepository userRepository;
    private PostRepository postRepository;
    private UserService userService;

    public Application(MyBean myBean, @Qualifier("AnyName") MyComponent myComponent, UserProperties userProperties, UserRepository userRepository, UserService userService, PostRepository postRepository) {
        this.myBean = myBean;
        this.myComponent = myComponent;
        this.userProperties = userProperties;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
        this.userService = userService;
    }

    @Bean
    public Function<String, String> uppercase() {
        return (String value) -> value.toUpperCase();
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println(myBean.hello());
        myComponent.printSomething();
        System.out.println(userProperties.toString());
        System.out.println("Im using sprinboot devopstools");
        logger.info("Error");
        Function function = uppercase();
        System.out.println(function.apply("dante"));
        saveUsersInDb();
        System.out.println(userService.getUserByEmail("andres@mail.com"));
        userService.getUsersByName("C").stream().forEach(System.out::println);
        saveWithErrorTransactional();
        System.out.println(userService.getUserByEmail("Test@domain.com").getPosts());


    }

    private void saveWithErrorTransactional() {
        User test1 = new User("TestTransactional1", "TestTransactional1@domain.com", LocalDate.now());
        User test2 = new User("TestTransactional2", "TestTransactional2@domain.com", LocalDate.now());
        User test3 = new User("TestTransactional3", null, LocalDate.now());
//        User test3 = new User("TestTransactional3", "TestTransactional4@domain.com", LocalDate.now()); //ejemplo dos
        User test4 = new User("TestTransactional4", "TestTransactional4@domain.com", LocalDate.now());
        List<User> users = Arrays.asList(test1, test2, test3, test4);

        try {
            userService.save(users);
            users.stream().forEach(user -> logger.info("User created " + user.toString()));
        } catch (RuntimeException e) {
            logger.error("Exception ocurred");
            logger.error(e.getMessage());
        }
        getUsers();
    }

    private void getUsers() {
        List<User> users = userRepository.findAll();
        users.forEach(user -> logger.info(user.toString()));
    }

    private void saveUsersInDb() {
        User user1 = new User("Andrea", "john@domain.com", LocalDate.now());
        User user2 = new User("Sofia", "julie@domain.com", LocalDate.now());
        User user3 = new User("Dante", "daniela@domain.com", LocalDate.now());
        User user4 = new User("Boo", "oscar@domain.com", LocalDate.now());
        User user5 = new User("Test1", "Test1@domain.com", LocalDate.now());
        User user6 = new User("Test2", "Test2@domain.com", LocalDate.now());
        User user7 = new User("Test3", "Test3@domain.com", LocalDate.now());
        User user8 = new User("Test4", "Test4@domain.com", LocalDate.now());
        User user9 = new User("Test5", "Test5@domain.com", LocalDate.now());
        User user10 = new User("Test6", "Test6@domain.com", LocalDate.now());
        User user11 = new User("Test7", "Test7@domain.com", LocalDate.now());
        User user12 = new User("Test8", "Test8@domain.com", LocalDate.now());
        User user13 = new User("Test9", "Test9@domain.com", LocalDate.now());
        List<User> list = Arrays.asList(user4, user1, user3, user2, user5, user6, user7, user8, user9, user10, user11, user12, user13);
        list.stream().forEach(userRepository::save);
        postRepository.save(new Posts("post test1", user12));
        postRepository.save(new Posts("post test2", user13));
        postRepository.save(new Posts("post test3", user13));

    }
}
