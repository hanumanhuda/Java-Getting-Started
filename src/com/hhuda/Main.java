package com.hhuda;

import static java.lang.System.exit;

public class Main {

    public static void main(String[] args) {
        if (args.length <1){
            System.out.println("java Main argv[1]");
            exit(1);
        }
        System.out.println("Hello World! "+ args[0]);

        //Testing Env arguments
        String env = System.getenv("name");
        System.out.println("Environment Property as Name : " + env);

        //Testing VM options
        String name = System.getProperty("user.name");
        System.out.println("System Property as Username : "+ name);


        //Testing Jar file working
        Person person=new Person();
        person.setName("hanuman");
        person.setAge(22);

        System.out.println("Person Name: "+ person.getName()+", age : "+person.getAge());
    }
}
