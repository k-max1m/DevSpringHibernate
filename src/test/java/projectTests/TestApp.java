package projectTests;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import packages.models.User;
import packages.service.ServiceProject;
import packages.service.ServiceProjectImpl;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestApp {
    private static ServiceProject serviceProject = new ServiceProjectImpl();
    @Test
    public void testService() {
        assertEquals(serviceProject.getSumAccounts(), 11080);
        User user = new User("Victor", "Javnerovskiy");
        user.setUserId(6);
        assertEquals(serviceProject.getRichestUser(), user);
    }
}
