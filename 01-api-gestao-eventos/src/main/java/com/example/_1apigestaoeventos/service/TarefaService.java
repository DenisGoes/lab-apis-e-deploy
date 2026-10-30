
package com.example._1apigestaoeventos.service;

import com.example._1apigestaoeventos.model.Tarefa;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TarefaService {

    private final List<Tarefa> tarefaList = new ArrayList<>();

    private final Set<Long> ids = new HashSet<>();

    private long id = 1;

    public Long gerarId() {
        while (!ids.add(id)) {
            id++;
        }

        return id++;
    }

    public List<Tarefa> listarTodasTarefas() {
        return tarefaList;
    }

    public Tarefa criarTarefa(Tarefa tarefa) {
        tarefa.setId(gerarId());
        tarefa.setDataCriacao(LocalDateTime.now());

        if (tarefa.getConcluida() == null) {
            tarefa.setConcluida(false);
        }

        tarefaList.add(tarefa);

        return tarefa;
    }

    public Tarefa buscarTarefaPorId(Long id) {
        for (Tarefa tarefa : tarefaList) {
            if (tarefa.getId().equals(id)) {
                return tarefa;
            }
        }

        return null;
    }

    public Tarefa atualizarTarefa(Long id, Tarefa tarefa) {
        Tarefa tarefaExistente = buscarTarefaPorId(id);

        if (tarefaExistente == null) {
            return null;
        }

        tarefaExistente.setTitulo(tarefa.getTitulo());
        tarefaExistente.setDescricao(tarefa.getDescricao());
        tarefaExistente.setConcluida(tarefa.getConcluida());

        return tarefaExistente;
    }

    public boolean deletarTarefa(Long id) {
        Tarefa tarefa = buscarTarefaPorId(id);

        if (tarefa == null) {
            return false;
        }

        tarefaList.remove(tarefa);
        ids.remove(id);

        return true;
    }
}
