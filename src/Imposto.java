import java.util.Locale;
import java.util.Scanner;

public class Imposto {

	public static void main(String[] args) {

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		double rendaAnualSalario, rendaAnualPrestacaoDeServico, rendaAnualCapital, gastosMedicos, gastosEducacionais,
				gastosDedutiveis, maximoDedutivel, salarioMensal, impostoSobreSalario, impostoPrestacaoServico, impostoCapital,
				deducaoIR, impostoBruto, impostoTotal;

		System.out.print("Renda anual com salário: ");
		rendaAnualSalario = sc.nextDouble();
		System.out.print("Renda anual com prestação de serviço: ");
		rendaAnualPrestacaoDeServico = sc.nextDouble();
		System.out.print("Renda anual com ganho de capital: ");
		rendaAnualCapital = sc.nextDouble();
		System.out.print("Gastos médicos: ");
		gastosMedicos = sc.nextDouble();
		System.out.print("Gastos educacionais: ");
		gastosEducacionais = sc.nextDouble();

		// Imposto sobre salário:
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

		// Dedução:
		gastosDedutiveis = gastosEducacionais + gastosMedicos;
		maximoDedutivel = impostoBruto * 0.3;
		if (gastosDedutiveis > maximoDedutivel) {
			deducaoIR = maximoDedutivel;
		} else {
			deducaoIR = gastosDedutiveis;
		}

		impostoTotal = impostoBruto - deducaoIR;

		System.out.printf("\nRELATÓRIO DE IMPOSTO DE RENDA\n\n");

		System.out.println("CONSOLIDADO DE RENDA:");
		System.out.printf("Imposto sobre salário: %.2f\n", impostoSobreSalario);
		System.out.printf("Imposto sobre serviços: %.2f\n", impostoPrestacaoServico);
		System.out.printf("Imposto sobre ganho de capital: %.2f\n\n", impostoCapital);
		System.out.println("DEDUÇÕES:");
		System.out.printf("Máximo dedutível: %.2f\n", maximoDedutivel);
		System.out.printf("Gastos dedutíveis: %.2f\n\n", gastosDedutiveis);
		System.out.println("RESUMO:");
		System.out.printf("Imposto bruto total: %.2f\n", impostoBruto);
		System.out.printf("Abatimento: %.2f\n", deducaoIR);
		System.out.printf("Imposto devido: %.2f\n", impostoTotal);

		sc.close();
	} 
}       