package rocketBase;

import java.util.ArrayList;

import org.apache.poi.ss.formula.functions.*;

import exceptions.RateException;
import rocketDomain.RateDomainModel;

public class RateBLL {

	private static RateDAL _RateDAL = new RateDAL();
	
	public static double getRate(int GivenCreditScore) throws RateException 
	{
		double dInterestRate = 0;
		
		ArrayList<RateDomainModel> rates = RateDAL.getAllRates();
		
		if(GivenCreditScore < rates.get(0).getiMinCreditScore()){
			RateDomainModel rate = null;
			throw new RateException(rate);
		}
		else{
			for(int i = 0; i < rates.size(); i++){
				if(GivenCreditScore > rates.get((rates.size() - 1) - i).getiMinCreditScore()){
					dInterestRate = rates.get(i).getdInterestRate();
				}
			}
		}
		return dInterestRate;
	}
	
	
	
	//TODO - RocketBLL RateBLL.getPayment 
	//		how to use:
	//		https://poi.apache.org/apidocs/org/apache/poi/ss/formula/functions/FinanceLib.html
	
	public static double getPayment(double r, double n, double p, double f, boolean t)
	{		
		return FinanceLib.pmt(r, n, p, f, t);
	}
}
