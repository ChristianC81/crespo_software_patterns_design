package com.dp.crespo_software_patterns_design.STRATEGY;

import java.util.Random;


/*

STRATEGY - 6. En un videojuego, los enemigos pueden comportarse de forma agresiva, defensiva o aleatoria, 
y ese comportamiento debe poder cambiar mientras la partida está en curso.

*/

public class EnemyBehaviorDemo {

	interface Behavior {
		String act();
	}

	static class AggressiveBehavior implements Behavior {
		@Override
		public String act() {
			return "Ataca de frente";
		}
	}

	static class DefensiveBehavior implements Behavior {
		@Override
		public String act() {
			return "Se protege";
		}
	}

	static class RandomBehavior implements Behavior {
		private final Random random = new Random();

		@Override
		public String act() {
			return random.nextBoolean() ? "Ataca" : "Esquiva";
		}
	}

	static class Enemy {
		private Behavior behavior;

		Enemy(Behavior behavior) {
			this.behavior = behavior;
		}

		void setBehavior(Behavior behavior) {
			this.behavior = behavior;
		}

		void move() {
			System.out.println(behavior.act());
		}
	}

	public static void main(String[] args) {
		Enemy enemy = new Enemy(new AggressiveBehavior());
		enemy.move();
		enemy.setBehavior(new DefensiveBehavior());
		enemy.move();
		enemy.setBehavior(new RandomBehavior());
		enemy.move();
	}
}