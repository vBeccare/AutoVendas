import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.ParseException;
import java.text.DecimalFormat;

public class AutoVendas extends JPanel {
	public void limpar() {
		
		lvfn.setVisible(false);
		
		lvon.setVisible(false);
		
		lvpn.setVisible(false);
		lidescontos.setSelectedIndex(-1);//
		tfvalor.setText("");
	}
	
	public void conta() {
		
		if(tfvalor.getText().equals("")){
			JOptionPane.showMessageDialog(null,"Digite algum valor");
			tfvalor.requestFocus();
			return;
		}
		double valor=Double.parseDouble(tfvalor.getText());
		if(lidescontos.getSelectedIndex()==-1){
			JOptionPane.showMessageDialog(null,"Selecione um item da lista ");
			return;
		}
		lvf.setVisible(true);
		lvfn.setVisible(true);
		lvo.setVisible(true);
		lvon.setVisible(true);
		lvp.setVisible(true);
		lvpn.setVisible(true);
		double t=0;
		double i=0;
		double c=0;
		if(lidescontos.getSelectedIndex()==0){
			c=valor;
			i=0.05;
			t=1;
			double vfinala= c - c*i*t;
			lvfn.setText("R$ "+vfinal.format(vfinala));
			lvon.setText("R$ "+ vfinal.format(valor));
			lvpn.setText("R$ "+parcelas.format(vfinala));
			}
		if(lidescontos.getSelectedIndex()==1){
			c=valor;
			i=0.03;
			t=12;
			lvfn.setText("R$ "+vfinal.format(juros(c,i,t)));
			lvon.setText("R$"+ vfinal.format(valor));
			lvpn.setText("R$ "+parcelas.format((juros(c,i,t)/t)));
			
		}
		if(lidescontos.getSelectedIndex()==2){
			c=valor;
			i=0.05;
			t=24;
			lvfn.setText("R$ "+vfinal.format(juros(c,i,t)));
			lvon.setText("R$ "+ vfinal.format(valor));
			lvpn.setText("R$ "+parcelas.format((juros(c,i,t)/t)));
			
		}
		if(lidescontos.getSelectedIndex()==3){
			c=valor;
			i=0.10;
			t=36;
			lvfn.setText("R$ "+vfinal.format(juros(c,i,t)));
			lvon.setText("R$ "+ vfinal.format(valor));
			lvpn.setText("R$ "+ parcelas.format((juros(c,i,t)/t)));
			
		}
		if(lidescontos.getSelectedIndex()==4){
			c=valor;
			i=0.15;
			t=48;
			lvfn.setText("R$ "+vfinal.format(juros(c,i,t)));
			lvon.setText("R$ "+ vfinal.format(valor));
			lvpn.setText("R$ "+parcelas.format((juros(c,i,t)/t)));
			
		}
	}
	
	public static double juros(double c,double i,double t){
		double m= c*i*t;
		double M= c+m;
		return M;	
	}
	private JLabel lvalor,lparcelas,lvf,lvo,lvp,lvfn,lvon,lvpn,logo;
	ImageIcon auto;
	private JList lidescontos;
	private JScrollPane splista;
	private JButton btnc,btCalc,btcan;
	private JTextField tfvalor;
	DecimalFormat parcelas,vfinal;
	public AutoVendas(){
		inicializarComponentes();
		definirEventos();
	}
	
	private void inicializarComponentes(){
		 parcelas = new DecimalFormat( "0.00" );
		 vfinal=new DecimalFormat("0.00");
		setLayout(null);
		auto= new ImageIcon("E:\\imagens\\AutoVendas.png");
		logo=new JLabel(auto);
		logo.setBounds(260, 20, 180, 80);
		add(logo);
		
		lvalor=new JLabel("Valor");
		lvalor.setBounds(20, 120, 100, 20);
		add(lvalor);
		
		tfvalor= new JTextField(5);
		tfvalor.setBounds(105, 120, 100, 20);
		add(tfvalor);
		
		lparcelas=new JLabel("Parcelas");
		lparcelas.setBounds(20, 150, 100, 20);
		add(lparcelas);
		
		String[] parc={"1x","12x","24x","36x","48x"};
		lidescontos= new JList(parc);
		splista=new JScrollPane(lidescontos);
		splista.setBounds(105, 150, 100, 55);
		add(splista);
		
		btnc=new JButton("Novo cálculo");
		btnc.setBounds(240,350,120,20);
		add(btnc);
		
		btcan=new JButton("Cancelar");
		btcan.setBounds(100,350,120,20);
		add(btcan);
		
		btCalc=new JButton("Calcular");
		btCalc.setBounds(380,350,120,20);
		add(btCalc);
		
		lvf=new JLabel("Valor final:");
		lvf.setBounds(450, 120, 150, 20);
		add(lvf);
		
		lvfn=new JLabel("");
		lvfn.setBounds(540, 120, 100, 20);
		add(lvfn);
		
		lvo=new JLabel("Valor original:");
		lvo.setBounds(450, 150, 100, 20);
		add(lvo);
		
		lvon=new JLabel("");
		lvon.setBounds(550, 150, 100, 20);
		add(lvon);
		
		lvp=new JLabel("Valor da parcela:");
		lvp.setBounds(450, 180, 100, 20);
		add(lvp);
		
		lvpn=new JLabel("");
		lvpn.setBounds(560, 180, 100, 20);
		add(lvpn);
		
	}
	
	private void definirEventos(){
		btCalc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
			conta();
			}
			});
		btnc.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				
				limpar();
				
			}
		
		});
		
		btcan.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0){
				System.exit(0);
			}	
		});		
}
	public static void main(String args[]){
 		JFrame frame = new JFrame("Calculadora");
		 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 frame.getContentPane().add(new AutoVendas());
		 frame.setBounds(370,170,700,500);
		 frame.setVisible(true);
		 
	}	

}
