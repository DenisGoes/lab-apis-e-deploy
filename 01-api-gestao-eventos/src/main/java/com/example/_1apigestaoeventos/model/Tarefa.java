package com.example._1apigestaoeventos.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Tarefa {
    private Long id;

    @NotBlank(message = "O titulo é obrigatório!")
    @Size(min = 3, max = 100)
    private String titulo;

    private String descricao;

    private Boolean concluida = false;
    private LocalDateTime dataCriacao;
}
