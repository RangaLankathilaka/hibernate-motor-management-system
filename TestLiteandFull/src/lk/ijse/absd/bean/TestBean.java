package lk.ijse.absd.bean;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class TestBean {

    public static ArrayList<String> myNames = new ArrayList<>();


    static{
        myNames.add("Nimal");
        myNames.add("Kasun");
        myNames.add("Kamal");
        myNames.add("Sunil");
    }


    public TestBean(@Value("#{T(lk.ijse.absd.bean.TestBean).myNames.?[toString().substring(0,1) eq 'K']}") List<String> namesWithK){
        System.out.println(namesWithK);

    }

//    public void printBeans(){
//        System.out.println(testBean());
//        System.out.println(testBean());
//    }
//
//    @Bean
//    public TestBean testBean(){
//        return new TestBean();
//    }


}
