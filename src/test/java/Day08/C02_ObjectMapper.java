package Day08;

import Pojo.Demo.Employee;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

import static io.restassured.internal.mapping.ObjectMapping.deserialize;

public class C02_ObjectMapper {
    @Test
    public void objectMapper() throws IOException {
        // Jackson

        // 1. Serialize - Java Object -> Json String

        // 2. Deserialize - JSON String -> Java Object

        // 1.1. Java objesini code icerisinde bir string objesine cevirmek
        // 1.2. Proje icinde bir json dosyasina yazmak

        // 2.1. Java objesine stringden deserialize islemi
        // 2.2. Java objesine json dosyasindan deserialize islemi

  Employee employee = new Employee();
  employee.setFirstname("Harika");
  employee.setLastname("Eda");
  employee.setAge(25);
  employee.setSalary(25000);
        System.out.println(employee);
        ObjectMapper obj = new ObjectMapper();//serialize ve deserialize işlemini yapabilmek için obj oluşturmak zorundayız
        // 1.1. Convert Java Object to JSON String

        String empString = obj.writeValueAsString(employee);
        System.out.println("Serialized JSON String = " + empString);
        System.out.println("*************************************************************************");

        //1.2. Write Java object to .json file as json string
        obj.writeValue(new File(System.getProperty("user.dir") +"\\employee.json"),employee);

        //2.1 Convert JSONString to Java Object

        Employee deserializedObject = obj.readValue(empString, Employee.class);
        System.out.println(deserializedObject);
        System.out.println("**************************************************************************");

        //2.2. Read .json file and convert its value to Java Object
        Employee readJsonFromFile = obj.readValue(new File(System.getProperty("user.dir") +"\\employee.json"), Employee.class);

        System.out.println(readJsonFromFile);





    }




}
