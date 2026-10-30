package com.example._1apigestaoeventos.controller;

import com.example._1apigestaoeventos.model.Tarefa;
import com.example._1apigestaoeventos.service.TarefaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    private final TarefaService tarefaService;

    public TarefaController(TarefaService tarefaService){
        this.tarefaService = tarefaService;
    }

    @GetMapping
    public List<Tarefa> listar(){
        return tarefaService.listarTodasTarefas();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Tarefa criar(@RequestBody @Valid Tarefa tarefa){
        return tarefaService.criarTarefa(tarefa);
    }

    @GetMapping("/{id}")
    public Tarefa buscarPorId(@PathVariable Long id){
        return tarefaService.buscarTarefaPorId(id);
    }

    @PutMapping("/{id}/atualizar")
    public Tarefa atualizar(@PathVariable Long id, @RequestBody @Valid Tarefa tarefa){
        return tarefaService.atualizarTarefa(id, tarefa);
    }

    @DeleteMapping("/{id}/deletar")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletar(@PathVariable Long id){
        tarefaService.deletarTarefa(id);
    }

}
