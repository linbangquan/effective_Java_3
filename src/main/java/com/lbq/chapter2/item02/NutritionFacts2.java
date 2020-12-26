package com.lbq.chapter2.item02;
/**
 * JavaBeans模式，先调用一个无参构造器来创建对象，然后再调用setter方法设置每个必要的参数，以及每个相关的可选参数。
 * 遗憾的是，JavaBeans模式自身有着很严重的缺点。因为构造过程被分到了几个调用中，在构造过程中JavaBean可能处于不一致的状态。类无法仅仅通过检验构造器参数的有效性来保证一致性。
 * JavaBeans模式使得把类做成不可变的可能性不复存在，这就需要程序员付出额外的努力来确保它的线程安全。
 * @author 14378
 *
 */
public class NutritionFacts2 {

	private int servingSize = -1;	// (ml)				required
	private int servings = -1;	// (per container)	required
	private int calories = 0;		// (per serving)	optional
	private int fat = 0;			// (g/serving)		optional
	private int sodium = 0;		// (mg/serving)		optional
	private int carbohydrate = 0;	// (g/serving)		optional
	
	public NutritionFacts2() {}

	public void setServingSize(int servingSize) {
		this.servingSize = servingSize;
	}

	public void setServings(int servings) {
		this.servings = servings;
	}

	public void setCalories(int calories) {
		this.calories = calories;
	}

	public void setFat(int fat) {
		this.fat = fat;
	}

	public void setSodium(int sodium) {
		this.sodium = sodium;
	}

	public void setCarbohydrate(int carbohydrate) {
		this.carbohydrate = carbohydrate;
	}

	public static void main(String[] args) {
		NutritionFacts2 cocaCola = new NutritionFacts2();
		cocaCola.setServingSize(240);
		cocaCola.setServings(8);
		cocaCola.setCalories(100);
		cocaCola.setSodium(35);
		cocaCola.setCarbohydrate(27);
	}

}
