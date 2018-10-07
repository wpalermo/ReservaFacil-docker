package com.cvc.financeiro.transferencia.controller;

import com.cvc.financeiro.transferencia.exception.TaxaException;
import com.cvc.financeiro.transferencia.exception.TransferenciaException;
import com.cvc.financeiro.transferencia.request.TransferenciaRequest;
import com.cvc.financeiro.transferencia.response.TransferenciaResponse;
import com.cvc.financeiro.transferencia.service.TransferenciaService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@CrossOrigin(origins = "*")
@RequestMapping("/transferencia")
public class TransferenciaController {

	protected final Logger log = LogManager.getLogger(this.getClass());


	@Autowired
	private TransferenciaService transferenciaService;

	@RequestMapping(method = RequestMethod.GET, produces = { "application/json" })
	@ResponseStatus(value = HttpStatus.OK)
	public ResponseEntity<TransferenciaResponse> get() {


		TransferenciaResponse response = new TransferenciaResponse();
		response.setTransferencias(transferenciaService.buscarTodasTransferencias());

		log.info("Operacao GET realizada com sucesso");

		return new ResponseEntity<>(response, HttpStatus.OK);
	}

	@RequestMapping(method = RequestMethod.PUT, path = "/{id}")
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<TransferenciaResponse> put(Integer id, RequestEntity<TransferenciaRequest> request) {
		return null;
	}

	@RequestMapping(method = RequestMethod.POST)
	@ResponseStatus(value = HttpStatus.OK)
	@ResponseBody
	public ResponseEntity<TransferenciaResponse> post(RequestEntity<TransferenciaRequest> request) {

		try {
			transferenciaService.agendarTransferencia(request.getBody().getTransferencia());
			log.info("Operacao POST realizada com sucesso - conta origem: " + request.getBody().getTransferencia().getContaOrigem());
			return new ResponseEntity<>(HttpStatus.OK);

		} catch (TaxaException | TransferenciaException te) {
			log.error(te.getMessage());
			return new ResponseEntity<>(new TransferenciaResponse(te.getMessage()), HttpStatus.EXPECTATION_FAILED);
		} 
	}

	@RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
	@ResponseStatus(value = HttpStatus.METHOD_NOT_ALLOWED)
	@ResponseBody
	public void delete(String id) {

	}

}
 