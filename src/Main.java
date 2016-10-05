import java.awt.EventQueue;

public class Main {

	public static void main(String[] args) {
		
		
		Window window = new Window();
		createWindow();
		DBConnect connect = new DBConnect();
	}
	
	public static void createWindow(){
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.getFrmLmf().setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

}


