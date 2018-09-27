package testng;

import org.testng.annotations.Test;
import org.testng.annotations.AfterTest;

public class DefaultTwo {

    @AfterTest
    public void demo (){
        System.out.println("Bye, This will happen last");
    }

    @Test
    public void demoTwo (){
        System.out.println("Bye again");
    }
}
