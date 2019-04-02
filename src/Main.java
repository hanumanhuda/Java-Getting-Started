
public class Main {

    public static void main(String[] args) {
        System.out.println("Hello World! "+ args[0]);

        //Testing Env arguments
        String env = System.getenv("env");
        System.out.println("Env : " + env);

        //Testing VM options
        String name = System.getProperty("name");
        System.out.println("Name : "+ name);


        //Testing Jar file working
        Person person=new Person();
        person.setName("hanuman");
        person.setAge(22);

        System.out.println("Person Name: "+ person.getName()+", age : "+person.getAge());


    }
}
