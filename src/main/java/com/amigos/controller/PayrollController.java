package com.amigos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.amigos.dto.Payroll;
import com.amigos.service.PayrollService;

@RestController
public class PayrollController {

	@Autowired
	private PayrollService payrollService;

	@RequestMapping(value = "/payroll", method = RequestMethod.GET)
	public ResponseEntity<List<Payroll>> getPayrolls() {
		List<Payroll> payroll = payrollService.getAll();
		if (payroll.isEmpty()) {
			return new ResponseEntity<List<Payroll>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Payroll>>(payroll, HttpStatus.OK);
	}

	@RequestMapping(value = "/payroll", method = RequestMethod.POST)
	public ResponseEntity<Void> savePayroll(@RequestBody Payroll payroll, UriComponentsBuilder ucBuilder) {
		if (payroll == null) {
			throw new RuntimeException("Payroll  are required fields");
		}
		Long id = payrollService.save(payroll);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/payroll/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/payroll", method = RequestMethod.PUT)
	public ResponseEntity<Payroll> updatePayroll(@RequestBody Payroll payroll) {
		if (payroll == null || payroll.getPayrollId() <= 0) {
			throw new RuntimeException("Payroll  are required fields");
		}
		Payroll updatedPayroll = payrollService.update(payroll);
		if (updatedPayroll == null) {
			return new ResponseEntity<Payroll>(HttpStatus.NOT_FOUND);
		}	
		return new ResponseEntity<Payroll>(updatedPayroll,HttpStatus.OK);
	}

	@RequestMapping(value = "/payroll/{id}", method = RequestMethod.GET)
	public ResponseEntity<Payroll> getPayrollByid(@PathVariable Long id) {
		Payroll payroll = payrollService.getPayrollById(id);
		if (payroll == null) {
			return new ResponseEntity<Payroll>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Payroll>(payroll, HttpStatus.OK);
	}

	@RequestMapping(value = "/payroll/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletePayrollByid(@PathVariable Long id) {
		Payroll existingPayroll = payrollService.getPayrollById(id);
		if (existingPayroll == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		payrollService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
