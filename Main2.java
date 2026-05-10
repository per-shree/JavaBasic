import java.util.Scanner;

interface Shape {
	 double area();
	 void display();
}

class Circle implements Shape {
	double radius;
	Circle(double radius) {
		this.radius = radius;
	}

	public double area() {
		return 3.14 * radius * radius;
	}

	public void display() {
		System.out.println("Circle | Radius: " + radius + " | Area: " + area());
	}
}

class Rectangle implements Shape {
	double length, width;
	Rectangle(double length, double width) { 
		this.length = length;
		this.width = width;
	}

	public double area() {
		return length * width;
	}

	public void display() {
		System.out.println("Rectangle | length: " + length + " Width: " + width + " | Area: " + area());
	}
}
 
class Triangle implements Shape {
	double base , height;
	Triangle(double base, double height){
		this.base = base;
		this.height = height;
	}
	public double area(){
		return 0.5 * base * height;
	}
	public void display() {
		System.out.println("Triangle | Base: " + base + " Height: " +height+ " | Area: " + area());
	}

}
class Main2 {
	public static void main(String[] args) {
		Scanner reader = new Scanner(System.in);
		Shape[] shapes = new Shape [3];
		shapes[0]= new Circle(5);
		 shapes[1] = new Rectangle(4, 3);
        shapes[2] = new Triangle(6, 4);

        System.out.println("Choose shape: 1.Circle  2.Rectangle  3.Triangle");
	System.out.print("Enter your Choice: ");
        int choice = reader.nextInt();

        
        System.out.println("\n===== Shape Details =====");
        shapes[choice - 1].display();
        System.out.println("=========================");

        reader.close();
    }
}

