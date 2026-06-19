package com.dp.crespo_software_patterns_design;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/*
	 
	SINGLETON 1. En tu aplicación hay un pool de conexiones a base de datos costoso de crear. Varios módulos lo necesitan y todos deben trabajar contra el mismo recurso compartido. Diséñalo.
	
	STRATEGY 2. Una tienda calcula el precio final aplicando promociones que cambian por temporada (Black Friday, 2x1, sin promo). Marketing quiere poder añadir promos nuevas sin reescribir el checkout.
	
	ADAPTER 3. Tu sistema de facturación usa una interfaz propia, pero debes integrar un servicio de validación tributaria del gobierno con una firma y un formato de datos totalmente distintos, y no puedes modificar ese servicio.
	
	ABSTRACT FACTORY 4. Tu app debe poder desplegarse tanto en AWS como en Azure. Cada nube ofrece su propio almacenamiento, su cola de mensajes y su base de datos, y bajo ninguna circunstancia deben combinarse piezas de proveedores distintos.
	
	FACTORY METHOD 5. Un editor genera distintos tipos de documento (carta, factura, currículum) según lo que elige el usuario. El flujo de "crear, configurar y abrir" es idéntico para todos; solo cambia el documento concreto que se produce.
	
	STRATEGY 6. En un videojuego, los enemigos pueden comportarse de forma agresiva, defensiva o aleatoria, y ese comportamiento debe poder cambiar mientras la partida está en curso.
	
	SINGLETON 7. Necesitas un registro central de métricas (contadores y tiempos) que toda la aplicación alimente y del que exista un único punto de verdad accesible globalmente.
	
	ADAPTER 8. Quieres reutilizar una librería de gráficos antigua que dibuja con métodos drawLine y drawCircle, pero tu aplicación nueva trabaja con objetos que exponen render().
	
	FACTORY METHOD 9. Una plataforma de logística debe usar el transportista adecuado (terrestre, marítimo o aéreo) según la ruta. La planificación del envío es siempre la misma; lo único que varía es el medio que se instancia.
	
	ABSTRACT FACTORY 10. Un sistema multiplataforma debe generar controles de interfaz (botones, checkboxes, menús) que se vean nativos en Windows, macOS y Linux, garantizando que nunca se mezclen estilos de distintos sistemas operativos
*/

@SpringBootApplication
public class CrespoSoftwarePatternsDesignApplication {

	public static void main(String[] args) {
		SpringApplication.run(CrespoSoftwarePatternsDesignApplication.class, args);
	}

}
