package com.sovy;

import com.sovy.service.CustomerService;
import com.sovy.model.Customer;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

@Path("/customers")
public class CustomerResource {

    @Autowired
    CustomerService db;
    

    @Path("customer/{id}")
    @PUT
    public Response updateCustomer(Customer customer) {
        db.updateCustomer(customer);
        return Response.status(200).build();
    }

    @Path("/add")
    @POST
    public Response createCustomer(Customer json) {
        db.createCustomer(json);
        return Response.status(200).build();
    }

    @GET
    @Path("customer/{id}")
    @Produces("application/json")
    public Response getCustomerById(@PathParam("id") Long id) {
        Customer customer = null;
        customer = db.getCustomer(id);
        if (customer == null) {
            return Response.status(404).build();
        }
        return Response
                .status(200)
                .entity(customer)
                .build();
    }

    @DELETE
    @Path("customer/{id}")
    public Response deleteCustomerById(@PathParam("id") Long id) {
          Customer customer = null;
        db.deleteCustomer(id);

        return Response
                .status(200)
                .entity(customer)
                .build();
    }

}
