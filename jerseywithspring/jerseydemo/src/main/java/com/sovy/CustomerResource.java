package com.sovy;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.NONE)
@XmlRootElement(name = "users")
@Path("/customers")
public class CustomerResource {
    // private static Map<Integer, Customer> DB = new HashMap<>(); 

    Database db = new Database();

    @GET
    @Produces("application/json")
    public List getAllCustomers() throws SQLException {
        //  Customer  customers = new Customers();
        //customers.setCustomers(new ArrayList<>(DB.values()));

        List<Customer> listOfcustomers = new ArrayList();
        listOfcustomers = db.readData();
        return listOfcustomers;
    }

    @POST
    @Consumes("application/json")
    public Response createCustomer(Customer customer)  {
        if (customer.getFirstname() == null || customer.getLastname() == null) {
            return Response.status(400).entity("Please provide all mandatory inputs").build();
        }
         
        //  customer.setUri("/user-management/"+customer.getId());
        db.insertData(customer);
        return Response.status(201).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getCustomerById(@PathParam("id") int id) {
        Customer customer = db.getCustomerById(id);
        if (customer == null) {
            return Response.status(404).build();
        }
        return Response
                .status(200)
                .entity(customer)
                .build();
    }
    
    @DELETE
    @Path("/customer/{id}")
    public Response deleteUser(@PathParam("id") int id) {
        Customer customer = db.getCustomerById(id);
        if (customer != null) {
            db.remove(customer.getId());
            return Response.status(200).build();
        }
        return Response.status(404).build();
    }
    

  /*@PUT
    @Path("/{id}")
    @Consumes("application/json")
    @Produces("application/json")
    public Response updateUser(@PathParam("id") int id, Customer customer) throws URISyntaxException {
        Customer temp = db.get(id);
        if (customer == null) {
            return Response.status(404).build();
        }

        temp.setFirstname(customer.getFirstname());
        temp.setLastname(customer.getLastname());

        db.put(temp.getId(), temp);
        return Response.status(200).entity(temp).build();
    }
/* 
 

     static
    {
        User user1 = new User();
        user1.setId(1);
        user1.setFirstName("John");
        user1.setLastName("Wick");
        user1.setUri("/user-management/1");
 
        User user2 = new User();
        user2.setId(2);
        user2.setFirstName("Harry");
        user2.setLastName("Potter");
        user2.setUri("/user-management/2");
         
        DB.put(user1.getId(), user1);
        DB.put(user2.getId(), user2);*/
    //  }
}
