package Principal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import Principal.DAO.DestinosDAO;
import Principal.DAO.ReservasDAO;
import Principal.DAO.UsuariosDAO;

public class Main {

	public static void main(String[] args) {
		 Scanner scanner = new Scanner(System.in);
	        DestinosDAO destinoDAO = new DestinosDAO();
	        UsuariosDAO usuarioDAO = new UsuariosDAO();
	        ReservasDAO reservaDAO = new ReservasDAO();

	        while (true) {
	            System.out.println("\nSistema de Gestão de Viagens");
	            System.out.println("1. Cadastrar Destino");
	            System.out.println("2. Listar Destino");
	            System.out.println("3. Atualizar Destino");
	            System.out.println("4. Excluir Destino");
	            System.out.println("5. Cadastrar Usuario");
	            System.out.println("6. Listar Usuarios");
	            System.out.println("7. Atualizar Usuario");
	            System.out.println("8. Excluir Usuario");
	            System.out.println("9. Cadastrar Reserva");
	            System.out.println("10. Listar Reservas");
	            System.out.println("11. Atualizar Reserva");
	            System.out.println("12. Excluir Reserva");
	            System.out.println("13. Sair");
	            System.out.print("Escolha uma opção: ");

	            int opcao = scanner.nextInt();

	            switch (opcao) {
	                case 1:
	                    // Cadastrar Destino
	                    Destinos destino = new Destinos();
	                    System.out.print("Nome do Destino: ");
	                    scanner.nextLine(); // Limpar o buffer do teclado
	                    destino.setNomeDestino(scanner.nextLine());
	                    System.out.print("Descrição: ");
	                    destino.setDescricaoDestino(scanner.nextLine());
	                    destinoDAO.criarDestino(destino);
	                    System.out.println("Destino cadastrado com sucesso!");
	                    break;
	                case 2:
	                    // Listar Destinos
	                    List<Destinos> destinos = destinoDAO.listarDestinos();
	                    System.out.println("Lista de Destinos:");
	                    for (Destinos m : destinos) {
	                        System.out.println("ID: " + m.getIdDestino() +
	                                ", Nome: " + m.getNomeDestino() +
	                                ", Descrição: " + m.getDescricaoDestino());
	                    }
	                    break;
	                case 3:
	                    // Atualizar Destinos
	                    System.out.print("ID do Destino para atualização: ");
	                    int destinoIdAtualizar = scanner.nextInt();
	                    Destinos destinoAtualizar = destinoDAO.buscarDestino(destinoIdAtualizar);
	                    if (destinoAtualizar != null) {
	                        System.out.print("Novo Nome do Destino: ");
	                        scanner.nextLine(); // Limpar o buffer do teclado
	                        destinoAtualizar.setNomeDestino(scanner.nextLine());
	                        System.out.print("Nova Descrição: ");
	                        destinoAtualizar.setDescricaoDestino(scanner.nextLine());
	                        destinoDAO.atualizarDestino(destinoAtualizar);
	                        System.out.println("Destino atualizado com sucesso!");
	                    } else {
	                        System.out.println("Destino não encontrado.");
	                    }
	                    break;
	                case 4:
	                    // Excluir Destino
	                    System.out.print("ID do Destino para exclusão: ");
	                    int destinoIdExcluir = scanner.nextInt();
	                    Destinos destinoExcluir = destinoDAO.buscarDestino(destinoIdExcluir);
	                    if (destinoExcluir != null) {
	                        destinoDAO.excluirDestino(destinoIdExcluir);
	                        System.out.println("Destino excluído com sucesso!");
	                    } else {
	                        System.out.println("Destino não encontrado.");
	                    }
	                    break;
	                case 5:
	                    // Cadastrar Usuario
	                    Usuarios usuario = new Usuarios();
	                    System.out.print("Nome do Usuario: ");
	                    scanner.nextLine(); // Limpar o buffer do teclado
	                    usuario.setNomeUsuario(scanner.nextLine());
	                    System.out.print("CPF: ");
	                    usuario.setCpfUsuario(scanner.nextLine());
	                    System.out.print("Email: ");
	                    usuario.setEmailUsuario(scanner.nextLine());
	                    System.out.print("Telefone: ");
	                    usuario.setTelefoneUsuario(scanner.nextLine());
	                    usuarioDAO.criarUsuario(usuario);
	                    System.out.println("Usuario cadastrado com sucesso!");
	                    break;
	                case 6:
	                    // Listar Usuarios
	                    List<Usuarios> usuarios = usuarioDAO.listarUsuarios();
	                    System.out.println("Lista de Usuarios:");
	                    for (Usuarios p : usuarios) {
	                        System.out.println("ID: " + p.getIdUsuario() +
	                                ", Nome: " + p.getNomeUsuario() +
	                                ", CPF: " + p.getCpfUsuario()+
	                        		", Email: " + p.getEmailUsuario()+
	                        		", Telefone: " + p.getTelefoneUsuario());
	                        
	 
	                    }
	                    break;
	                case 7:
	                    // Atualizar Usuario
	                    System.out.print("ID do Usuario para atualização: ");
	                    int usuarioIdAtualizar = scanner.nextInt();
	                    Usuarios usuarioAtualizar = usuarioDAO.buscarUsuario(usuarioIdAtualizar);
	                    if (usuarioAtualizar != null) {
	                        System.out.print("Novo Nome do Usuario: ");
	                        scanner.nextLine(); // Limpar o buffer do teclado
	                        usuarioAtualizar.setNomeUsuario(scanner.nextLine());
	                        System.out.print("Novo CPF: ");
	                        usuarioAtualizar.setCpfUsuario(scanner.nextLine());
	                        System.out.print("Novo Email: ");
	                        usuarioAtualizar.setEmailUsuario(scanner.nextLine());
	                        System.out.print("Novo Telefone: ");
	                        usuarioAtualizar.setTelefoneUsuario(scanner.nextLine());
	                        usuarioDAO.atualizarUsuario(usuarioAtualizar);
	                        System.out.println("Usuario atualizado com sucesso!");
	                    } else {
	                        System.out.println("Usuario não encontrado.");
	                    }
	                    break;
	                case 8:
	                    // Excluir Usuario
	                    System.out.print("ID do Usuario para exclusão: ");
	                    int usuarioIdExcluir = scanner.nextInt();
	                    Usuarios usuarioExcluir = usuarioDAO.buscarUsuario(usuarioIdExcluir);
	                    if (usuarioExcluir != null) {
	                        usuarioDAO.excluirUsuario(usuarioIdExcluir);
	                        System.out.println("Usuario excluído com sucesso!");
	                    } else {
	                        System.out.println("Usuario não encontrado.");
	                    }
	                    break;
	                case 9:
	                    // Cadastrar Reserva
	                    Reservas reserva = new Reservas();
	                    System.out.print("ID do Destino: ");
	                    int destinoId = scanner.nextInt();
	                    Destinos destinoConsulta = destinoDAO.buscarDestino(destinoId);
	                    if (destinoConsulta != null) {
	                    	reserva.setDestinos(destinoConsulta);
	                        System.out.print("ID do Usuario: ");
	                        int usuarioId = scanner.nextInt();
	                        Usuarios usuarioConsulta = usuarioDAO.buscarUsuario(usuarioId);
	                        if (usuarioConsulta != null) {
	                        	reserva.setUsuarios(usuarioConsulta);
	                            System.out.print("Data da Reserva (dd/mm/yyyy): ");
	                            String dataString = scanner.next();
	                            try {
	                                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	                                Date dataReserva = sdf.parse(dataString);
	                                reserva.setDataDestino(dataReserva);
	                                
	                                
	                                System.out.print("Status: ");
	                                scanner.nextLine(); // Limpar o buffer do teclado
	                                reserva.setStatusReserva(scanner.nextLine());
	                                
	                                reservaDAO.criarReservas(reserva);
	                                
	                                System.out.println("Reserva cadastrada com sucesso!");
	                            } catch (ParseException e) {
	                                System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
	                            }
	                        } else {
	                            System.out.println("Usuario não encontrado.");
	                        }
	                    } else {
	                        System.out.println("Destino não encontrado.");
	                    }
	                    break;
	                case 10:
	                	// Listar Reservas
	                    List<Reservas> reservas = reservaDAO.listarReservas();
	                    System.out.println("Lista de Reservas:");
	                    for (Reservas c : reservas) {
	                        System.out.println("ID: " + c.getIdReserva() +
	                                ", Destino: " + c.getDestinos().getNomeDestino() +
	                                ", Usuario: " + c.getUsuarios().getNomeUsuario() +
	                                ", Data: " + c.getDataDestino() +
	                        		", Status: " + c.getStatusReserva());
	                    }
	                    break;
	                case 11:
	                	// Atualizar Reservas
	                    System.out.print("ID da Reserva para atualização: ");
	                    int reservaId = scanner.nextInt();
	                    Reservas reservaAtualizar = reservaDAO.buscarReserva(reservaId);
	                    if (reservaAtualizar != null) {
	                        System.out.print("Nova Data da Reserva (dd/mm/yyyy): ");
	                        String novaDataString = scanner.next();
	                        try {
	                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
	                            Date novaDataReserva = sdf.parse(novaDataString);
	                            reservaAtualizar.setDataDestino(novaDataReserva);
	                            reservaAtualizar.setStatusReserva(reservaAtualizar.getStatusReserva());
	                            reservaDAO.atualizarReservas(reservaAtualizar);
	                            System.out.println("Reserva atualizada com sucesso!");
	                        } catch (ParseException e) {
	                            System.out.println("Formato de data inválido. Use dd/mm/yyyy.");
	                        }
	                    } else {
	                        System.out.println("Reserva não encontrada.");
	                    }
	                    break;
	                case 12:
	                	// Excluir Reserva
	                    System.out.print("ID da Reserva para exclusão: ");
	                    int reservaIdExcluir = scanner.nextInt();
	                    Reservas reservaExcluir = reservaDAO.buscarReserva(reservaIdExcluir);
	                    if (reservaExcluir != null) {
	                        reservaDAO.excluirConsulta(reservaIdExcluir);
	                        System.out.println("Reserva excluída com sucesso!");
	                    } else {
	                        System.out.println("Reserva não encontrada.");
	                    }
	                    break;
	                case 13:
	                    // Sair
	                    System.out.println("Saindo do sistema...");
	                    reservaDAO.fecharConexao();
	                    usuarioDAO.fecharConexao();
	                    destinoDAO.fecharConexao();
	                    scanner.close();
	                    System.exit(0);
	                default:
	                    System.out.println("Opção inválida. Tente novamente.");
	                    break;
	            }
	        }
	    }

}
