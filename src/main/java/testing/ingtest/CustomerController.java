package testing.ingtest;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/customers")

public class CustomerController {

    private CustomersRepository customersRepository;

    @Autowired
    public CustomerController(CustomersRepository customersRepository) {
        this.customersRepository = customersRepository;
    }

    public CustomerController() {
    }

    @RequestMapping(value = "/all", method = RequestMethod.GET)
    public List<Customers> getAll() {
        return customersRepository.findAll();
    }


    @RequestMapping(value = "/customerId/{brand}", method = RequestMethod.GET)
    public List<Customers> getRegion(@PathVariable String brand) {

        return customersRepository.findCustomersByBrandContaining(brand);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST)
    public List<Customers> create(@RequestBody Customers customer) {

        customersRepository.save(customer);

        return customersRepository.findAll();
    }

    @RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
    public List<Customers> remove(@PathVariable int id) {

        customersRepository.delete(id);

        return customersRepository.findAll();
    }


    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public List<Customers> edit(@PathVariable int id) {

        return customersRepository.findOne(id);
    }
}
