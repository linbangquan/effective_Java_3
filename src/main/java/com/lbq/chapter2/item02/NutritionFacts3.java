package com.lbq.chapter2.item02;
/**
 * 建造者模式，它既能保证像重叠构造器模式那样的安全性，也能保证像JavaBean模式那么好的可读性。
 * @author 14378
 *
 */
public class NutritionFacts3 {

	private final int servingSize;	// (ml)				required
	private final int servings;		// (per container)	required
	private final int calories;		// (per serving)	optional
	private final int fat;			// (g/serving)		optional
	private final int sodium;		// (mg/serving)		optional
	private final int carbohydrate;	// (g/serving)		optional
	
	public static class Builder {
		private final int servingSize;	// (ml)				required
		private final int servings;		// (per container)	required
		private int calories = 0;		// (per serving)	optional
		private int fat = 0;			// (g/serving)		optional
		private int sodium = 0;		// (mg/serving)		optional
		private int carbohydrate = 0;	// (g/serving)		optional
		
		public Builder(int servingSize, int servings) {
			this.servingSize = servingSize;
			this.servings = servings;
		}

		public Builder setCalories(int calories) {
			this.calories = calories;
			return this;
		}

		public Builder setFat(int fat) {
			this.fat = fat;
			return this;
		}

		public Builder setSodium(int sodium) {
			this.sodium = sodium;
			return this;
		}

		public Builder setCarbohydrate(int carbohydrate) {
			this.carbohydrate = carbohydrate;
			return this;
		}
		
		public NutritionFacts3 build() {
			return new NutritionFacts3(this);
		}
	}

	public NutritionFacts3(Builder builder) {
		this.servingSize = builder.servingSize;
		this.servings = builder.servings;
		this.calories = builder.calories;
		this.fat = builder.fat;
		this.sodium = builder.sodium;
		this.carbohydrate = builder.carbohydrate;
	}

	public static void main(String[] args) {
		NutritionFacts3 cocaCola = new NutritionFacts3.Builder(240, 8)
				.setCalories(100)
				.setSodium(35)
				.setCarbohydrate(27)
				.build();

	}

}
