package at.htl.boundary;

import at.htl.control.AuthorRepository;
import at.htl.entity.Author;
import at.htl.entity.Book;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/author")
public class AuthorResource {
    @Inject
    AuthorRepository authorRepository;

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response create(@Valid Author author) {
        authorRepository.persist(author);
        return Response
                .status(Response.Status.CREATED)
                .build();
    }
}
