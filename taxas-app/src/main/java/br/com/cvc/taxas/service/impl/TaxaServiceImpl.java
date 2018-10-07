package br.com.cvc.taxas.service.impl;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Service;

import br.com.cvc.taxas.exception.TaxaException;
import br.com.cvc.taxas.request.TaxaRequest;
import br.com.cvc.taxas.service.TaxaService;
import br.com.cvc.taxas.utils.TransaferenciaUtils;

@Service
public class TaxaServiceImpl implements TaxaService {

	private static final Logger logger = LogManager.getLogger(TaxaServiceImpl.class);

	@Override
	public Float calcularTaxa(LocalDate dataTransferencia, LocalDate dataAgendamento, Float valor) {

		logger.info("Iniciando calculo de taxa");

		//Operacao TIPO A
		if(dataTransferencia.isEqual(dataAgendamento)) {
			logger.info("Operacao TIPO A");
			return Float.valueOf(3) + (valor * (3 / 100f));
		}
		
		//Operacao TIPO B
		Long diasDiferenca = ChronoUnit.DAYS.between(dataAgendamento, dataTransferencia);
		
		if(diasDiferenca < 0)
			throw new TaxaException("Data de agendamento invalida");
		
		if( diasDiferenca < 10) {
			logger.info("Operacao TIPO B");
			return (diasDiferenca.floatValue() * 12);
		}
		
		//Operacao TIPO C
		logger.info("Operacao TIPO C");
		if(TransaferenciaUtils.isBetween(10, 20, diasDiferenca.intValue()))
			return (valor * (8/100f));
		else if(TransaferenciaUtils.isBetween(20, 30, diasDiferenca.intValue()))
			return (valor * (6/100f));
		else if(TransaferenciaUtils.isBetween(30, 40, diasDiferenca.intValue()))
			return (valor * (3/100f));
		else if( diasDiferenca > 40 && valor > 100000) 
			return (valor * (2/100f));
		else 
			throw new TaxaException("Não foi possivel calcular taxa");
		
	}

	@Override
	public Float calcularTaxa(TaxaRequest taxa) {
		return calcularTaxa(taxa.getDataTransferencia(), taxa.getDataAgendamento(), taxa.getValor());
	}

	
}
