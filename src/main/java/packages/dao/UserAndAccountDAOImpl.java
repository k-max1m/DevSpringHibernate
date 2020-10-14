package packages.dao;

import org.hibernate.Session;
import org.hibernate.Transaction;
import packages.models.Account;
import packages.models.User;
import packages.utils.HibernateSessionFactoryUtil;

import java.util.List;

public class UserAndAccountDAOImpl implements UserAndAccountDAO {
    @Override
    public User getUserById(int id) {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        User user = session.get(User.class, id);
        return user;
    }


    @Override
    public List<Account> findAll() {
        Session session = HibernateSessionFactoryUtil.getSessionFactory().openSession();

        @SuppressWarnings("unchecked")
        List<Account> list = (List<Account>) session.createQuery("from Account ").list();


        return list;
    }
}
