
public class Solution extends MyAbstractClass implements Inter {
    public static void main(String[] args) {

        //1
        new Solution().doSomething();

        //2
        new Solution().doSomethingAbstract();

        //3
        // Compilation error - Abstract class can not be instantiated
		
		//4
        // Compilation error - Abstract class can not be decalared final

        //5A
        Ball ball = new Ball();
        System.out.println(ball.isRound);

        //5B
        ball.isRound = false; // error

        //6
        // static modifier can't be used inside a method

        //7+8
        WhitePony whitePony = new WhitePony("whity", 3);
        whitePony.bite();
        System.out.println(whitePony.getPonyColor());
		
		//9
        // In Java multiple inheritance is not allowed
        // In other words, a class can only extends one other class only
		
		//10
        // Because Apple and Dog are not in the same package an import statement is required
        // FIX: Add import animals.Dog inside Apple class.

        //11
        // Dog and Apple are in a separate package.
        // The method bark is protected and can't be used outside the package (only in inheritance)
        // FIX: 
	package fruits;

	import animals.Dog;

	public class Apple extends Dog {
	    public static void main(String[] args) {
		Apple a = new Apple();
		a.bark();
	    }
	}
		
		
        //12
        // Whaf - Puppy

        //13
        // Normally never, this is because GC is called automatically

        //14
        // D - All

        //15
        // Yes, when it makes no sense to continue
        // Example: we want to test a website but can't connect to internet

        //16
        // RuntimeException
    }

    @Override
    public void doSomething() {
        System.out.println("Something");
    }

    @Override
    void doSomethingAbstract() {
        System.out.println("Something abstract");
    }
}
