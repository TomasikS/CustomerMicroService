/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import com.sovy.model.Customer;
import com.sovy.repository.CustomerRepository;
import com.sovy.service.CustomerService;
import java.util.Optional;
import static org.junit.Assert.assertNotNull;
import org.junit.Before;
import org.junit.Test;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import org.mockito.Mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;
import static org.mockito.internal.verification.VerificationModeFactory.times;
import org.mockito.junit.jupiter.MockitoExtension;

/**
 *
 * @author stefan.tomasik
 */
//@RunWith(SpringJUnit4ClassRunner.class)
@ExtendWith(MockitoExtension.class)
//@SpringBootTest
public class CustomerTest {

    @Mock
    CustomerRepository repository;

    @InjectMocks
    CustomerService service = new CustomerService();

    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);

    }

    @Test
    public void CreateCustomer() {
        when(repository.save(any(Customer.class))).thenReturn(new Customer());
        Customer customer = new Customer();
        service.createCustomer(customer);
        verify(repository, times(1)).save(eq(customer));
    }

    @Test
    public void UpdateCustomer() {
        Customer Customer = new Customer();
        Customer zakaznik;
        Optional<Customer> returnedCustomer = Optional.of(Customer);

        returnedCustomer = repository.findById(1L);

        if (returnedCustomer.isPresent()) {
            zakaznik = returnedCustomer.get();
            repository.save(zakaznik);
            verify(repository, times(1)).save(eq(zakaznik));
        }
    }

    @Test
    public void DeleteCustomer() {
        verify(repository, never()).delete(any(Customer.class));
    }

    @Test
    public void GetCustomer() {
        Customer Customer = new Customer();
        Customer zakaznik;
        Optional<Customer> returnedCustomer = Optional.of(Customer);

        returnedCustomer = repository.findById(1L);

        if (returnedCustomer.isPresent()) {
            zakaznik = returnedCustomer.get();
            assertNotNull(zakaznik);
        }

    }
}
