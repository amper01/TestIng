package testing.ingtest;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomersRepository extends JpaRepository<Customers, Integer> {

    List<Customers> findOne(int id);

    List<Customers> findCustomersByBrandContaining(String brand);


}
