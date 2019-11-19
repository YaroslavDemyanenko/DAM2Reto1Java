package vista;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JPanel;

public class PanelCenter extends JPanel {
	
	private static final long serialVersionUID = 3193045696500112897L;
	public CardLayout card;
	public int currentIndex;
	public PanelMenu pMenuPrincipal;
	public PanelMenuDpto pMenuDpto;
	public PanelDpto pDpto;
	public PanelMenuEmple pMenuEmple;
	public PanelEmple pEmple;
	
	public PanelCenter() {
		setParametros();
		instanciarObjetos();
		currentIndex = 1;
	}

	private void setParametros() {
		card = new CardLayout();
		setLayout(card);
		setPreferredSize(new Dimension(1024,768));
		setBackground(new Color(180,187,194));
		setForeground(Color.WHITE);
	}

	private void instanciarObjetos() {
		pMenuPrincipal = new PanelMenu();
		add(pMenuPrincipal, "1");		
		
		pMenuDpto = new PanelMenuDpto();
		add(pMenuDpto, "2");
		
		pDpto = new PanelDpto();
		add(pDpto, "3");

		pMenuEmple = new PanelMenuEmple();
		add(pMenuEmple, "4");
		
		pEmple = new PanelEmple();
		add(pEmple,"5");
	}
	
	public void prevPanel() {
		card.previous(this);
		currentIndex--;
	}
	
	public void nextPanel() {
		card.next(this);
		currentIndex++;
	}
	
	public void firstPanel() {
		card.first(this);
		currentIndex = 1;
	}
	
	public void changePanel(String index) {
		card.show(this, index);
		currentIndex = Integer.parseInt(index);
	}
}
