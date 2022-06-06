package br.dell.modelos;

import javax.swing.*;

public class Principal {

	public static void main(String[] args) {
		
		JOptionPane nome = new JOptionPane();
		Hospede hospede = new Hospede(
				JOptionPane.showInputDialog("CPF: "),
				JOptionPane.showInputDialog("RG: "),
				JOptionPane.showInputDialog("Nome: "),
				Integer.parseInt(JOptionPane.showInputDialog("Idade: ")),
				JOptionPane.showInputDialog("Endereço")
				);
		Quarto quarto = new Quarto(
				Integer.parseInt(JOptionPane.showInputDialog("Numero do quarto")),
				hospede
				);
		
        JOptionPane.showMessageDialog(null, "Hospede 1\n"
        		+ hospede.getNome() + "\n"
        		+ hospede.getCpf() + "\n"
        		+ hospede.getEndereco() + "\n"
        		+ "Está hospedado no quarto " + quarto.getNumero());
		
	}

}
