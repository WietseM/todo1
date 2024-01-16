package be.vdab.todo1.mensen;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Optional;

@Service
@Transactional(readOnly = true)
class MensService {
    private final MensRepository mensRepository;

    public MensService(MensRepository mensRepository) {
        this.mensRepository = mensRepository;
    }

    @Transactional
    public Mens createMens(NieuwMens nieuwMens){
        var mens = new Mens(nieuwMens.voornaam(), nieuwMens.familienaam());
        mensRepository.save(mens);
        return mens;
    }

    @Transactional
    public void createTodo(long id, NieuweTodo nieuweTodo){
        var mens = mensRepository.findById(id).orElseThrow(MensNietGevondenException::new);
        var todo = new Todo(nieuweTodo.tekst(), nieuweTodo.prioriteit(), LocalDateTime.now());
        mens.voegTodoToe(todo);
    }

    Optional<Mens> findById(long id){
        return mensRepository.findById(id);
    }
}
