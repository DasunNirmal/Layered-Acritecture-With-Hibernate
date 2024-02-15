package lk.ijse.dao;

import lk.ijse.dao.custom.impl.StudentDAOImpl;

public class DAOFactory {

    private static DAOFactory daoFactory;

    private DAOFactory() {
    }

    public static DAOFactory getDaoFactory() {
        return (daoFactory == null) ? daoFactory = new DAOFactory() : daoFactory;
    }

    public enum DAOTypes {
        STUDENT
    }

    public SuperDAO getDao (DAOTypes types) {
        switch (types) {
            case STUDENT:
                return new StudentDAOImpl();
            default:
                return null;
        }
    }
}
