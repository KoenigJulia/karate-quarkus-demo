package at.htl.boundary;

import at.htl.control.BookRepository;
import at.htl.entity.Book;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/books")
public class BookResource {

    @Inject
    BookRepository bookRepository;

    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/delete")
    public Response delete(String title){
        Book book = bookRepository.find("title", title).firstResult();
        boolean deleted = bookRepository.deleteById(book.id);
        return Response
                .status(Response.Status.OK)
                .entity(deleted)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{title}")
    public Response getBookByName(@PathParam("title")String title){
        Book book = bookRepository.find("title", title).firstResult();
        return Response
                .status(Response.Status.OK)
                .entity(book)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/getAllBooks")
    public Response getAllBooks(){
        List<Book> books = bookRepository.listAll();
        return Response
                .status(Response.Status.CREATED)
                .entity(books)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/{id}")
    public Response getBookById(@PathParam("id") Long id){
        Book book = bookRepository.findById(id);
        return Response
                .status(Response.Status.OK)
                .entity(book)
                .build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/author")
    public Response getBookByAuthor(@QueryParam("firstName") String firstName, @QueryParam("lastName") String lastName){
        List<Book> books = bookRepository.find("author.firstName = ?1 and author.lastName = ?2", firstName, lastName).stream().toList();
        return Response
                .status(Response.Status.OK)
                .entity(books)
                .build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/create")
    public Response create(@Valid Book book) {

        bookRepository.persist(book);
        return Response
                .status(Response.Status.CREATED)
                .build();
    }
}
