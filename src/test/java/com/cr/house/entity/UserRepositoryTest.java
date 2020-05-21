package com.cr.house.entity;



import com.cr.house.ApplicationTests;
import com.cr.house.repository.UserRepository;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by chengrui
 */
public class UserRepositoryTest extends ApplicationTests {
    @Autowired
    private UserRepository userRepository;

    @Test
    public void testFindOne() {
        User user = userRepository.findOne(1L);
        Assert.assertEquals("chengrui", user.getName());
    }
}
