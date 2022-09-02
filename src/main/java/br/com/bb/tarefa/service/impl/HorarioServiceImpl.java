package br.com.bb.tarefa.service.impl;

import lombok.RequiredArgsConstructor;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

import br.com.bb.tarefa.service.HorarioService;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

@ApplicationScoped
@Named("horarioServiceImpl")
@RequiredArgsConstructor
public class HorarioServiceImpl implements HorarioService {
    @Override
    public String showMensagem(String nome) {
        String resposta = "Hello "+ nome + "! Agora são " +
                        getHora() + ", não esqueça!";
        return resposta;
    }

    @Override
    public String getHora() {
        DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("HH:mm");
        // return LocalTime.parse(LocalTime.now().toString(), formatTime);
        String resposta = formatTime.format(LocalTime.of(LocalTime.now().getHour(),LocalTime.now().getMinute()));
        return resposta;
    }

}