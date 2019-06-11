//打折收费类
public class CashRebate extends CashSuper {

	private double moneyRebate = 1d;

	public CashRebate(String moneyRebate) {
		this.moneyRebate = Double.valueOf(moneyRebate);
	}

	@Override
	public double acceptCash(double money) {

		return  money * moneyRebate ;
	}

	

}
