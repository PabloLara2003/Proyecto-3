package Catalog;

import java.util.ArrayList;

public class Carro {
		private Integer ID;
		private String Plates;
		private String Category;
		private String Brand;
		private String Model;
		private Float Kilometrage;
		private Boolean Available;
		private String State;
		private String POS;
		private String Color;
		
		public Carro(Integer ID, String Plates, String Category, String Brand, String Model, Float Kilometrage, Boolean Available, String State, String POS, String Color) {
			this.ID = ID;
			this.Plates = Plates;
			this.Category = Category;
			this.Brand = Brand;
			this.Model = Model;
			this.Kilometrage = Kilometrage;
			this.Available = Available;
			this.State = State;
			this.POS = POS;
			this.Color = Color;
		}
		
		public Integer getid() {
			return ID;
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
			return "ID: " + ID + ", Plates: " + Plates + ", Category: " + Category + ", Brand: " + Brand + ", Model: " + Model + ", Kilometrage: " + Kilometrage + ", Available: " + Available + ", State: " + State + ", POS: " + POS + ", Color: " + Color;
		}
}
