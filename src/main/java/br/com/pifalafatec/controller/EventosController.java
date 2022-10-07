package br.com.pifalafatec.controller;

import br.com.pifalafatec.entity.Eventos;
import br.com.pifalafatec.repository.EventosRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.context.config.ConfigDataResourceNotFoundException;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EventosController {

    EventosRepository repository;

    @GetMapping("/evento")
    public List<Eventos> getAllEventos(){
        return repository.findAll();
    }

    @GetMapping("/evento/{id}")
    public Eventos getEventoById(@PathVariable Long id){
        return repository.findById(id).get();
    }


    @PostMapping("/evento")
    public Eventos saveEvento(@RequestBody Eventos eventos) {
        return repository.save(eventos);
    }

    @PutMapping("/evento/{id}")
    public Eventos updateEvento(@PathVariable long id, @RequestBody Eventos eventos){
        Eventos evento = repository.findById(id).get();
        evento.setNome(eventos.getNome());
        evento.setData(eventos.getData());
        evento.setDescricao(eventos.getDescricao());
        evento.setHora(eventos.getHora());
        evento.setPalestrante(eventos.getPalestrante());

        return repository.save(evento);
    }

    @DeleteMapping("/evento/{id}")
    public void deleteEvento(@PathVariable Long id){
        repository.deleteById(id);
    }

}
