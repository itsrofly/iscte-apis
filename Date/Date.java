package Date;

public class Date {
	private int month, day, year;
	
	public Date(int month, int day, int year) {
		if (!isValid(month, day, year))
			throw new IllegalArgumentException("Invalid date!");
		this.month = month;
		this.day = day;
		this.year = year;
	}
	
	
	private boolean isLeap(int year){
			return ((year % 4 == 0 && year % 100 == 0 && year % 400 == 0) 
					|| year % 4 == 0 && year % 100 != 0);
	}
	
	
	private boolean isValid (int month, int day, int year){
		if (day < 1 || day > 31)
			return false;
		if (month < 1 || month > 12)
			return false;
		if (year < 1 || year > 9999)
			return false;
			
		if (month == 2) {
			if (isLeap(year)) // leap Year
				return (day < 30);
			else
				return (day < 29);
		}
		
		if (month == 4 || month == 6 || month == 9 || month == 11)
			return (day < 31); // months with 30 days
	
		return true;
	}
	
	
	public int month() {
		return month;
	}
	
	
	public int day() {
		return day;
	}
	
	
	public int year() {
		return year;
	}
	
	
	public String toString() {
		return month + "/" + day + "/" + year;
	}
	
	
	public boolean before(Date other) { 
		// convert months and years to days using average formula
		double thisTotalDays = day 
				+ (month * 30.436875) 
				+ ((year * 12) * 30.436875);
		
		double otherTotalDays = other.day() 
				+ (other.month() * 30.436875) 
				+ ((other.year() * 12) * 30.436875);
		
		return thisTotalDays < otherTotalDays; // check is smaller/before
	}
	
	
	public int daysSinceBeginYear() {
		int sinceBegin = 0;
		
		for(int m = month; m >= 1; m--) { // counting down the months
			int totalDays; // last day of the month
			
			if (m == month)
				totalDays = day; // first last day
			else
				switch(m) { // get last day by Month
				case 4: case 6: case 9: case 11: // months with 30 days
					totalDays = 30;
					break;
					
				case 2: // fev
					if(isLeap(year)) // leap Year
						totalDays = 29;
					else
						totalDays = 28;
					break;
					
				default: // normal Days
					totalDays = 31;
				}
			
			for (int d = totalDays; d >= 1; d--) { // counting down the days
				sinceBegin++;
			}
		}
		return sinceBegin;
	}
	
	
	public int daysUntilEndYear() {
		// maximum number of days per year, minus number of days in that year
		if (isLeap(year))
			return 366 - daysSinceBeginYear();
		else
			return 365 - daysSinceBeginYear();
	}
	
	
	public int daysBetween(Date other) {
		if (before(other)) // change for this > other
			return other.daysBetween(this);
		
		int thisDays = daysSinceBeginYear(); // number of years
		int otherDays = other.daysSinceBeginYear();
		
		if (year != other.year()) // this date have more years than the other
			for (int i = year - 1; i >= other.year(); i--) { 
				// get number of days in the year before
				Date yearBefore = new Date(12, 31, i);
				thisDays += yearBefore.daysSinceBeginYear(); // add the number of days in the year before
			}
		return thisDays - otherDays;
	}
}
