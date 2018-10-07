package com.cvc.financeiro.transferencia.resource.fallback;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.ResponseEntity;

import com.cvc.financeiro.transferencia.request.TaxaRequest;
import com.cvc.financeiro.transferencia.resource.TaxaResource;
import com.cvc.financeiro.transferencia.response.TaxaResponse;

public class TaxaResourceFallback implements TaxaResource{

	private Logger LOGGER = LogManager.getLogger(this.getClass());
	
	@Override
	public ResponseEntity<TaxaResponse> post(TaxaRequest request) {
		
		LOGGER.error("PROBLEMA AO ACESSAR SERVICO DE TAXA");
		
		return null;
	}

}
