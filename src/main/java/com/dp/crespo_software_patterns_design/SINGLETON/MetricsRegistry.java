package com.dp.crespo_software_patterns_design.SINGLETON;

import java.util.LinkedHashMap;
import java.util.Map;

/*

SINGLETON - 7. Necesitas un registro central de métricas (contadores y tiempos) que toda la aplicación alimente y 
del que exista un único punto de verdad accesible globalmente.

*/

public class MetricsRegistry {
	private static final MetricsRegistry INSTANCE = new MetricsRegistry();

	private final Map<String, Long> counters = new LinkedHashMap<>();
	private final Map<String, Long> timers = new LinkedHashMap<>();

	private MetricsRegistry() {
	}

	public static MetricsRegistry getInstance() {
		return INSTANCE;
	}

	public synchronized void increment(String name) {
		counters.put(name, counters.getOrDefault(name, 0L) + 1);
	}

	public synchronized void addTime(String name, long milliseconds) {
		timers.put(name, timers.getOrDefault(name, 0L) + milliseconds);
	}

	public synchronized void print() {
		System.out.println("Counters: " + counters);
		System.out.println("Timers: " + timers);
	}

	public static void main(String[] args) {
		MetricsRegistry registry = MetricsRegistry.getInstance();
		registry.increment("requests");
		registry.increment("requests");
		registry.addTime("checkout", 25);
		registry.print();
	}
}