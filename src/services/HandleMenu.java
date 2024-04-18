package services;

import java.util.List;
import java.util.Scanner;

import models.Usuario;
import utils.GerenciadordeUsuarios;

public class HandleMenu {

	Scanner sc = new Scanner(System.in);
	
	GerenciadordeUsuarios gs = new GerenciadordeUsuarios();
	
	public HandleMenu() {
		gs.verificaECria("usuario.txt");
	}
	
	public void criar() {
		System.out.println("Digite o nome:");
		String nome = sc.next();
		System.out.println("Digite a senha:");
		String senha = sc.next();
		
		int id = getNextId();
		
		Usuario u = new Usuario(id, nome, senha);
		gs.adicionarUsuario(u);
	}
	
	public void editar() {
		System.out.println("Digite o ID do usuario:");
		int id = sc.nextInt();
		System.out.println("Digite o novo nome:");
		String nome = sc.next();
		System.out.println("Digite a nova senha:");
		String senha = sc.next();
		gs.editarUsuario(id,  nome, senha);
	}
	
	public void deletar() {
		System.out.println("Digite o ID do usuario a ser deletado");
		int id = sc.nextInt();
		gs.deletarUsuario(id);
	}
	
	public void listar() {
		gs.listarUsuarios();
	}
	
	public void buscarUnico() {
		System.out.println("Digite o ID da busca:");
		int id = sc.nextInt();
	}
	
	private int getNextId() {
		List<Usuario> usuarios = gs.lerUsuarios();
		int maxId = 0;
		
		for(Usuario usuario : usuarios) {
			int id = usuario.getId();
			if(id > maxId) {
				maxId = id;
			}
		}
		
		return maxId + 1;
	}
}
