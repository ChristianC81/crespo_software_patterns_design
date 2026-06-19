package com.dp.crespo_software_patterns_design.ABSTRACTFACTORY;

/*

ABSTRACT FACTORY - 10. Un sistema multiplataforma debe generar controles de interfaz (botones, checkboxes, menús) 
que se vean nativos en Windows, macOS y Linux, garantizando que nunca se mezclen estilos de distintos sistemas operativos

*/

public class UIFactoryDemo {

	interface Button {
		String paint();
	}

	interface Checkbox {
		String paint();
	}

	interface Menu {
		String paint();
	}

	interface UIFactory {
		Button createButton();

		Checkbox createCheckbox();

		Menu createMenu();
	}

	static class WindowsButton implements Button {
		@Override
		public String paint() {
			return "Boton Windows";
		}
	}

	static class WindowsCheckbox implements Checkbox {
		@Override
		public String paint() {
			return "Checkbox Windows";
		}
	}

	static class WindowsMenu implements Menu {
		@Override
		public String paint() {
			return "Menu Windows";
		}
	}

	static class WindowsUIFactory implements UIFactory {
		@Override
		public Button createButton() {
			return new WindowsButton();
		}

		@Override
		public Checkbox createCheckbox() {
			return new WindowsCheckbox();
		}

		@Override
		public Menu createMenu() {
			return new WindowsMenu();
		}
	}

	static class MacButton implements Button {
		@Override
		public String paint() {
			return "Boton macOS";
		}
	}

	static class MacCheckbox implements Checkbox {
		@Override
		public String paint() {
			return "Checkbox macOS";
		}
	}

	static class MacMenu implements Menu {
		@Override
		public String paint() {
			return "Menu macOS";
		}
	}

	static class MacUIFactory implements UIFactory {
		@Override
		public Button createButton() {
			return new MacButton();
		}

		@Override
		public Checkbox createCheckbox() {
			return new MacCheckbox();
		}

		@Override
		public Menu createMenu() {
			return new MacMenu();
		}
	}

	static class LinuxButton implements Button {
		@Override
		public String paint() {
			return "Boton Linux";
		}
	}

	static class LinuxCheckbox implements Checkbox {
		@Override
		public String paint() {
			return "Checkbox Linux";
		}
	}

	static class LinuxMenu implements Menu {
		@Override
		public String paint() {
			return "Menu Linux";
		}
	}

	static class LinuxUIFactory implements UIFactory {
		@Override
		public Button createButton() {
			return new LinuxButton();
		}

		@Override
		public Checkbox createCheckbox() {
			return new LinuxCheckbox();
		}

		@Override
		public Menu createMenu() {
			return new LinuxMenu();
		}
	}

	private static void printUi(UIFactory uiFactory) {
		System.out.println(uiFactory.createButton().paint());
		System.out.println(uiFactory.createCheckbox().paint());
		System.out.println(uiFactory.createMenu().paint());
	}

	public static void main(String[] args) {
		printUi(new WindowsUIFactory());
		printUi(new MacUIFactory());
		printUi(new LinuxUIFactory());
	}
}