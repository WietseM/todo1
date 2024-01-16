package be.vdab.todo1.mensen;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

record NieuweTodo(@NotBlank String tekst, @Min(1) @Max(10) int prioriteit) {
}
