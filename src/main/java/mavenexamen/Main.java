package mavenexamen;

import java.util.Scanner;

import javax.persistence.EntityManager;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		EntityManager em=Conn.getInstancia().getFactory().createEntityManager();
		
	//Se ingreso los 3 Doctores , si quito los comentarios se iniciara cada vez que ejecute los mismos  por eso lo comento
/*
 		Doctore DCPablo = new Doctore();
		DCPablo.setNomDoctor("Pablo");
		DCPablo.setEspecialidadDoctor("Cardiologo");
		
		em.getTransaction().begin();
		em.persist(DCPatricio);
		em.getTransaction().commit()
 		
		
		
	Doctore DCPatricio = new Doctore();
		DCPatricio.setNomDoctor("Patricio");
		DCPatricio.setEspecialidadDoctor("Cancerologo");
		
		em.getTransaction().begin();
		em.persist(DCPatricio);
		em.getTransaction().commit(); 
		

		
		Doctore DCPedro = new Doctore();
		DCPedro.setNomDoctor("Pedro");
		DCPedro.setEspecialidadDoctor("Anestesiologo");
		
		em.getTransaction().begin();
		em.persist(DCPedro);
		em.getTransaction().commit();
		
		
		
		System.out.println("Se ingreso los 3 doctores");
		
	*/	
		
	     Scanner scanner = new Scanner(System.in);
	        boolean salir = false;
	        
		while (!salir) {
            System.out.println("Seleccione una opci�n:");
            System.out.println("1. Ingresar Cita");
            System.out.println("2. Mostrar Citas del doctor");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    // Ejecutar c�digo para ingresar cita
                    break;
                case 2:
                    // Ejecutar c�digo para mostrar citas del doctor
                    break;
                case 3:
                    salir = true;
                    break;
                default:
                    System.out.println("Opci�n inv�lida.");
            }
		
		}
		
		
	}

}
