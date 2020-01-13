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
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import org.mockito.Mock;
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

    private Customer customer;

    @Mock
    CustomerRepository repository;

    @InjectMocks
    CustomerService service = new CustomerService();

    @BeforeEach
    public void init() {
        MockitoAnnotations.initMocks(this);
        customer = new Customer();
        customer.setSex("M");
    }

    @Test
    public void CreateCustomer() {
        when(repository.save(any(Customer.class))).thenReturn(new Customer());
        service.createCustomer(customer);
        verify(repository, times(1)).save(eq(customer));
    }

    @Test
    public void UpdateCustomer() {
        customer.setId(1L);
        when(repository.findById(any(Long.class))).thenReturn(Optional.of(customer));
        service.updateCustomer(customer);
        verify(repository, times(1)).save(eq(customer));
    }

   /* @Test
    public void DeleteCustomer() {
        service.deleteCustomer(1L);
        verify(repository, times(1)).deleteById(eq(1L));
    }*/

    @Test
    public void GetCustomer() {
        when(repository.findById(any(Long.class))).thenReturn(Optional.of(customer));
        service.getCustomer(1L);
        verify(repository, times(1)).findById(eq(1L));
    }
}
