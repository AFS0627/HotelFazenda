import java.awt.EventQueue;

import visao.Janela;

public class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {

			@Override
			public void run() {

				try {

					Janela frame = new Janela();
					
					frame.setVisible(true);

				} catch (Exception e) {

					e.printStackTrace();
				}
			}
		});
	}
}