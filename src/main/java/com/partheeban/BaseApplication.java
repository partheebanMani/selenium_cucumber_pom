package com.partheeban;

import com.partheeban.apps.Employee;
import com.partheeban.apps.User;
import com.partheeban.enums.RestAPIs;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public abstract class BaseApplication {

    public static Employee employee;

    public static User user;


    protected BaseApplication(List<RestAPIs> apps) {
        apps.forEach(BaseApplication::initalizeApps);
    }


    public static synchronized void initalizeApps(RestAPIs app) {
        switch (app) {
            case EMPLOYEE:
                System.out.println("inside initalizee empl");
                employee = initMethod(employee, Employee.class);
                break;
            case USERS:
                user = initMethod(user, User.class);
                break;
        }
    }

    private static <T> T initMethod(T instance, Class<T> comp) {
        try {
            if (instance == null)
                return comp.getDeclaredConstructor().newInstance();
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException |
                 NoSuchMethodException e) {
            System.out.println(e.getMessage());
        }
        return instance;
    }


}
