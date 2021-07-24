public class Solution {
    public static void main(String[] args) {
        //1
        Horse horse = new Horse("Hercules", 10);
        System.out.println(horse.getName());
		
		
		//2
		Car BMW = new Car("BMW");
        Car porshce = new Car("white", "porshce");
		

        //3
        // sam

        //4
        // Yes, josh will be printed
        // the result of setName is being ignored because we don;t change the object name.

        //5
        // because s was not initialized the code will throw a NullPointerException


        //6
        // Encapsulation in Java is a mechanism of wrapping the code and data
        // (variables)acting on the data (methods) together as a single unit.
        // In encapsulation, the variables of a class will be hidden from other classes,
        // and can be accessed only through the methods of their current class. Therefore,
        // it is also known as data hiding.
    }
}

