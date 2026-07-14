package com.productdao;

import java.util.List;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try (Scanner sc = new Scanner(System.in)) {
			ProductDAO dao=new ProductDAOImpl();
			
			int choice;
			do {
				
				System.out.println("---Product Management System---");
				System.out.println("1.Add Product");
				System.out.println("2.Update Product");
				System.out.println("3.Delete Product");
				System.out.println("4.Search Product");
				System.out.println("5.Display All Products");
				System.out.println("6.Exit");
				System.out.println("Enter your choice:");
				choice=sc.nextInt();
				
				switch(choice) {
				
				case 1:
					Product p1=new Product();
					
					System.out.println("Enter Product id:");
					p1.setId(sc.nextInt());
					sc.nextLine();
					
					System.out.println("Enter Product name:");
					p1.setName(sc.nextLine());
					
					System.out.println("Enter Product price:");
					p1.setPrice(sc.nextDouble());
					sc.nextLine();
					
					System.out.println("Enter Product Quantity:");
					p1.setQuantity(sc.nextInt());
					sc.nextLine();
					
					dao.addProduct(p1);
					
					break;
					
				case 2:
					Product p2=new Product();
					
					System.out.println("Enter Product id:");
					p2.setId(sc.nextInt());
					sc.nextLine();
					
					System.out.println("Enter Product name:");
					p2.setName(sc.nextLine());
					
					System.out.println("Enter Product price:");
					p2.setPrice(sc.nextDouble());
					sc.nextLine();
					
					System.out.println("Enter Product quantity:");
					p2.setQuantity(sc.nextInt());
					
					dao.updateProduct(p2);
					
					break;
					
				case 3:
					System.out.println("Enter Product id:");
					int deleteId=sc.nextInt();
					dao.deleteProduct(deleteId);
					
					break;
					
				case 4:
					System.out.println("Enter Product id:");
					int searchId=sc.nextInt();
					Product product=dao.searchProduct(searchId);
					
					if(product!=null) {
						System.out.println("\n Product Found!!!");
						System.out.println("---");
						System.out.println("Id:"+product.getId());
						System.out.println("Name:"+product.getName());
						System.out.println("Price:"+product.getPrice());
						System.out.println("Quantity:"+product.getQuantity());
						
					} else {
						System.out.println("Product not found!");
					}
					
					break;
					
				case 5:
					
					List<Product> list=dao.displayAllProducts();
					if(list.isEmpty()) {
						System.out.println("No record found!");
					} else {
						System.out.println("---Product---");
						for(Product p:list) {
							
							System.out.println(
									p.getId()+ "|" +
									p.getName()+ "|" +
									p.getPrice()+ "|" +
									p.getQuantity());
									
						}
					}
					
					break;
					
				default:
				}
				
			} while (choice!=6);
		}

	}

	}
