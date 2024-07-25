package assertion.prev;

import org.junit.jupiter.api.Assertions;

import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class CustomAssertions2 {
    public static void assertJavaBeansEqual(Object expected, Object actual) throws InvocationTargetException, IllegalAccessException, IntrospectionException {
        if (expected != null && actual != null) {
            if (expected.getClass().equals(actual.getClass())) {
                for (PropertyDescriptor pd : Introspector.getBeanInfo(expected.getClass()).getPropertyDescriptors()) {
                    Method getter = pd.getReadMethod();
                    if (getter != null) {
                        Object expectedValue = getter.invoke(expected);
                        Object actualValue = getter.invoke(actual);
                        Assertions.assertEquals(expectedValue, actualValue, "Values are not equal for property: " + pd.getName());
                    }
                }
            } else {Assertions.fail("Objects are not of the same class"); }
        } else { Assertions.fail("Objects are null"); }
    }

}
