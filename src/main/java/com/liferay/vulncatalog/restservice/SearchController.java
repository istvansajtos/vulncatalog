package com.liferay.vulncatalog.restservice;

import com.liferay.vulncatalog.persistence.entity.Ticket;
import com.liferay.vulncatalog.persistence.entity.Vulnerability;

import java.util.LinkedList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SearchController {

	@GetMapping("/search")
	public List<Object> search(
		@RequestParam(value = "input", defaultValue = "") String input) {

		List<Vulnerability> vulnerabilities = new LinkedList();

		vulnerabilities.add(new Vulnerability("CVE-2021-33813",
			"https://nvd.nist.gov/vuln/detail/CVE-2021-33813", ""));
		vulnerabilities.add(new Vulnerability("CVE-2021-30468",
			"https://nvd.nist.gov/vuln/detail/CVE-2021-30468", ""));

		List<Ticket> tickets = new LinkedList();

		tickets.add(new Ticket("LPS-00001", "LPE-0001", "CVE-2021-33813", 1, "7.2.10", "7.2.x"));
		tickets.add(new Ticket("LPS-00002", "LPE-0002", "CVE-2021-30468", 2, "7.3.10", "7.3.x"));

		List<Object> result = new LinkedList();

		result.add(vulnerabilities);
		result.add(tickets);

		return result;
	}
}
