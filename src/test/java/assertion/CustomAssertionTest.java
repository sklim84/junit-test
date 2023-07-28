package assertion;

import org.junit.jupiter.api.Test;
import java.beans.IntrospectionException;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.InvocationTargetException;

public class CustomAssertionTest {

    @Test
    void testCustomAssertion() throws IntrospectionException, InvocationTargetException, IllegalAccessException {
        Employee emp1 = new Employee(101, "John", "Doe", "john.doe@gmail.com1");
        Employee emp2 = new Employee(101, "John", "Doe", "john.doe@gmail.com");

        CustomAssertions.assertJavaBeansEqual(emp1, emp2);
    }

}
