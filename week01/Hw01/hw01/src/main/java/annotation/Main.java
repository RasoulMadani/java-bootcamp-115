package annotation;


import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> aClass = Class.forName(ProfileService.class.getName());
        Object obj = aClass.getDeclaredConstructors().newInstance();

        Method[] methods = aClass.getDeclaredMethods();
        for (Method method: methods){
            ProfileService df = method.getAnnotation(ProfileService.class);
            if(df!=null){
                method.invoke(ob);
            }
        }
    }
}