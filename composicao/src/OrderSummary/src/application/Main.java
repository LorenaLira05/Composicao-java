package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Main {
	public static void main(String[] args) throws ParseException {
		
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		System.out.println("Enter client data:");
		System.out.println("Name:");
		String name = sc.nextLine();
		System.out.println("Email:");
		String email = sc.nextLine();
		System.out.println("Birth date (DD/MM/YYYY): ");
		Date birthDate = sdf.parse(sc.next());
		sc.nextLine();
		
		Client client = new Client(name, email, birthDate);
		
		System.out.println("Enter order data: ");
		System.out.println("Status:");
		String status = sc.nextLine();
		
		System.out.println("How many items to this order?");
		int item = sc.nextInt();
		sc.nextLine();
		
		Order order = new Order(new Date(), OrderStatus.valueOf(status) , client);
		
		for(int i=1; i<=item; i++) {
			System.out.println("Enter #" + i+ " item data");
			System.out.println("Product name: ");
			String productName = sc.nextLine();
			sc.nextLine();
			System.out.println("Product price:");
			double productPrice = sc.nextDouble();
			
			Product product= new Product(productName, productPrice);
			
			System.out.println("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			
			OrderItem orderItem = new OrderItem(quantity,productPrice,product);
			
			order.addItem(orderItem);
		}
		
		System.out.println("ORDER SUMMARY");
		System.out.print(order);
		sc.close();
		
	}
}
