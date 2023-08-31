import java.util.Scanner;

public class IT_Calculator {

	double TaxableIncome;
	double TaxPaidPerYear;
	double TaxPayablePerMonth;

	public void readTaxableIncome() {
		Scanner scanner = new Scanner(System.in);
		System.out.print("Enter TaxableIncome: ");

		TaxableIncome = scanner.nextDouble();
	}

	public void CalculateTaxableIncome() {

		if (TaxableIncome <= 25000) {
			TaxPayablePerMonth = 0;
		} else if (25000 < TaxableIncome && TaxableIncome <= 50000) {
			TaxPayablePerMonth = TaxableIncome * 0.1;
		} else if (50000 < TaxableIncome && TaxableIncome <= 75000) {
			TaxPayablePerMonth = TaxableIncome * 0.2;
		} else {
			TaxPayablePerMonth = TaxableIncome * 0.3;
		}

		TaxPaidPerYear = TaxPayablePerMonth * 12;

	}

	public void taxtDetails() {
		System.out.println("Taxt paid in month: $" + TaxPayablePerMonth);
		System.out.println("Taxt paid in year: $" + TaxPaidPerYear);
	}

	public static void main(String[] args) {
		IT_Calculator calculator = new IT_Calculator();

		calculator.readTaxableIncome();
		calculator.CalculateTaxableIncome();
		calculator.taxtDetails();

	}

}
