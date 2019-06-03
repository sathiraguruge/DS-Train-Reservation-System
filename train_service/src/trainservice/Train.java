package trainservice;

import java.io.Serializable;
import java.util.Date;

public class Train implements Serializable{

	private int id;
	private String train;
	private String trainName;
	private String trainNo;
	private String arrival;
	private String departure;
	private double price;
	
	public Train() {}
	
	public Train(int id, String train, String trainName, String trainNo,  String arrival,  String departure, double price) {
		this.id = id;
		this.train = train;
		this.trainName = trainName;
		this.trainNo = trainNo;
		this.arrival = arrival;
		this.departure = departure;
		this.price = price;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTrain() {
		return train;
	}

	public void setTrain(String train) {
		this.train = train;
	}

	public String getTrainName() {
		return trainName;
	}

	public void setTrainName(String trainName) {
		this.trainName = trainName;
	}

	public String getTrainNo() {
		return trainNo;
	}

	public void setTrainNo(String trainNo) {
		this.trainNo = trainNo;
	}

	public String getArrival() {
		return arrival;
	}

	public void setArrival(String arrival) {
		this.arrival = arrival;
	}

	public String getDeparture() {
		return departure;
	}

	public void setDeparture(String departure) {
		this.departure = departure;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
}
