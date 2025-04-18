package net.achraf.config;

import net.achraf.dao.DaoImpl;
import net.achraf.dao.IDao;
import net.achraf.metier.IMetier;
import net.achraf.metier.MetierImpl;

import java.lang.reflect.Constructor;

public class BeanFactory {

    public static <T> T createBean(Class<T> clazz) throws Exception {
        Constructor<?>[] constructors = clazz.getDeclaredConstructors();

        for (Constructor<?> constructor : constructors) {
            if (constructor.getParameterCount() > 0) {
                Class<?>[] parameterTypes = constructor.getParameterTypes();

                // Check if the constructor expects an IDao parameter
                if (parameterTypes.length == 1 && parameterTypes[0].equals(IDao.class)) {
                    // Create the dependency (IDao)
                    IDao dao = new DaoImpl(); // Create the DaoImpl dependency

                    // Inject the dependency through the constructor
                    return (T) constructor.newInstance(dao);
                }
            }
        }

        // Fallback to no-argument constructor if no dependencies are required
        return clazz.getDeclaredConstructor().newInstance();
    }
}
