package com.dp.crespo_software_patterns_design.FACTORYMETHOD;

/*

FACTORY METHOD - 5. Un editor genera distintos tipos de documento (carta, factura, currículum) según lo que elige el usuario. 
El flujo de "crear, configurar y abrir" es idéntico para todos; solo cambia el documento concreto que se produce.

*/
public class DocumentFactoryDemo {

	interface Document {
		void configure();

		void open();
	}

	abstract static class DocumentCreator {
		public final void createAndOpen() {
			Document document = createDocument();
			document.configure();
			document.open();
		}

		protected abstract Document createDocument();
	}

	static class Letter implements Document {
		@Override
		public void configure() {
			System.out.println("Configurando carta");
		}

		@Override
		public void open() {
			System.out.println("Abriendo carta");
		}
	}

	static class Invoice implements Document {
		@Override
		public void configure() {
			System.out.println("Configurando factura");
		}

		@Override
		public void open() {
			System.out.println("Abriendo factura");
		}
	}

	static class Resume implements Document {
		@Override
		public void configure() {
			System.out.println("Configurando curriculum");
		}

		@Override
		public void open() {
			System.out.println("Abriendo curriculum");
		}
	}

	static class LetterCreator extends DocumentCreator {
		@Override
		protected Document createDocument() {
			return new Letter();
		}
	}

	static class InvoiceCreator extends DocumentCreator {
		@Override
		protected Document createDocument() {
			return new Invoice();
		}
	}

	static class ResumeCreator extends DocumentCreator {
		@Override
		protected Document createDocument() {
			return new Resume();
		}
	}

	public static void main(String[] args) {
		new LetterCreator().createAndOpen();
		new InvoiceCreator().createAndOpen();
		new ResumeCreator().createAndOpen();
	}
}