package com.conni.testng;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;

public class DataProviderWithReflect {
    @Test(dataProvider = "methodDP")
    public void test1(String name,Integer age){
        System.out.println("test1:name="+name+";age="+age);
    }
    @Test(dataProvider = "methodDP")
    public void test2(String name,Integer age){
        System.out.println("test2:name="+name+";age="+age);
    }
    @DataProvider(name="methodDP")
    public Object[][] createData(Method method){
        Object[][] object=null;
        if(method.getName().equals("test1")){
            object=new Object[][]{
                    {"Conni",new Integer(18)},
                    {"Lucy",new Integer(39)}
            };
        }else if(method.getName().equals("test2")){
            object=new Object[][]{
                    {"zhangsan",new Integer(40)},
                    {"lisi",new Integer(44)}
            };
        }
        return object;

    }
}
