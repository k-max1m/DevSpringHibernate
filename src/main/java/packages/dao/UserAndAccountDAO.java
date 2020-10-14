package packages.dao;

import packages.models.Account;
import packages.models.User;

import java.util.List;

public interface UserAndAccountDAO {
    User getUserById(int id);
    List<Account> findAll();
}
