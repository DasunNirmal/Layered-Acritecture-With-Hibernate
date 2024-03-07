package lk.ijse.dao.custom.impl;

import lk.ijse.cofig.FactoryConfiguration;
import lk.ijse.dao.custom.StudentDAO;
import lk.ijse.entity.Student;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.sql.SQLException;

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
        return false;
    }

    @Override
    public boolean delete(String id) throws SQLException, ClassNotFoundException {
        /*return SQLUtil.execute("DELETE FROM Student WHERE id = ?",id);*/
        return false;
    }

    @Override
    public Student search(String id) throws SQLException, ClassNotFoundException {
        /*ResultSet resultSet = SQLUtil.execute("SELECT * FROM Student WHERE id = ?",id);

        Student entity = null;
        if (resultSet.next()) {
            int Sid = Integer.parseInt(resultSet.getString(1));
            String name = resultSet.getString(2);
            String address = resultSet.getString(3);
            int phoneNumber = Integer.parseInt(resultSet.getString(4));

            entity = new Student(Sid,name,address,phoneNumber);
        }
        return entity;*/
        return null;
    }
}
