package com.dp.crespo_software_patterns_design.ABSTRACTFACTORY;

/*

ABSTRACT FACTORY - 4. Tu app debe poder desplegarse tanto en AWS como en Azure. Cada nube ofrece su propio almacenamiento, 
su cola de mensajes y su base de datos, y bajo ninguna circunstancia deben combinarse piezas de proveedores distintos.

*/

public class CloudInfrastructureDemo {

	interface Storage {
		String store();
	}

	interface QueueService {
		String queue();
	}

	interface Database {
		String database();
	}

	interface CloudFactory {
		Storage createStorage();

		QueueService createQueueService();

		Database createDatabase();
	}

	static class AwsStorage implements Storage {
		@Override
		public String store() {
			return "S3";
		}
	}

	static class AwsQueueService implements QueueService {
		@Override
		public String queue() {
			return "SQS";
		}
	}

	static class AwsDatabase implements Database {
		@Override
		public String database() {
			return "RDS";
		}
	}

	static class AwsCloudFactory implements CloudFactory {
		@Override
		public Storage createStorage() {
			return new AwsStorage();
		}

		@Override
		public QueueService createQueueService() {
			return new AwsQueueService();
		}

		@Override
		public Database createDatabase() {
			return new AwsDatabase();
		}
	}

	static class AzureStorage implements Storage {
		@Override
		public String store() {
			return "Blob Storage";
		}
	}

	static class AzureQueueService implements QueueService {
		@Override
		public String queue() {
			return "Queue Storage";
		}
	}

	static class AzureDatabase implements Database {
		@Override
		public String database() {
			return "Azure SQL";
		}
	}

	static class AzureCloudFactory implements CloudFactory {
		@Override
		public Storage createStorage() {
			return new AzureStorage();
		}

		@Override
		public QueueService createQueueService() {
			return new AzureQueueService();
		}

		@Override
		public Database createDatabase() {
			return new AzureDatabase();
		}
	}

	private static void printFamily(CloudFactory cloudFactory) {
		System.out.println(cloudFactory.createStorage().store());
		System.out.println(cloudFactory.createQueueService().queue());
		System.out.println(cloudFactory.createDatabase().database());
	}

	public static void main(String[] args) {
		printFamily(new AwsCloudFactory());
		printFamily(new AzureCloudFactory());
	}
}