package app;

import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Main {
	
	public static void main(String[] args) {
		ScheduledExecutorService service = null;
		
			service = Executors.newSingleThreadScheduledExecutor();
			
			System.out.println("begin");
			
			ScheduledFuture<?> t1 = service.scheduleAtFixedRate(()->{
				Random rand = new Random();
				System.out.println("Get Random Number:" + rand.nextInt(100));

			}, 
			5, //initial delay
			2, //period
			TimeUnit.SECONDS);

			Runnable stopTask1 = ()->{
				t1.cancel(true);
				System.out.println("Cancel task 1");
			};
			
			service.schedule(stopTask1, 10, TimeUnit.SECONDS);
			
			System.out.println("end");
		
		try {
			if( !service.awaitTermination(15, TimeUnit.SECONDS) ) {	
				service.shutdown();
			}
		}
		catch( InterruptedException e) {
			
		}
	}	
}

class TaskResult{
	private int result;
	private String taskName;
	private long sleepTime;
	
	public TaskResult(String taskName, long sleepTime) {
		this.result = 0;
		this.taskName = taskName;
		this.sleepTime = sleepTime;
	}

	public int getResult() {
		return result;
	}

	public void setResult(int result) {
		this.result = result;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public long getSleepTime() {
		return sleepTime;
	}

	public void setSleepTime(long sleepTime) {
		this.sleepTime = sleepTime;
	}
	
	
}