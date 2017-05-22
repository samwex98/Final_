package exceptions;

import rocketDomain.RateDomainModel;

public class RateException extends Exception {

	private RateDomainModel rate = new RateDomainModel();
	
	public RateException(RateDomainModel Rate){
		this.rate = Rate;
	}
	
	public RateDomainModel getRate(){
		return rate;
	}
}
