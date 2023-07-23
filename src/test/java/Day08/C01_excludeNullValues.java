package Day08;

import Pojo.Demo.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

public class C01_excludeNullValues {
//{salary:25000.0}
@Test
//employee clasında tanımladık
    public void excludeNullValues() throws JsonProcessingException {
    Employee employee=new Employee();
    employee.setSalary(25000.0);
    System.out.println(employee);
//Serialize islemi gerçekleştirmek için Jackson kütüphanesinin bize sağladığı jackson ObjectMapper objesini kullanır

    ObjectMapper obj=new ObjectMapper();
//bir java objesini srtinge çevirdik(serialize)
    String employeeString=obj.writeValueAsString(employee);





}


}
