package com.lbq.chapter2.item08;

import com.lbq.chapter2.item08.Room.State;

public class Cleaner {

	public class Cleanable {

		private Room room;
		private State state;
		
		public Cleanable(Room room, State state) {
			this.room = room;
			this.state = state;
		}

		public void clean() {
			new Thread(state).start();			
		}

	}

	public static Cleaner create() {
		return new Cleaner();
	}

	public Cleanable register(Room room, State state) {
		return new Cleanable(room, state);
	}

}
