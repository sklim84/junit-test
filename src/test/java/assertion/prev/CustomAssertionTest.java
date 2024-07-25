package assertion.prev;

import org.junit.jupiter.api.Test;
import java.beans.IntrospectionException;
import java.lang.reflect.InvocationTargetException;

public class CustomAssertionTest {

    @Test
    void testCustomAssertion() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Employee emp1 = new Employee(101, "John", "Doe", "john.doe@gmail.com");
        Employee emp2 = new Employee(101, "John", "Doe", "john.doe@gmail.com");

        CustomAssertions.assertJavaBeansEqual(emp1, emp2);
    }

}
