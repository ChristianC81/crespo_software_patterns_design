package com.dp.crespo_software_patterns_design.SINGLETON;

/*

SINGLETON - 1. En tu aplicación hay un pool de conexiones a base de datos costoso de crear. Varios módulos lo necesitan y todos 
deben trabajar contra el mismo recurso compartido. Diséñalo.
	
*/
public class DBConnection {
    private static DBConnection instance;

    private DBConnection() {
        // Constructor privado para evitar instanciación externa
    }

    public static DBConnection getInstance() {
        if (instance == null) {
            instance = new DBConnection();
        }
        return instance;
    }

    public void connect() {
        // Lógica para establecer la conexión a la base de datos
        System.out.println("Conectando a la base de datos...");
    }

    public void disconnect() {
        // Lógica para cerrar la conexión a la base de datos
        System.out.println("Desconectando de la base de datos...");
    }

    public static void main(String[] args) {
        // Obtener la instancia única de DBConnection
        DBConnection dbConnectionMain = DBConnection.getInstance();
        // Verificar que la instancia es la misma en diferentes llamadas
        DBConnection anotherConnection = DBConnection.getInstance(); 

        // Verificar que ambas referencias apuntan a la misma instancia
        if (dbConnectionMain == anotherConnection) {
            System.out.println("Ambas referencias apuntan a la misma instancia.");
            System.out.println("Se simplifica a una misma conexion asi haya dos instancias, se refiere a la misma instancia de DBConnection.");
        }
    }
}
