package testing.ingtest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import sun.rmi.runtime.Log;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.*;


@Component
@Order(1)
public class DatabaseSeederCustomer implements CommandLineRunner {
    private CustomersRepository customersRepository;

    @Autowired
    public DatabaseSeederCustomer(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        new Timer().scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                List<Customers> customers = new ArrayList<>();
                List<Customers> customersExist = customersRepository.findAll();

                try {
                    Scanner scanner = new Scanner(
                            new java.io.FileReader("src/main/klienci.csv"));

                    String line;
                    scanner.nextLine();
                    while (scanner.hasNextLine()) {
                        line = scanner.nextLine();
                        String[] result = line.split(",");
                        int customerIdsplit = Integer.parseInt(result[0]);
                        String customerNamesplit = result[1];
                        String customerRegionsplit = result[2];
                        String customerBrandsplit = result[3];
                        int customerPhonesplit = Integer.parseInt(result[4]);
                        String customerEmailsplit = result[5];
                        String customerDatesplit = result[6];

                        customers.add(new Customers(customerIdsplit, customerNamesplit, customerRegionsplit, customerBrandsplit, customerPhonesplit, customerEmailsplit, customerDatesplit));
                        System.out.println("dodano lub zmodyfikowano rekord");
                    }
                    customersRepository.save(customers);
                    scanner.close();
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }, 0, 600000);
    }
}

