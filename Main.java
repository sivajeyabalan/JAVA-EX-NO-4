//package javaexamples;

import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */



public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("TAX calculation");
        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            employees[i] = new Employee();
            System.out.printf("Employee %d",i+1);
            employees[i].getInformation();
            employees[i].calculateTax(employees[i].income);
        }System.out.println("\nTax info");
    for (int i = 0; i < n; i++) {
            System.out.printf("Employee %d",i+1);
            employees[i].display();
        }
    }
}

abstract class Person {
    protected String name;
    protected String gender;
    protected String aadharNumber;
    protected double tax;

    public abstract void getInformation();
    public abstract void calculateTax(double income);
}

class Employee extends Person {
    public double income;

    @Override
    public void getInformation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name: ");
        this.name = scanner.nextLine();
        System.out.print("Enter gender: ");
        this.gender = scanner.nextLine();
        System.out.print("Enter Aadhar number: ");
        this.aadharNumber = scanner.nextLine();
        System.out.print("Enter income: ");
        this.income = scanner.nextDouble();
    }

    @Override
    public void calculateTax(double income) {
        if(income<=190000){
           if ("male".equalsIgnoreCase(gender))
                tax = 0;
            else if (gender.equalsIgnoreCase("female"))
                tax = 0; 
        }
        if(income<=200000 && income>190000){
           if ("male".equalsIgnoreCase(gender))
                tax = income * 0.10;
            else if (gender.equalsIgnoreCase("female"))
                tax = 0; 
        }
            
        if (income <= 500000 && income>200000) {
            if ("male".equalsIgnoreCase(gender))
                tax = income * 0.20;
            else if (gender.equalsIgnoreCase("female"))
                tax = income * 0.10;
        } 
        if(income>500000){
           if ("male".equalsIgnoreCase(gender))
                tax = income * 0.25;
            else if (gender.equalsIgnoreCase("female"))
                tax = income * 0.20; 
        }
    }
    public void display(){
        if(tax == 0){
        System.out.println("Tax for " + name + " (Aadhar: " + aadharNumber + ") is: " + "NIL");
    }
        else{
        System.out.println("Tax for " + name + " (Aadhar: " + aadharNumber + ") is: " + tax);
    }
}
}
