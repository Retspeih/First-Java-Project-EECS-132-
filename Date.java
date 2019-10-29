public class Date extends Object {
  
  /* stores the int value for the day */
  private int day = 0;
  
  /* stores the int value for the month */
  private int month = 0;
  
  /* stores the int value for the year */
  private int year = 0;
  
  /* initializes the value for the day, month, and year */
  public Date(int day, int month, int year) {
    this.day = day;
    this.month = month;
    this.year = year;
  }
  
  /* returns the day value as an int */
  public int getDay() {
    return day;
  }
  
  /* returns the month value as an int */
  public int getMonth() {
    return month;
  }
  
  /* returns the year value as an int */
  public int getYear() {
    return year;
  }
  
  /* sets the value of the year as an inputted int parameter */
  public void setYear(int year) {
    this.year = year;
  }
  
  /* compares two dates, if the inputted date comes before the initial date, the method returns -1, if the
   * dates are the same, 0 is returned, and if the date comes after, the value is 1 */
  public int compareTo(Date date) {
    if (this.year == date.year) {
      if (this.month == date.month) {
        if (this.day == date.day) {
          return 0;
        }
        else if (this.day < date.day) {
          return -1;
        }
        else {
          return 1;
        }
      }
      else if (this.month < date.month) {
        return -1;
      }
      else {
        return 1;
      }
    }
    else if (this.year < date.year) {
      return -1;
    }
    else {
      return 1;
    }
  }
  
  /* returns true if the the inputted date is equal to the initial date of the reference type 
   * and the dates are considered equal if the day, month, and year are equal*/
  public boolean equals(Date date) {
    if (this.year == date.year && this.month == date.month && this.day == date.day) {
      return true;
    }
    else {
      return false;
    }
  }
  
  /* concatenates a String that represents the day, month, and year */
  public String toString() {
    if (this.getMonth() == 1) {
      return "Jan " + this.getDay() + ", " + this.getYear();
    }
    if (this.getMonth() == 2) {
      return "Feb " + this.getDay() + ", " + this.getYear();
    }
    if (this.getMonth() == 3) {
      return "Mar " + this.getDay() + ", " + this.getYear();
    }
    if (this.getMonth() == 4) {
      return "Apr " + this.getDay() + ", " + this.getYear();
    }
    if (this.getMonth() == 5) {
      return "May " + this.getDay() + ", " + this.getYear();
    }
    if (this.getMonth() == 6) {
      return "Jun " + this.getDay() + ", " + this.getYear();
    }
    if (this.getMonth() == 7) {
      return "Jul " + this.getDay() + ", " + this.getYear();
    }
    if (this.getMonth() == 8) {
      return "Aug " + this.getDay() + ", " + this.getYear();
    }
    if (this.getMonth() == 9) {
      return "Sep " + this.getDay() + ", " + this.getYear();
    }
    if (this.getMonth() == 10) {
      return "Oct " + this.getDay() + ", " + this.getYear();
    }
    if (this.getMonth() == 11) {
      return "Nov " + this.getDay() + ", " + this.getYear();
    }
    if (this.getMonth() == 12) {
      return "Dec " + this.getDay() + ", " + this.getYear();
    }
    else {
      return ""; // this shouldn't happen if all values are legal
    }
  }
}