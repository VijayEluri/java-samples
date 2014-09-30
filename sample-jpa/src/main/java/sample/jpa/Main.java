package sample.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import sample.jpa.entity.Person;

public class Main {

	EntityManagerFactory factory;
	EntityManager manager;

	/** Creates a new instance of Main */
	public Main() {
	}

	/** ���������� */
	public void init() {
		factory = Persistence.createEntityManagerFactory("sample");
		manager = factory.createEntityManager();
	}

	/** �I������ */
	private void shutdown() {
		manager.close();
		factory.close();
	}

	/**
	 * @param args
	 *            the command line arguments
	 */
	public static void main(String[] args) {
		// TODO code application logic here
		Main main = new Main();
		main.init();
		try {
			main.create();
		} catch (RuntimeException ex) {
			ex.printStackTrace();
		} finally {
			main.shutdown();
		}
	}

	/**
	 * �I�u�W�F�N�g�̐����Ɖi����
	 */
	private void create() {
		System.out.println("2��Person�I�u�W�F�N�g���i������");
		EntityTransaction transaction = manager.getTransaction();
		transaction.begin();
		try {
			Person person1 = new Person("Takaaki SUGIYAMA");
			manager.persist(person1);
			Person person2 = new Person("Daichi GOTO");
			manager.persist(person2);

			transaction.commit();
		} catch (Exception ex) {
			transaction.rollback();
		}
		System.out.println("2��Person�I�u�W�F�N�g���i�������܂���.");
	}

}
