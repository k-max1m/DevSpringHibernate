package packages.service;

import packages.models.Account;
import packages.models.User;

import java.util.List;

public interface ServiceProject {
    User getUserById(int id);
    List<Account> findAll();
    int findSumAccountByUser(User user);
    User getRichestUser();
    int getSumAccounts();
}
