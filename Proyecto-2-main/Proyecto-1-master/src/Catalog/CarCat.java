package Catalog;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.ArrayList;

import Catalog.Carro;

public class CarCat {
	
	private ArrayList<Carro> carros;
	

	public CarCat() {
		carros = new ArrayList<Carro>();
			
	}

	public void agregarCarro(Carro carro) {
		carros.add(carro);
		try (FileWriter fichero = new FileWriter("Data/carros.txt"))
        {
            PrintWriter pw = new PrintWriter(fichero);

            for ( Carro element : carros)
                pw.println(element.getid());

        } catch (Exception e) {
            e.printStackTrace();
        }
	
	}

	public Carro buscarCarro(Integer ID) {
		for (Carro carro : carros) {
			if (carro.getid().equals(ID) ) {
				return carro;
			}
		}
		return null;
	}
	
	public void eliminarCarro(Integer ID) {
		Carro carro = buscarCarro(ID);
		if (carro != null) {
			carros.remove(carro);
		}
	}

	public ArrayList<Carro> listarCarros() {
		return carros;
	}

	public void resumenCatalogo() {
		System.out.println("Catálogo de carros:");
		for (Carro carro : carros) {
			System.out.println(carro);
		}
	
	}

	public void cambiarLugar(Integer ID, String newPOS) {
		Carro carro = buscarCarro(ID);
		if (carro != null) {
			carro.setPOS(newPOS);
		}
	}

	public void cambiarAvailable(Integer ID, boolean newAvailable) {
		Carro carro = buscarCarro(ID);
		if (carro != null) {
			carro.setAvailable(newAvailable);
		}
	}

	public void cambiarEstado(Integer ID, String newState) {
		Carro carro = buscarCarro(ID);
		if (carro != null) {
			carro.setState(newState);
		}
	}
}