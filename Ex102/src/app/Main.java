package app;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;


public class Main {
	
	public static void main(String[] args) {
		ExecutorService service = null;
		Random rand = new Random();
		List< Callable<TaskResult> > tasks = new ArrayList<>();
		
		//---------------- tasks ------------------------
		tasks.add( ()->{
			int suma = 1;
			long sleepTime = 10 * rand.nextInt(1000);
			TaskResult tr  = new TaskResult("Task 1", sleepTime);
			System.out.println("Task 1:Calculate sum:1..100 ["+sleepTime+"]");
			for( int i = 2; i <= 100 ; i++ ) {
				suma += i;
				if (suma > 1000) {
					throw new RuntimeException();
				}
			}
			Thread.sleep(sleepTime);
			tr.setResult(suma);
			return tr;
		});
		
		tasks.add( ()->{
			int suma = 1;
			long sleepTime = 10 * rand.nextInt(1000);
			TaskResult tr = new TaskResult("Task 2", sleepTime);
			System.out.println("Task 2:Calculate sum:1..100 ["+sleepTime+ "]");
			for( int i = 2; i <= 100 ; i++ ) {
				suma += i;
			}
			Thread.sleep(sleepTime);
			tr.setResult(suma);
			return tr;
		});
		
		tasks.add( ()->{
			int suma = 1;
			long sleepTime = 5 * rand.nextInt(1000);
			TaskResult tr = new TaskResult("Task 3",sleepTime); 
			System.out.println("Task 3:Calculate sum:1..100 ["+sleepTime+"]");
			for( int i = 2; i <= 100 ; i++ ) {
				suma += i;
			}
			Thread.sleep(sleepTime);
			tr.setResult(suma);
			return tr;
		});
		
		//------------------------------------------------
		try {
			service = Executors.newSingleThreadExecutor();
			System.out.println("begin");
			
			TaskResult rs = service.invokeAny(tasks);
			
			System.out.println("Result:" + rs.getResult() + "(" + rs.getTaskName() + ")");
			System.out.println("end");
			
		}
		catch( InterruptedException | ExecutionException e) {
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