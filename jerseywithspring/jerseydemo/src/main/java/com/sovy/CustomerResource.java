package com.sovy;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    Database db = new Database();

    @GET
    @Produces("application/json")
    public List getAllCustomers() throws SQLException {
        List<Customer> listOfcustomers = new ArrayList();
        try {
            listOfcustomers = db.readData();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CustomerResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listOfcustomers;
    }

    @POST
    @Consumes("application/json")
    public Response createCustomer(Customer customer)  {
        if (customer.getFirstname() == null || customer.getLastname() == null) {
            return Response.status(400).entity("Please provide all mandatory inputs").build();
        }
         
        try {
            //  customer.setUri("/user-management/"+customer.getId());
            db.insertData(customer);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CustomerResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Response.status(201).build();
    }

    @GET
    @Path("/{id}")
    @Produces("application/json")
    public Response getCustomerById(@PathParam("id") int id) throws IOException, SQLException, ClassNotFoundException {
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
        Customer customer = null;
        try {
            customer = db.getCustomerById(id);
        } catch (SQLException ex) {
            Logger.getLogger(CustomerResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(CustomerResource.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CustomerResource.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (customer != null) {
            try {
                db.remove(customer.getId());
            } catch (SQLException ex) {
                Logger.getLogger(CustomerResource.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(CustomerResource.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(CustomerResource.class.getName()).log(Level.SEVERE, null, ex);
            }
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
*/ 
 
}
