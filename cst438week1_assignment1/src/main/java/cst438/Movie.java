package cst438;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

	@Entity
	public class Movie {

		@Id
		@GeneratedValue
		private long id;
		
		@NotNull
		@Size(min=19,max=19)
		private String date;
		
		@NotNull
		@Size(min=3,max=25)
		private String title;
		
		@NotNull
		@Max(100)
		@Min(0)
		private float rating;
		
		//Default constructor includes the new date in string format.
		public Movie() {
			java.util.Date dt = new java.util.Date();
			java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
			this.date = sdf.format(dt);
		}
		
		public Movie(long id, @NotNull @Size(min = 3, max = 25) String title,
				@NotNull @Size(min = 3, max = 25) float rating) {
			super();
			this.id = id;
			this.title = title;
			this.rating = rating;
		}

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getDate() {
			return date;
		}

		public void setDate(String date) {
			this.date = date;
		}

		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public float getRating() {
			return rating;
		}

		public void setRating(float rating) {
			this.rating = rating;
		}
		
}
