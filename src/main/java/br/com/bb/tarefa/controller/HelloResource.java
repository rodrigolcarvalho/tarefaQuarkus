package br.com.bb.tarefa.controller;

import lombok.extern.slf4j.Slf4j;

import javax.inject.Inject;
import javax.inject.Named;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


import br.com.bb.tarefa.service.HorarioService;

import java.util.HashMap;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
@Path("/hello")
@Slf4j
public class HelloResource {

    @Inject
    @Named("horarioServiceImpl")
    HorarioService horarioService;

    @GET
    public Response hello() {
        HashMap<String, String> info = new HashMap<>();
        info.put("message", "Hello!");
         
        // return "Hello!";
        return Response.status(Response.Status.OK).entity(info).build();
    }
    @GET
    @Path("/{nome}")
    public Response helloFulano( @PathParam("nome") String nome) {
        HashMap<String, String> info = new HashMap<>();
        info.put("message", "Hello " + nome + "!");
        
        log.info("Mensagem para: {}", nome);
        return Response.status(Response.Status.OK).entity(info).build();
    }
    @GET
    @Path("/{nome}/horario")
    public Response helloFulanoHorario( @PathParam("nome") String nome) {
        HashMap<String, String> info = new HashMap<>();
        info.put("message", horarioService.showMensagem(nome));
        
        log.info("Mensagem para: {}, às {}", nome, horarioService.getHora());
        // return "Hello!";
        return Response.status(Response.Status.OK).entity(info).build();
    }

}