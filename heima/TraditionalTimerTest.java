package heima;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;
//可以用quartz来定时具体的时间比如周一至周五收邮件而周天不收邮件
public class TraditionalTimerTest {
	private static int count =0;
	public static void main(String[] args) {
	/*	new Timer().schedule(new TimerTask(){
			@Override
			public void run(){
				System.out.println("bombing!");
			}
		}, 10000,3000);*/
		class MyTimerTask extends TimerTask{
			public void run(){
				count = (count+1)%2;
				System.out.println("bombing!");
				new Timer().schedule(/*new TimerTask(){
					@Override
					public void run(){
						System.out.println("bombing!");
					}
				}*/new MyTimerTask(), 2000+2000*count);
				
			}
		}
	
		new Timer().schedule(new MyTimerTask(), 2000);
//			new Timer().schedule(new TimerTask(){
//		@Override
//		public void run(){
//			System.out.println("bombing!");
//			new Timer().schedule(/*new TimerTask(){
//				@Override
//				public void run(){
//					System.out.println("bombing!");
//				}
//			}*/this, 2000);
//		}
//	}, 2000);
		while(true){
			System.out.println(new Date().getSeconds());
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}

}
