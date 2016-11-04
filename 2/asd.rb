=begin 
Midterm:
1. Java compiler generates bytecode to be run using java virtual machine
2.  X = 2 y = 4, 2 * 3 + 10 = 16 A
3. The statement that is true is: A, age is an local int variable inside the public method
   The actual answer was C, best answer for "which is true about age in definition of class Person: there's a local variable age anda class attribute age."
Practice:
1a) Write the call to method prompNames() and write code so that 
variable combines first and last attributes
like "last, first"
public String formatName() {
	String name;
	promptNames();
	name = last + ", " + first;
	return name;
}
b) in main(), call method formatName() and return value stored in variable "formatted"
public static void main(String[] args){
	MyFormatter aFormatter = new MyFormatter(); String formatted;
	formatted = aFormatter.formatName();
	System.out.println(formatted);
}

2. write get and set methods for following class
public class Student{
	private int identificationNumer;

	public Student(){
	identificationNumer = -1;
	}

	public int getID()
	{
		return identificationNumber;
	}

	public void setID(int newID)
	{
		identificationNumber = newID;
	}
}

3.
a) Implement copy constructor in class Product to take a Product object and copy its contents to the object that it creates.

public Product(Product prodToBeCopied)
{
	productName = prodToBeCopied.productName;
	productID = prodToBeCopied.productID;
}

b) Update stock level by invoking increaseStockLevel() to reflect
   the actual number of instances of class Product created.
Between 8 and 9: Product.increaseStockLevel();
Between 10 and 11: Product.increaseStockLevel();

c) How many milk and bread after line 12?
0 bread and 2 milk.

Chapter 1 quiz:
1. Compiler runs faster than an interpreter because interpreter has to stop 
   every few lines to execute the code.
2. Scope of a local variable is from the line that the method is defined
   to the line that the end bracket of the method.
3. To create a new object you have to use: Cylinder pole = new Cylinder();
   To use class methods from the object you must use: pole.method;
4. Public members and private members of a class: 
   Public members of a class can be accessed anywhere
   Private members of a class can only be accessed within the class
   As long as the public members remain the same, private members can be
   changed (This comes down to implementation vs interface, i.e. what the user
   can see of the program. So basically, implementation means you can change any private things 
   that the user doesn't have access to, as long as the public interface remains the same
   and the program does the same thing.)
5. To compile a program you use "javac classname.java"
6. Java compiler generates bytecode to be used by the JVM
7. To execute bytecode simply use "java classname.class"
8. System.out.println("asdjlaks"); will print aslkdjasldkj\n
9. Attributes are characteristics of an object
State of an object is defined by the values of said attributes
Methods are actions that the object can take.
10. Encapsulation is information hiding.
Polymorphism is what allows same program instructions to mean different things in different contexts. 
For instance, a utility block of code is polymorphic.
Inheritance is organizing classes to define common attributes and methods for a collection of classes.
11. The process of eliminating mistakes from a program is called debugging.
Therefore, a mistake in the program code is considered a "bug"
A mistake in the underlying algorithm is called a logic error.
Errors that occur during run-time are called run-time errors.

Chapter 2 Quiz:
1. float num = 10/3*2.5f == 10/3 int division = 3, * 2.5f = float multiplication = 7.5f
2. false or (false or true) and false is false or (true) and false which is true and false which is false.
3. a constant variable is denoted with like public (static) final int CONSTNAME = value; and can't be changed after being created.
4. int is 4 bytes in size. a byte is 1 byte, short is 2 bytes, int is 4 bytes, long is 8 bytes, float is 4 bytes, double is 8 bytes, bool are 1/8 of a byte aka a bit, char is 2 bytes.
Basically, bool < byte < short == char < int == float < long == double
5. variable names in java can start with only letters or underscores but can contain numbers in the rest of the name. They have no length limit, but you can't use reserved keywords such as "char"
6. You can't assign a larger byte size variable into a smaller one. i.e. int type = float type will cause compiler error.
7. Each variable for primitive data types will point to a different spot in memory (different string) even if they all have the same content.
8. typecasting is (type)value and will change that value into that type (might cause truncation)

Chapter 3 quiz:
1. letters have ASCII values assigned to them with a being smaller than b, i.e. if a is 88, b is 89.
2. == compares memory addresses, while .equals() compares actual values, for strings and object contents.
3. switch statements can't use float type values.
4. IF-ELSE statements can only be converted to switch statements if every IF or ELSE condition is mutually exclusive.

Chapter 4 quiz:
1. 