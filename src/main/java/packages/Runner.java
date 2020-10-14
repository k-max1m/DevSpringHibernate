package packages;

import packages.models.Account;
import packages.models.User;
import packages.service.ServiceProject;
import packages.service.ServiceProjectImpl;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        ServiceProject serviceProject = new ServiceProjectImpl();
        User user = serviceProject.getRichestUser();

        System.out.println(serviceProject.findSumAccountByUser(user));
        System.out.println(serviceProject.getSumAccounts());
       // Account account = serviceProject.findAll().get(0);
       // User userAcc = serviceProject.findAll().get(0).getUser();
        //System.out.println(userAcc.getName());
        //System.out.println(serviceProject.getAllAccount().size());
    }
}
