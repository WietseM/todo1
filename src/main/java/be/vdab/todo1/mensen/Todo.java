package be.vdab.todo1.mensen;

import jakarta.persistence.Embeddable;

import java.time.LocalDateTime;
import java.util.Objects;

@Embeddable
class Todo {
    private String tekst;
    private int prioriteit;
    private LocalDateTime gemaakt;

    public Todo(String tekst, int prioriteit, LocalDateTime gemaakt) {
        this.tekst = tekst;
        this.prioriteit = prioriteit;
        this.gemaakt = gemaakt;
    }

    protected Todo() {
    }

    public String getTekst() {
        return tekst;
    }

    public int getPrioriteit() {
        return prioriteit;
    }

    public LocalDateTime getGemaakt() {
        return gemaakt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Todo todo = (Todo) o;
        return prioriteit == todo.prioriteit && Objects.equals(tekst, todo.tekst) && Objects.equals(gemaakt, todo.gemaakt);
    }

    @Override
    public int hashCode() {
        return Objects.hash(tekst, prioriteit, gemaakt);
    }
}

