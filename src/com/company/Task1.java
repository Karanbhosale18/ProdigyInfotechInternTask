package com.company;

import java.util.Scanner;
import java.util.logging.SocketHandler;

class Temperature {
    double Celsius, Fahrenheit, Kelvin;

    public void ToFahrenheitAndKelvin(double temp) {
        Celsius = temp;
        Fahrenheit = (temp * 1.8) + 32;
        Kelvin = temp+273.15;
    }

    public void ToCelsiusAndKelvin(double temp) {
        Fahrenheit = temp;
        Celsius = (temp-32)*5/9;
        Kelvin = Celsius+273.15;
    }

    public void ToCelsiusAndFahrenheit(double temp) {
        Kelvin = temp;
        Celsius = temp-273.15;
        Fahrenheit = (Celsius * 9/5)+32;
    }
}

public class Task1 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double temp;
        int choice;
        double Celsius,Fahrenheit,Kelvin;
        Temperature t1=new Temperature();

        System.out.println("Welcome to temperature converting system :");
        System.out.println("Select Unit and Enter Temperature :");
        System.out.println("1.To Celsius\n2.To Fahrenheit\n3.To Kelvin");

        choice = input.nextInt();
        temp = input.nextDouble();

        switch (choice) {

            case 1:
                t1.ToFahrenheitAndKelvin(temp);
                System.out.println("In Fahrenheit is " + t1.Fahrenheit+"\n"+"In Kelvin is "+t1.Kelvin);
                break;
            case 2:
                t1.ToCelsiusAndKelvin(temp);
                System.out.println("In Celsius is "+t1.Celsius+"\n"+"In Kelvin is "+t1.Kelvin);
                break;
            case 3:
                t1.ToCelsiusAndFahrenheit(temp);
                System.out.println("In Celsius is "+t1.Celsius+"\n"+"In Kelvin is "+t1.Kelvin);
                break;
            default:
                System.out.println("Invalid choice.");
                break;
        }
        System.out.println("Thank You");

    }
}
