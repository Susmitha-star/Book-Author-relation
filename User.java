package reldemo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.NamedNativeQuery;
import jakarta.persistence.NamedQuery;


    
	@Entity
	@NamedQuery(name="User.findByEmail",query="SELECT u FROM User u WHERE u.email=:email")
	@NamedNativeQuery(name="User.findByStatus", query="SELECT * FROM user WHERE status =?",resultClass=User.class) 

	@Table(name="user")

	public class User {

		@Id

		@GeneratedValue(strategy=GenerationType.IDENTITY)

		private int id;

		private String name;

		private String email;

		private String status;

		public User() {

			

		}

		public User(String name, String email,String status) {

			super();

			this.name=name;

			this.email=email;

			this.status=status;

		}
		public int getId() {

			return id;

		}

		public void setId(int id) {

			this.id = id;

		}

		public String getName() {

			return name;

		}

		public void setName(String name) {

			this.name = name;

		}

		public String getEmail() {

			return email;

		}

		public void setEmail(String email) {

			this.email = email;

		}

		public String getStatus() {

			return status;

		}

		public void setStatus(String status) {

			this.status = status;

		}

		



	}




