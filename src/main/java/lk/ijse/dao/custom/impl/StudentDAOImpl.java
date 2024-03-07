package lk.ijse.dao.custom.impl;

import lk.ijse.cofig.FactoryConfiguration;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {

    Session session = FactoryConfiguration.getFactoryConfiguration().getSession();
    Transaction transaction = session.beginTransaction();

    @Override
    public boolean save(Student dto) {
        session.save(dto);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean update(Student dto) throws SQLException, ClassNotFoundException {
        /*return SQLUtil.execute("UPDATE Student SET name = ?,address = ?,phone_number = ? WHERE id = ?",dto.getName(),
                dto.getAddress(),dto.getPhone_number(),dto.getId());*/
        session.update(dto);
        transaction.commit();
        session.close();
        return true;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        /*return SQLUtil.execute("DELETE FROM Student WHERE id = ?",id);*/
        return false;
    }

    @Override
    public Student search(String id) throws SQLException, ClassNotFoundException {
        Student entity = null;

        /*We're binding the parameter id using setParameter.*/
        /*We're retrieving the result as a list of Student objects directly using getResultList().*/

        Query<Student> query = session.createQuery("FROM Student WHERE id = :id", Student.class);
        query.setParameter("id", id);
        List<Student> resultList = query.getResultList();

        if (!resultList.isEmpty()) {
            entity = resultList.get(0);
        }

        return entity;
    }
}
