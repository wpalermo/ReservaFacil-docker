package com.cvc.financeiro.transferencia.scheduled;

import java.time.LocalDate;

import com.cvc.financeiro.transferencia.aspect.LogThis;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.cvc.financeiro.transferencia.service.TransferenciaService;

@Component
public class ScheduledTasks {

    private static final Logger log = LogManager.getLogger(ScheduledTasks.class);


    @Autowired
    private TransferenciaService transferenciaService;
    
    /**
     * Roda o metodo realizaTransferencia agendado para rodar de 1 em 1 minuto
     */
    @Scheduled(cron = "1 * * * * *")
    @LogThis
    public void realizaTransaferencia() {
    	log.info("Iniciando tarfefa agendada - REALIZAR TRANSFERENCIA {} ", LocalDate.now());
        transferenciaService.realizarTransferencia();
    }
    
    
    
    @Scheduled(cron = "1 * * * * *")
    @LogThis
    public void atualizaTaxa() {
    	log.info("Iniciando tarfefa agendada - BUSCA DE TAXA {} ", LocalDate.now());
    	transferenciaService.recalcularTaxas();
    }
}