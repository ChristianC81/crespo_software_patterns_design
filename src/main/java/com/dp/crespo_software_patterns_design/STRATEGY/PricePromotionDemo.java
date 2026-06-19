package com.dp.crespo_software_patterns_design.STRATEGY;

/*

STRATEGY - 2. Una tienda calcula el precio final aplicando promociones que cambian por temporada (Black Friday, 2x1, sin promo). 
Marketing quiere poder añadir promos nuevas sin reescribir el checkout.

*/
public class PricePromotionDemo {

	interface PromotionStrategy {
		double apply(double price);
	}

	static class BlackFridayPromotion implements PromotionStrategy {
		@Override
		public double apply(double price) {
			return price * 0.7;
		}
	}

	static class TwoForOnePromotion implements PromotionStrategy {
		@Override
		public double apply(double price) {
			return price / 2;
		}
	}

	static class NoPromotion implements PromotionStrategy {
		@Override
		public double apply(double price) {
			return price;
		}
	}

	static class Checkout {
		private PromotionStrategy promotionStrategy;

		Checkout(PromotionStrategy promotionStrategy) {
			this.promotionStrategy = promotionStrategy;
		}

		void setPromotionStrategy(PromotionStrategy promotionStrategy) {
			this.promotionStrategy = promotionStrategy;
		}

		double finalPrice(double price) {
			return promotionStrategy.apply(price);
		}
	}

	public static void main(String[] args) {
		Checkout checkout = new Checkout(new BlackFridayPromotion());
		System.out.println("Precio Black Friday: " + checkout.finalPrice(100));

		checkout.setPromotionStrategy(new TwoForOnePromotion());
		System.out.println("Precio 2x1: " + checkout.finalPrice(100));

		checkout.setPromotionStrategy(new NoPromotion());
		System.out.println("Precio sin promo: " + checkout.finalPrice(100));
	}
}