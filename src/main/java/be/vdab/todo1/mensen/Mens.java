package be.vdab.todo1.mensen;

import jakarta.persistence.*;

import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "mensen")
class Mens {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String voornaam;
    private String familienaam;

    @ElementCollection
    @CollectionTable(name = "todos", joinColumns = @JoinColumn(name = "mensId"))
    @OrderBy("gemaakt")
    private Set<Todo> todos;

    Mens(String voornaam, String familienaam) {
        this.voornaam = voornaam;
        this.familienaam = familienaam;
        todos = new LinkedHashSet<Todo>();
    }

    protected Mens() {
    }

    void voegTodoToe(Todo todo){
        todos.add(todo);
    }

    public long getId() {
        return id;
    }

    public String getVoornaam() {
        return voornaam;
    }

    public String getFamilienaam() {
        return familienaam;
    }

    public Set<Todo> getTodos() {
        return Collections.unmodifiableSet(todos);
    }
}
