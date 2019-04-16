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
		try {
			service = Executors.newSingleThreadScheduledExecutor();
			
			System.out.println("begin");
			
			ScheduledFuture<?> t1 = service.schedule(()->{
				int suma = 1;
				System.out.println("Calculate sum:1+2+3+...+99+100");
				for( int i = 2 ; i <= 100; i++) {
					suma += i;
				}
				return suma;
			}, 
			5, 
			TimeUnit.SECONDS);
			
			System.out.println("scheduled: t1");
			
			ScheduledFuture<?> t2 = service.schedule(()->{
				Random rand = new Random();
				System.out.println("Get Random Number:");
				int r = rand.nextInt(100);
				return r;
			}, 
			6, 
			TimeUnit.SECONDS);
			
			System.out.println("scheduled: t2");
			
			System.out.println("result t1:" + t1.get() + " delay:" + t1.getDelay(TimeUnit.SECONDS));
			System.out.println("result t2:" + t2.get() + " delay:" + t2.getDelay(TimeUnit.SECONDS));
			
			System.out.println("end");
		}
		catch(ExecutionException | InterruptedException e) {
			e.printStackTrace();
		}
		finally {
			if( service != null ) service.shutdown();
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