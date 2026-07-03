package com.spk;

public class Main {

    public static void main(String[] args) {

        Menu menu = new Menu();
        Admin admin = new Admin(1, "Admin", "9999999999", "admin@gmail.com");
        admin.login();

        FoodItem dosa = new FoodItem(101, "Dosa", 40.0, true);
        FoodItem idli = new FoodItem(102, "Idli", 30.0, true);
        FoodItem pongal = new FoodItem(103, "Pongal", 50.0, false);

        admin.addItem(menu, dosa);
        admin.addItem(menu, idli);
        admin.addItem(menu, pongal);

        System.out.println("\n--- Menu After Admin Adds Items ---");
        menu.displayItems();

        admin.logout();

        System.out.println("\n====================================\n");

        // Create Student
        Student student = new Student(2, "Prarthana", "7777777777", "student@gmail.com");
        student.login();

        System.out.println("\n--- Student Viewing Menu ---");
        student.viewMenu(menu);

        System.out.println("\n--- Student Adding Items to Cart ---");
        student.addToCart(dosa);
        student.addToCart(pongal);

        System.out.println("\n--- Student Placing Order ---");
        student.placeOrder(101);

        System.out.println("\n--- Order History ---");
        student.viewOrderHistory();

        student.logout();
    }
}
