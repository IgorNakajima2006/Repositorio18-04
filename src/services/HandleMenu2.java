package services;

import java.util.List;
import java.util.Scanner;

import models.Usuario;
import utils.GerenciadordeUsuarios;

public class HandleMenu2 {

	   Scanner sc = new Scanner(System.in);
	    GerenciadordeUsuarios gs = new GerenciadordeUsuarios();

	    public void HandleMenu() {
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
	        System.out.println("Digite o ID do usuário:");
	        int id = sc.nextInt();
	        System.out.println("Digite o novo nome:");
	        String nome = sc.next();
	        System.out.println("Digite a nova senha:");
	        String senha = sc.next();
	        gs.editarUsuario(id, nome, senha);
	    }

	    public void deletar() {
	        System.out.println("Digite o ID do usuário a ser deletado:");
	        int id = sc.nextInt();
	        gs.deletarUsuario(id);
	    }

	    public void listar() {
	        gs.listarUsuarios();
	    }

	    public void buscarUnico() {
	        System.out.println("Digite o ID da busca:");
	        int id = sc.nextInt();
	        Usuario usuario = gs.buscarUsuario(id);
	        if (usuario != null) {
	            System.out.println("Usuário encontrado:");
	            System.out.println(usuario);
	        } else {
	            System.out.println("Usuário não encontrado.");
	        }
	    }

	    public void listar1() {
	        List<Usuario> usuarios = gs.lerUsuarios();
	        if (usuarios.isEmpty()) {
	            System.out.println("Não há usuários cadastrados.");
	        } else {
	            for (Usuario usuario : usuarios) {
	                System.out.println(usuario);
	            }
	        }
	    }

	    private int getNextId() {
	        List<Usuario> usuarios = gs.lerUsuarios();
	        int maxId = 0;

	        for (Usuario usuario : usuarios) {
	            int id = usuario.getId();
	            if (id > maxId) {
	                maxId = id;
	            }
	        }

	        return maxId + 1;
	    }
	}
