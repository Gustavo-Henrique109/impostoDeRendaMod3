import java.util.Locale;
import java.util.Scanner;

public class Imposto {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		double rendaAnualSalario, rendaAnualPrestacaoDeServico, rendaAnualCapital, gastosMedicos, gastosEducacionais,
				gastosDedutiveis, maximoDedutivel, salarioMensal, impostoSobreSalario, impostoPrestacaoServico, impostoCapital,
				deducaoIR, impostoBruto, impostoTotal;

		System.out.print("Renda anual com sal�rio: ");
		rendaAnualSalario = sc.nextDouble();
		System.out.print("Renda anual com presta��o de servi�o: ");
		rendaAnualPrestacaoDeServico = sc.nextDouble();
		System.out.print("Renda anual com ganho de capital: ");
		rendaAnualCapital = sc.nextDouble();
		System.out.print("Gastos m�dicos: ");
		gastosMedicos = sc.nextDouble();
		System.out.print("Gastos educacionais: ");
		gastosEducacionais = sc.nextDouble();

		// Imposto sobre sal�rio:
		salarioMensal = rendaAnualSalario / 12;
		if (salarioMensal < 3000) {
			impostoSobreSalario = 0;
		} else if (salarioMensal < 5000) {
			impostoSobreSalario = rendaAnualSalario * 0.1;
		} else {
			impostoSobreSalario = rendaAnualSalario * 0.2;
		}

		// Outros impostos:
		impostoPrestacaoServico = rendaAnualPrestacaoDeServico * 0.15;
		impostoCapital = rendaAnualCapital * 0.2;

		impostoBruto = impostoSobreSalario + impostoPrestacaoServico + impostoCapital;

		// Dedu��o:
		gastosDedutiveis = gastosEducacionais + gastosMedicos;
		maximoDedutivel = impostoBruto * 0.3;
		if (gastosDedutiveis > maximoDedutivel) {
			deducaoIR = maximoDedutivel;
		} else {
			deducaoIR = gastosDedutiveis;
		}

		impostoTotal = impostoBruto - deducaoIR;

		System.out.printf("\nRELAT�RIO DE IMPOSTO DE RENDA\n\n");

		System.out.println("CONSOLIDADO DE RENDA:");
		System.out.printf("Imposto sobre sal�rio: %.2f\n", impostoSobreSalario);
		System.out.printf("Imposto sobre servi�os: %.2f\n", impostoPrestacaoServico);
		System.out.printf("Imposto sobre ganho de capital: %.2f\n\n", impostoCapital);
		System.out.println("DEDU��ES:");
		System.out.printf("M�ximo dedut�vel: %.2f\n", maximoDedutivel);
		System.out.printf("Gastos dedut�veis: %.2f\n\n", gastosDedutiveis);
		System.out.println("RESUMO:");
		System.out.printf("Imposto bruto total: %.2f\n", impostoBruto);
		System.out.printf("Abatimento: %.2f\n", deducaoIR);
		System.out.printf("Imposto devido: %.2f\n", impostoTotal);

		sc.close();
	} 
}       