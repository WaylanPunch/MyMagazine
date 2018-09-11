package com.mymagazine;

import com.mymagazine.bean.User;
import com.mymagazine.service.IUserService;
import com.mymagazine.service.impl.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MyMagazineApplicationTests {

    @Autowired
    private IUserService usersService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("manager");
        user.setPassword("123456");
        user.setActivated(1);
        user.setEmail("manager@163.com");
        int uid = usersService.insertUser(user);
        System.out.println(uid);
    }

    @Test
    public void testSelectUserByUid() {
        User user = usersService.selectUserByUid(2);
        print(user);
    }

    private void print(Object object) {
        if (object instanceof List) {
            List<User> users = (List<User>) object;
            for (User user : users) {
                if (null != user) {
                    System.out.println(user.getUid());
                    System.out.println(user.getUsername());
                    System.out.println(user.getPassword());
                    System.out.println(user.getEmail());
                }
            }
        } else {
            if (object instanceof User) {
                if (null != object) {
                    User user = (User) object;

                    System.out.println(user.getUid());
                    System.out.println(user.getUsername());
                    System.out.println(user.getPassword());
                    System.out.println(user.getEmail());
                }
            } else {
                System.out.println(object);
            }
        }
    }

    @Test
    public void testLogin() {
        User user = usersService.login("admin", "123456");
        print(user);
    }

    @Test
    public void testUpdateUserByUid() {
        User user = new User();
        user.setUid(1);
        user.setUsername("admin");
        user.setPassword("123456");
        int i = usersService.updateUserByUid(user);
        print(i);
    }

    @Test
    public void testSelectAllUsers() {
        List<User> users = usersService.selectAllUsers();
        print(users);
    }

    @Test
    public void testDeleteByUid() {
        int i = usersService.deleteByUid(4);
        print(i);
    }

    @Test
    public void testCountAllUsers() {
        long i = usersService.countAllUsers();
        print(i);
    }
}
