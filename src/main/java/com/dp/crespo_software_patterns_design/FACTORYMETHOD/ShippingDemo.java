package com.dp.crespo_software_patterns_design.FACTORYMETHOD;

/*

FACTORY METHOD - 9. Una plataforma de logística debe usar el transportista adecuado (terrestre, marítimo o aéreo) según la ruta. 
La planificación del envío es siempre la misma; lo único que varía es el medio que se instancia.

*/

public class ShippingDemo {

	interface Transport {
		String ship();
	}

	abstract static class ShippingPlanner {
		public final void planShipping() {
			Transport transport = createTransport();
			System.out.println("Planificando envio");
			System.out.println(transport.ship());
		}

		protected abstract Transport createTransport();
	}

	static class Truck implements Transport {
		@Override
		public String ship() {
			return "Enviando por tierra";
		}
	}

	static class Ship implements Transport {
		@Override
		public String ship() {
			return "Enviando por mar";
		}
	}

	static class Plane implements Transport {
		@Override
		public String ship() {
			return "Enviando por aire";
		}
	}

	static class LandShippingPlanner extends ShippingPlanner {
		@Override
		protected Transport createTransport() {
			return new Truck();
		}
	}

	static class SeaShippingPlanner extends ShippingPlanner {
		@Override
		protected Transport createTransport() {
			return new Ship();
		}
	}

	static class AirShippingPlanner extends ShippingPlanner {
		@Override
		protected Transport createTransport() {
			return new Plane();
		}
	}

	public static void main(String[] args) {
		new LandShippingPlanner().planShipping();
		new SeaShippingPlanner().planShipping();
		new AirShippingPlanner().planShipping();
	}
}