package com.dp.crespo_software_patterns_design.ADAPTER;

/*

ADAPTER - 8. Quieres reutilizar una librería de gráficos antigua que dibuja con métodos drawLine y drawCircle, 
pero tu aplicación nueva trabaja con objetos que exponen render().

*/

public class LegacyGraphicsAdapterDemo {

	interface Drawable {
		void render();
	}

	static class LegacyGraphicsLibrary {
		void drawLine() {
			System.out.println("Dibujando linea");
		}

		void drawCircle() {
			System.out.println("Dibujando circulo");
		}
	}

	static class LegacyGraphicsAdapter implements Drawable {
		private final LegacyGraphicsLibrary legacyGraphicsLibrary;

		LegacyGraphicsAdapter(LegacyGraphicsLibrary legacyGraphicsLibrary) {
			this.legacyGraphicsLibrary = legacyGraphicsLibrary;
		}

		@Override
		public void render() {
			legacyGraphicsLibrary.drawLine();
			legacyGraphicsLibrary.drawCircle();
		}
	}

	public static void main(String[] args) {
		Drawable drawable = new LegacyGraphicsAdapter(new LegacyGraphicsLibrary());
		drawable.render();
	}
}