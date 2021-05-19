package by.azot.asutp.dao;

import static org.assertj.core.api.Assertions.assertThat;
import by.azot.asutp.entities.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

// import static org.junit.Assert.*;

@RunWith(MockitoJUnitRunner.class)
public class UserDaoTest {

    @Mock
    User userDao;

    @Test
    public void getByName() {
        assertThat(userDao).isNotNull();
    }
}