package application;

import entities.ImportedProduct;
import entities.Product;
import entities.UsedProduct;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Program {

    public static void main(String[] args) {

        Locale.setDefault(Locale.US);
        Scanner input = new Scanner(System.in);

        //instanciação da lista
        List<Product> product = new ArrayList<>();

        System.out.print("Enter the number of products: ");
        int qtd = input.nextInt();
        for (int i=1; i<=qtd; i++){
            //receber dados dos produtos
            System.out.println("\nProduct #" + i + " data:");
            System.out.print("\nCommom, used or imported (c/u/i)? ");
            char op = input.next().charAt(0);
            System.out.print("Name: ");
            input.nextLine();
            String name = input.nextLine();
            System.out.print("Price: ");
            Double price = input.nextDouble();
            //validar se é comum, importado ou usado e adicionar à lista
            if (op == 'i'){
                System.out.print("Customs fee: ");
                Double customsFee = input.nextDouble();
                product.add(new ImportedProduct(name, price, customsFee));
            } else if (op == 'u') {
                System.out.print("Manufature date (DD/MM/YYYY): ");
                LocalDate date = LocalDate.parse(input.next(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                product.add(new UsedProduct(name, price, date));
            } else {
                product.add(new Product(name, price));
            }
        }
        //imprimir os produtos da lista
        System.out.println("\n> Price tags:\n");
        for (Product tags: product) {
            System.out.print(tags.priceTag() + "\n");
        }

        input.close();

    }

}
