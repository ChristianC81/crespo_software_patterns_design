package com.dp.crespo_software_patterns_design.ADAPTER;

/*

ADAPTER - 3. Tu sistema de facturación usa una interfaz propia, pero debes integrar un servicio de validación tributaria del 
gobierno con una firma y un formato de datos totalmente distintos, y no puedes modificar ese servicio.

*/

public class TaxValidationAdapterDemo {

	interface TaxValidator {
		boolean validate(String taxpayerId, double amount);
	}

	static class GovernmentTaxService {
		boolean verifyTax(String identification, String payload) {
			return identification != null && !identification.isBlank() && payload.contains("amount");
		}
	}

	static class GovernmentTaxServiceAdapter implements TaxValidator {
		private final GovernmentTaxService governmentTaxService;

		GovernmentTaxServiceAdapter(GovernmentTaxService governmentTaxService) {
			this.governmentTaxService = governmentTaxService;
		}

		@Override
		public boolean validate(String taxpayerId, double amount) {
			return governmentTaxService.verifyTax(taxpayerId, "amount=" + amount);
		}
	}

	public static void main(String[] args) {
		TaxValidator validator = new GovernmentTaxServiceAdapter(new GovernmentTaxService());
		System.out.println("Factura valida: " + validator.validate("1234567890", 150.0));
	}
}