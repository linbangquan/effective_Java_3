package com.lbq.chapter2.item02;

public class Calzone extends Pizza {

	private final boolean sauceInside;
	
	public static class Builder extends Pizza.Builder<Builder>{

		private boolean sauceInside = false; //default
		public Builder sauceInside() {
			sauceInside = true;
			return this;
		}
		@Override
		Calzone build() {
			return new Calzone(this);
		}

		@Override
		protected Builder self() {
			return this;
		}
		
	}
	private Calzone(Builder builder) {
		super(builder);
		sauceInside = builder.sauceInside;
	}
	public static void main(String[] args) {
		Calzone calzone = new Calzone.Builder()
				.addTopping(Topping.HAM)
				.sauceInside()
				.build();
	}
}
