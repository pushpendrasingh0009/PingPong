package com.github.diwakar1988.pinpong.model;

import com.github.diwakar1988.pinpong.exceptions.InvalidTimeSlotException;

public class Player {

	private String name;
	private TimeSlot timeSlot;

	public Player(String name, int startTime, int endTime) throws InvalidTimeSlotException{
		this.name = name;
		this.timeSlot = new TimeSlot(startTime, endTime);
	}

	public String getName() {
		return name;
	}

	public TimeSlot getTimeSlot() {
		return timeSlot;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(getName());
		sb.append(" ");
		sb.append(getTimeSlot());
		return sb.toString();
	}
	@Override
	public int hashCode() {
		int code = 31 * (timeSlot.hashCode() + name.hashCode());
		return code;
	}
	@Override
	public boolean equals(Object obj) {
		if (obj==this) {
			return true;
		}
		if (!(obj instanceof Player)) {
			return false;
		}
		Player p= (Player) obj;
		return p.getTimeSlot().equals(this.getTimeSlot()) && p.getName().equalsIgnoreCase(this.getName());
	}
}
