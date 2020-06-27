package cst438;


import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


	@Entity
	public class Movie {

		@Id
		@GeneratedValue
		private long id;
		
		@NotNull
		@Size(min=3,max=25)
		private Date date;
		
		@NotNull
		@Size(min=3,max=25)
		private String title;
		
		@NotNull
		@Size(min=3,max=25)
		private float rating;
		

		
		public Movie() {
			
		}



		public Movie(long id, Date date, @NotNull @Size(min = 3, max = 25) String title,
				@NotNull @Size(min = 3, max = 25) float rating) {
			super();
			this.id = id;
			this.date = date;
			this.title = title;
			this.rating = rating;
		}



		public long getId() {
			return id;
		}



		public void setId(long id) {
			this.id = id;
		}



		public Date getDate() {
			return date;
		}



		public void setDate(Date date) {
			this.date = date;
		}



		public String getTitle() {
			return title;
		}



		public void setTitle(String movie) {
			this.title = title;
		}



		public float getRating() {
			return rating;
		}



		public void setRating(float rating) {
			this.rating = rating;
		}
		


}
