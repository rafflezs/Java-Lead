package br.dell.modelos;

import java.util.InputMismatchException;

import javax.swing.*;

public class Principal {

	public static void main(String[] args) {
		
		Hospede hospede = null;
		
		// Como o valor de idade (e quarto) recebe parse String_to_Int, o Exception 
		// utilizado deve ser NumberFormatException e não InputMismatchException
		
		String nome = null;
		long cpf = 0;
		long rg = 0;
		int idade = 0;
		String endereco = null;
		
		try {
			nome = JOptionPane.showInputDialog("Nome: ");
			cpf = Long.parseLong(JOptionPane.showInputDialog("CPF: "));
			rg = Long.parseLong(JOptionPane.showInputDialog("RG: "));
			idade = Integer.parseInt(JOptionPane.showInputDialog("Idade: "));
			endereco = JOptionPane.showInputDialog("Endereço");
			
			while(validarNome(nome) == false) {
				JOptionPane.showMessageDialog(null, "Por favor, digite um nome valido");
				nome = JOptionPane.showInputDialog("Nome: ");
			}
			
		}catch(NumberFormatException e) { 
			JOptionPane.showMessageDialog(null,"Favor, inserir apenas numeros: " + e.getMessage());
		}catch(InputMismatchException e) { 
			JOptionPane.showMessageDialog(null,"O valor inserido deve ser numerico: " + e.getMessage());
		} finally {
			hospede = new Hospede(
					cpf,
					rg,
					nome,
					idade,
					endereco
				);
		}
		
		Quarto quarto = null;
		try { 
			quarto = new Quarto(
				Integer.parseInt(JOptionPane.showInputDialog("Numero do quarto")),
				hospede
			);
		}catch(NumberFormatException e) {
		    JOptionPane.showMessageDialog(null,"O valor inserido deve ser numerico: " + e.getMessage());
		} finally {
			JOptionPane.showMessageDialog(null, "Hospede 1\n"
        		+ hospede.getNome() + "\n"
        		+ hospede.getCpf() + "\n"
        		+ hospede.getEndereco() + "\n"
        		+ "Está hospedado no quarto " + quarto.getNumero()
			);	
		}
	}
	
	
	private static Boolean validarNome(String nome) {
	    String expression = "^[a-zA-Z\\s]+"; 
	    if(!nome.matches(expression)) 
	    	return false;
	    return true;
	}
	
	
}
