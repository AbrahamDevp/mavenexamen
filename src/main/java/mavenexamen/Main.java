package mavenexamen;
import mavenexamen.Cita;

import java.time.LocalDate;
import java.util.Scanner;
import java.util.List;

import javax.persistence.EntityManager;



public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	//Este es el primer mensaje un comentario para un commit en git
		
		
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
	        boolean opciones = false;
	        
		while (!opciones) {
            System.out.println("Seleccione una opción:");
            System.out.println("1. Ingresar Cita");
            System.out.println("2. Mostrar Citas del doctor");
            System.out.println("3. Salir");

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                	   System.out.println("Ingrese el número de cita:");
                       int numCita = scanner.nextInt();
                       System.out.println("Ingrese la fecha de la cita (en formato yyyy-mm-dd):");
                       String fechaCita = scanner.next();
                       System.out.println("Ingrese el nombre del paciente:");
                       String nomPaciente = scanner.next();
                       System.out.println("Ingrese el nombre del doctor:");
                       String nomDoctor = scanner.next();

                       Cita cita = new Cita();
                       cita.setNumCita(numCita);
                       cita.setFechaCita(LocalDate.parse(fechaCita));
                       cita.setNomPacienteCita(nomPaciente);

                       Doctore doctor = em.createQuery("SELECT d FROM Doctore d WHERE d.nomDoctor = :nombreDoctor", Doctore.class)
                               .setParameter("nombreDoctor", nomDoctor)
                               .getSingleResult();
                       cita.setDoctore(doctor);

                       em.getTransaction().begin();
                       em.persist(cita);
                       em.getTransaction().commit();

                       System.out.println("Cita ingresada correctamente");
                    
                    
                    break;
                case 2:
                	
                	List<Cita> citasDoctor = em.createQuery("SELECT c FROM Cita c JOIN c.doctor d WHERE d.nomDoctor = :nombreDoctor")
                    .setParameter("nombreDoctor", nomDoctor)
                    .getResultList();

                	if (citasDoctor.isEmpty()) {
                		System.out.println("El doctor no tiene citas asignadas.");
                		} else {
                				System.out.println("Citas:");
                				for (Cita Citaa : citasDoctor) {
                    System.out.println("Fecha " + cita.getFechaCita() + " paciente " + cita.getNomPacienteCita());
                }
            }
                    break;
                default:
                    System.out.println("Opcion no valida");
            }
		
		}
		
		
		System.out.println("un commit");
		
	}

}
