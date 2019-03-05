package com.yjs;

import com.yjs.entity.UserDo;
import com.yjs.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    public void contextLoads() {
    }

    @Test
    public void mm() {
        List<UserDo> userDoList = userService.get();
        for (UserDo userDo : userDoList) {
            System.out.println("userDo = " + userDo);
        }
    }

}
