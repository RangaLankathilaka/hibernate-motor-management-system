package lk.ijse.absd.main;

import lk.ijse.absd.bean.TestBean;
import lk.ijse.absd.bean.TestBean3;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AppInitializer {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext ctx = new AnnotationConfigApplicationContext();
        ctx.register(AppConfig.class);
        ctx.refresh();

      TestBean bean = ctx.getBean(TestBean.class);
//        bean.printTestBeans();
    }

}
