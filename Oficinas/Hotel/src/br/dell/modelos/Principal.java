package br.dell.modelos;

import java.util.InputMismatchException;

import javax.swing.*;

public class Principal {

	public static void main(String[] args) {
		
		Hospede hospede = null;
		
		// Como o valor de idade (e quarto) recebe parse, o Exception utilizado deve ser
	    // NumberFormatException e não InputMismatchException
		
		try {
			new Hospede(
				Long.parseLong(JOptionPane.showInputDialog("CPF: ")),
				Long.parseLong(JOptionPane.showInputDialog("RG: ")),
				JOptionPane.showInputDialog("Nome: "),
				Integer.parseInt(JOptionPane.showInputDialog("Idade: ")),
				JOptionPane.showInputDialog("Endereço")
			);
		}catch(NumberFormatException e) { 
			JOptionPane.showMessageDialog(null,"O valor inserido deve ser numerico: " + e.getMessage());
		}
		
		
		Quarto quarto = null;
		try { 
			quarto = new Quarto(
				Integer.parseInt(JOptionPane.showInputDialog("Numero do quarto")),
				hospede
			);
		}catch(NumberFormatException e) {
		    JOptionPane.showMessageDialog(null,"O valor inserido deve ser numerico: " + e.getMessage());
		}

        JOptionPane.showMessageDialog(null, "Hospede 1\n"
        		+ hospede.getNome() + "\n"
        		+ hospede.getCpf() + "\n"
        		+ hospede.getEndereco() + "\n"
        		+ "Está hospedado no quarto " + quarto.getNumero()
        );	
	}
	
	
}
