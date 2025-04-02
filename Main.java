package reldemo;

 

import java.util.List;

import jakarta.persistence.EntityManager;







public class Main {

 

	public static void main(String[] args) {

		

		EntityManager em=JPAUtil.getEntityManager();

		

		 em.getTransaction().begin();
		 em.persist(new User("alice","alice@example.com","active"));
		 em.persist(new User("bob","bob@example.com","active"));

		 em.persist(new User("john","john@example.com","inactive"));

		 em.persist(new User("alice1","alice1@example.com","active"));
         em.getTransaction().commit();
         List<User>users1=(List<User>) em.createQuery("select u from User u where name=:name",User.class)
         .setParameter("name","bob").getResultList();
         for(User u:users1) {
        	 System.out.println(u.getName());
         }
         List<User>users2=em.createNamedQuery("User.findByEmail",User.class)
                 .setParameter("email","alice@example.com").getResultList();
                 for(User u:users2) {
                	 System.out.println(u.getEmail());
                 }
          List<User>activeUsers=em.createNamedQuery("User.findByStatus",User.class)
                         .setParameter(1,"inactive").getResultList();
                         for(User u:activeUsers) {
                        	 System.out.println(u.getStatus());
                         }

	       

	        em.close();

	        JPAUtil.close();

		

		

  ; 

	}

 

}