package packages.service;

import org.springframework.stereotype.Service;
import packages.dao.UserAndAccountDAO;
import packages.dao.UserAndAccountDAOImpl;
import packages.models.Account;
import packages.models.User;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class ServiceProjectImpl implements ServiceProject {
    private UserAndAccountDAO userAndAccountDAO = new UserAndAccountDAOImpl();
    private Map<User, Integer> serviceMap;
    public User getUserById(int id) {
        return userAndAccountDAO.getUserById(id);
    }

    @Override
    public List<Account> findAll() {
        return userAndAccountDAO.findAll();
    }

    private Map<User, Integer> getMapUsers() {
        List<Account> accounts = findAll();
        if (serviceMap == null) {
            serviceMap = accounts.stream()
                    .collect(Collectors.groupingBy(Account::getUser, Collectors.summingInt(Account::getAccount)));
        }
        return serviceMap;
    }

    @Override
    public int findSumAccountByUser(User user) {

        User userDB = getUserById(user.getUserId());

        List<Account> accounts = userDB.getAccounts();

        int sum = accounts.stream()
                .mapToInt(Account::getAccount)
                .sum();



        return sum;
    }

    @Override
    public User getRichestUser() {
        Map<User, Integer> collect = getMapUsers();
        return collect.entrySet().stream()
                .max((o1, o2) -> o1.getValue() > o2.getValue() ? 1 : -1).get().getKey();
    }

    @Override
    public int getSumAccounts() {
        Map<User, Integer> map = getMapUsers();
        return map.values().stream().mapToInt(i -> i).sum();
    }


    //public int



}
