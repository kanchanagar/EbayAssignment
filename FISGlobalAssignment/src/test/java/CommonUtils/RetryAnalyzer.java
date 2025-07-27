package CommonUtils;

import org.testng.IRetryAnalyzer;
import org.testng.ITestResult;

public class RetryAnalyzer implements IRetryAnalyzer {
	
	private static int count=0;
	private static int maxcount=3;

	@Override
	public boolean retry(ITestResult result) {
		if(!result.isSuccess()) {
			if(count<maxcount) {
			result.setStatus(ITestResult.SKIP);
			}
			else
			{
				result.setStatus(ITestResult.FAILURE);
			}
			
		}
		else {
			result.setStatus(ITestResult.SUCCESS);
		}
		return false;
	}

}
