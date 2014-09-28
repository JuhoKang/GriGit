package kr.re.ec.grigit;


public class UserInfo {

		private String author;
		private String email;
	
	// for singleton
		private UserInfo() {
		}

		public String getAuthor() {
			return author;
		}

		public void setAuthor(String author) {
			this.author = author;
		}

		public String getEmail() {
			return email;
		}

		public void setEmail(String email) {
			this.email = email;
		}

		// for singleton
		/**
		 * Method getInstance.
		 * 
		 * @return CurrentRepository
		 */
		public static UserInfo getInstance() {
			return SingletonHolder.instance;
		}

		// for singleton
		private static class SingletonHolder {
			private static final UserInfo instance = new UserInfo();
		}
	
}
