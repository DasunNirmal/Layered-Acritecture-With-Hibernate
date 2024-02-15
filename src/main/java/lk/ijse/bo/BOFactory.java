package lk.ijse.bo;

import lk.ijse.bo.custom.impl.StudentBOImpl;

public class BOFactory {
    private static BOFactory boFactory;

    private BOFactory() {}

    public static BOFactory getBoFactory () {
        return (boFactory == null) ? boFactory = new BOFactory() : boFactory;
    }

    public enum BOTypes {
        STUDENT
    }

    public SuperBO grtBo(BOTypes boTypes) {
        switch (boTypes) {
            case STUDENT:
                return new StudentBOImpl();
            default:
                return null;
        }
    }
}
