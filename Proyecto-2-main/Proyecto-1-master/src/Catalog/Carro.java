package Catalog;

import java.util.ArrayList;

public class Carro {
		private Integer ID;
		private String Name;
		private String Plates;
		private String Category;
		private String Brand;
		private String Model;
		private String Fuel;
		private Float Kilometrage;
		private Boolean Available;
		private String State;
		private String POS;
		
		public Carro(Integer ID, String Name, String Plates, String Category, String Brand, String Model, String Fuel, Float Kilometrage, Boolean Available, String State, String POS) {
			this.ID = ID;
			this.Name = Name;
			this.Plates = Plates;
			this.Category = Category;
			this.Brand = Brand;
			this.Model = Model;
			this.Fuel = Fuel;
			this.Kilometrage = Kilometrage;
			this.Available = Available;
			this.State = State;
			this.POS = POS;
		}
		
		public Integer getid() {
			return ID;
		}
		
		public String getname() {
			return Name;
		}
		
		public String getplates() {
			return Plates;
		}
		
		public String getcategory() {
			return Category;
		}
		
		public String getbrand() {
			return Brand;
		}
		
		public String getmodel() {
			return Model;
		}
		
		public String getfuel() {
			return Fuel;
		}
		
		public Float getkilometrage() {
			return Kilometrage;

		}
		
		public Boolean getavailable() {
			return Available;
		}
		
		public void setAvailable(Boolean newAvailable) {
			Available = newAvailable;
		}
		
		public String getstate() {
			return State;
		}
		
		public void setState(String newState) {
			State = newState;
		}
		
		public String getpos() {
			return POS;
		}
		
		public void setPOS(String newPOS) {
			POS = newPOS;
		}
		
		public String toString() {
			return "ID: " + ID + ", Name: " + Name + ", Plates: " + Plates + ", Category: " + Category + ", Brand: " + Brand + ", Model: " + Model + ", Fuel: " + Fuel + ", Kilometrage: " + Kilometrage + ", Available: " + Available + ", State: " + State + ", POS: " + POS;
		}
}
