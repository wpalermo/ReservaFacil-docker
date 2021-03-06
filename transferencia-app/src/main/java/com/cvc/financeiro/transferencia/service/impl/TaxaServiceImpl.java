package com.cvc.financeiro.transferencia.service.impl;

import org.apache.logging.log4j.LogManager;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cvc.financeiro.transferencia.entities.Transferencia;
import com.cvc.financeiro.transferencia.histrixCommands.TaxaHttpRequest;
import com.cvc.financeiro.transferencia.resource.TaxaResource;
import com.cvc.financeiro.transferencia.scheduled.ScheduledTasks;
import com.cvc.financeiro.transferencia.service.TaxaService;
import com.cvc.financeiro.transferencia.service.TransferenciaService;

import rx.schedulers.Schedulers;

@Service
public class TaxaServiceImpl implements TaxaService {
	
    private static final Logger log = LogManager.getLogger(ScheduledTasks.class);


    	@SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
	@Autowired
	private TaxaResource taxaResource;
	
	@Autowired
	private TransferenciaService transferenciaService;
	
	
	public void calcularTaxa(Transferencia transferencia) {
		
		log.info("Iniciando servico de calculo de taxa");
		
		TaxaHttpRequest taxaHttpRequest = new TaxaHttpRequest(taxaResource, transferencia);
		
		//Executa a chama do servico usando ReactiveX e hystrix para o fallback
		taxaHttpRequest.toObservable()
					   .subscribeOn(Schedulers.io())
					   .subscribe(returned -> transferenciaService.atualizarTaxa(returned));  
		
	}

	
}
