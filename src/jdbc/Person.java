package jdbc;

public class Person {

	private String name;
	private int age;
	public String getName() {
		System.out.println("getName方法执行了......");
		return name;
	}
	public void setName(String name) {
		System.out.println("setName方法执行了......");
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Person() {
	}


	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
}
