package be.vdab.todo1.mensen;

import jakarta.validation.Valid;
import org.springframework.hateoas.server.EntityLinks;
import org.springframework.hateoas.server.ExposesResourceFor;
import org.springframework.hateoas.server.TypedEntityLinks;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.io.Console;
import java.util.Set;

@RestController
@RequestMapping("mensen")
@ExposesResourceFor(Mens.class)
class MensController {
    private final MensService mensService;
    private final TypedEntityLinks.ExtendedTypedEntityLinks<Mens> links;

    MensController(MensService mensService, EntityLinks links) {
        this.mensService = mensService;
        this.links = links.forType(Mens.class, Mens::getId);
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    HttpHeaders createMens(@RequestBody @Valid NieuwMens nieuwMens){
        var mens = mensService.createMens(nieuwMens);
        var headers = new HttpHeaders();
        headers.setLocation(links.linkToItemResource(mens).toUri());
        return headers;
    }

    @PostMapping("{id}/todos")
    void createTodo(@PathVariable long id, @RequestBody @Valid NieuweTodo nieuweTodo){
        mensService.createTodo(id, nieuweTodo);
    }


    @GetMapping("{id}/todos")
    MensTodos findById(@PathVariable long id){
        return mensService.findById(id).map(MensTodos::new).orElseThrow(MensNietGevondenException::new);
    }


    private record MensTodos(Set<Todo> todos) {
        MensTodos(Mens mens) {
            this(mens.getTodos());
        }
    }

}
