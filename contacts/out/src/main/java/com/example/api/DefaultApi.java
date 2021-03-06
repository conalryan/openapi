package com.example.api;

import com.example.model.Contact;
import com.example.model.Error;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import javax.ws.rs.*;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.MediaType;
import org.apache.cxf.jaxrs.ext.multipart.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import javax.validation.constraints.*;
import javax.validation.Valid;

/**
 * Contacts
 *
 * <p>No description provided (generated by Swagger Codegen https://github.com/swagger-api/swagger-codegen)
 *
 */
@Path("/")
public interface DefaultApi  {

    /**
     * Returns a contact by ID.
     *
     */
    @GET
    @Path("/contact/{contactId}")
    @Produces({ "application/json" })
    @Operation(summary = "Returns a contact by ID.", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "OK", content = @Content(schema = @Schema(implementation = Contact.class))),
        @ApiResponse(responseCode = "400", description = "The specified contact ID is invalid (not a number)."),
        @ApiResponse(responseCode = "401", description = "Unauthorized", content = @Content(schema = @Schema(implementation = Error.class))),
        @ApiResponse(responseCode = "404", description = "The specified resource was not found", content = @Content(schema = @Schema(implementation = Error.class))),
        @ApiResponse(responseCode = "200", description = "Unexpected error") })
    public Contact contactContactIdGet(@PathParam("contactId") @Min(1L) Long contactId);

    /**
     * Creates a contact.
     *
     */
    @POST
    @Path("/contact")
    @Consumes({ "application/json" })
    @Produces({ "application/json" })
    @Operation(summary = "Creates a contact.", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "201", description = "Created", content = @Content(schema = @Schema(implementation = Contact.class))) })
    public Contact contactPost(@Valid Contact body);

    /**
     * Returns a list of contacts
     *
     * Calls an external service and returns an &#x60;array&#x60; of contacts &#x60;objects&#x60;
     *
     */
    @GET
    @Path("/contacts")
    @Produces({ "application/json" })
    @Operation(summary = "Returns a list of contacts", tags={  })
    @ApiResponses(value = { 
        @ApiResponse(responseCode = "200", description = "A JSON array of contacts", content = @Content(array = @ArraySchema(schema = @Schema(implementation = String.class)))) })
    public List<String> contactsGet();
}
