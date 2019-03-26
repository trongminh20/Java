abstract class animal{
	private String name;
	private String sound;

	public animal(String name, String sound){
		this.name = name;
		this.sound = sound;
	}
	
	abstract void run();
	abstract void makeSound();
	public String getSound(){
		return sound;
	}
}

class Dog extends animal{
	
	public Dog(String name){
		super(name, "Woff");
	}
	void run(){
		System.out.println("steps 4 at once");
	}
	void makeSound(){
		System.out.println(super.getSound());
	}
}
class Cat extends animal{
	public Cat(String name){
		super(name, "Meoo");
	}
	@Override
	void run(){
		System.out.println("steps 2 at once");
	}
	void makeSound(){
		System.out.println(super.getSound());
	}
}
public class abstractClass{
	public static void main(String[] args){
		animal dog1 = new Dog("pit");
		dog1.makeSound();
		Cat cat1 = new Cat("fit");
		cat1.makeSound();
		cat1.run();		
	}
}