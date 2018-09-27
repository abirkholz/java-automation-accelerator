package testng;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;

public class Default {

    @BeforeTest
    public void demo (){
        System.out.println("Hello, this will happen first");
    }

    @Test
    public void demoTwo (){
        System.out.println("Hello again");
    }
}
