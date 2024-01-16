package be.vdab.todo1.mensen;

import jakarta.validation.constraints.NotBlank;

record NieuwMens(@NotBlank String voornaam, @NotBlank String familienaam) {
}
