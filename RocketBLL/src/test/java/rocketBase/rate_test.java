package rocketBase;

import static org.junit.Assert.*;

import org.junit.Test;

import exceptions.RateException;


public class rate_test {
	
	
	@Test
	public void testCredit() throws RateException{
		boolean smthing = false;
			if(RateBLL.getRate(600) > 0){
				smthing = true;
		}
			assertTrue(smthing);
	}
	
	@Test
	public void testException() throws RateException{
		boolean other = false;
		try{
			rocketBase.RateBLL.getRate(0);
			}catch (RateException e){
				other = true;
			}
		assertTrue(other);
	}
}
