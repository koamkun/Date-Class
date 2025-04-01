# Date Class Validation

## Project Overview
This project implements a `Date` class in Java to perform various date-related operations. It includes:

- **Validation**: Checks if a date is valid, considering leap years.
- **Date Update**: Allows updating a date if the new date is valid.
- **Day of the Week Calculation**: Determines the day of the week for a given date.
- **Date Difference Calculation**: Computes the difference in days between two dates.
- **Sorting**: Implements `Comparable<Date>` to enable sorting by year, then month, then day.
- **User Input**: Accepts date input from the user and validates it.


The program will prompt the user to enter a date, validate it, display its day of the week, and demonstrate sorting multiple dates.

## Additional Notes
- The program validates leap years and correctly handles February 29.
- It uses **Zeller’s Congruence** to compute the day of the week.
- Dates are stored in an `ArrayList<Date>` and sorted using `Collections.sort()`.
- Invalid dates entered by the user will display an error message instead of proceeding.

## Challenges
- **Efficient date difference calculation**: The `toDays` method converts dates to absolute days, which may be optimized further.

