package Lab4; //пакет Java классов

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener; //библиотека для события слушателя
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import javax.swing.*; // Библиотека для GUI (построена на основе awt)

import java.awt.Image;

public class subversion {
	
	private String inf = "hello";
	
	public subversion() throws IOException {
	final JFrame main_GUI = new JFrame("subversion");	// создание графического окна
	main_GUI.setTitle ("Using subversion for developers");
	main_GUI.setBounds(500,200,400,485);
	main_GUI.setResizable(false); // фиксированный размер окна
	
	JPanel main_panel = new JPanel(); // Панель - используется для организации компонентов в окне
	main_panel.setLayout(null);
	main_GUI.add(main_panel);
	
	JLabel laba_info = new JLabel("Лабораторная работа №2"); // Отображение текста или изображения
	laba_info.setBounds(120,0,150,30);
	main_panel.add(laba_info);
	
	JButton button_exit = new JButton("Выход"); // добавляем кнопку
	button_exit.setBounds(270,200,100,40);
	ActionListener actionListener = new ListenerButton(); //создаем слушатель
	button_exit.addActionListener(actionListener); // добавляем слушатель к кнопке
	main_panel.add(button_exit);
	
	final ClassLoader classLoader = getClass().getClassLoader();
	
	Image img = new ImageIcon(classLoader.getResource("ugatu.jpg")).getImage();
	
	final JLabel label_image = new JLabel(new ImageIcon(img.getScaledInstance(100, 50, Image.SCALE_SMOOTH))); // Отображение текста или изображения
	label_image.setBounds(280,0,100,50);
	main_panel.add(label_image);
	label_image.setVisible(false);
	
	JButton button_information = new JButton("Информация"); // добавляем кнопку "Информация"
	button_information.setBounds(15,200,115,40);
	button_information.addActionListener(new ListenerButton() 
	{

        @Override
        public void actionPerformed(ActionEvent e) {
         JOptionPane.showMessageDialog(main_GUI, inf); 
     }
 });
	main_panel.add(button_information);
    
	JMenuBar menuBar = new JMenuBar();
	
	JMenu menu = new JMenu("Меню");
	
	JMenuItem displayMenuItem = new JMenuItem("Отобразить логотип УГАТУ");
	JMenuItem addItem = new JMenuItem("Загрузить файл в проект 5");
	addItem.addActionListener(new ListenerButton() {

        @Override
        public void actionPerformed(ActionEvent e) {
            inf = "";
            JFileChooser fileopen = new JFileChooser();
            int ret = fileopen.showDialog(null, "Открыть файл");
            if (ret == JFileChooser.APPROVE_OPTION) {
                File file = fileopen.getSelectedFile();
                FileReader fr = null;
                BufferedReader br = null;
                try {
                    fr = new FileReader(file);
                    br = new BufferedReader(fr);
                } catch (FileNotFoundException e1) {
                    e1.printStackTrace();
                }
                String line;
                try {
                    while((line = br.readLine()) != null){
                        inf = inf + line + "\n";
                    }
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
                try {
                    br.close();
                    fr.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                    }
                }
            }
        });
	JMenuItem exitMenuItem = new JMenuItem("Выход");
	
	menu.add(displayMenuItem);
	menu.addSeparator();
	menu.add(addItem);
	menu.addSeparator();
	menu.add(exitMenuItem);
	
	menuBar.add(menu);
	
	exitMenuItem.addActionListener(actionListener);
	
	displayMenuItem.addActionListener(new ListenerButton() {

	    @Override
	    public void actionPerformed(ActionEvent arg0) {
	    	label_image.setVisible(true);
	    }
	});

	String[] items = {
            "Переместить логотип УГАТУ в верхний  угол",
            "Переместить логотип УГАТУ в середину",
            "Переместить логотип УГАТУ в верхний левый угол",
            "Отсортировать данные в проекте 5" }; 
    final JComboBox editComboBox = new JComboBox(items); 
    editComboBox.addActionListener(new ListenerButton() {
        @Override
        public void actionPerformed(ActionEvent e) {
            int i = editComboBox.getSelectedIndex();
            switch (i) {
            case  (0):
            	label_image.setBounds(280,0,100,50);
                break;
            case (1):
            	label_image.setBounds(150,60,100,50);
                break;
            case (2):
            	label_image.setBounds(0,0,100,50);
                break;
        }
            label_image.setVisible(true);
            }
        });
    editComboBox.setBounds(15,140,355,35);
    main_panel.add(editComboBox);
    
    JLabel area = new JLabel("Расчет площади равнобедренного треугольника"); // Отображение текста или изображения
    area.setBounds(50,250,290,30);
	main_panel.add(area);
	
	JLabel label_h = new JLabel("Длина высоты:"); // Отображение текста или изображения
	label_h.setBounds(50,280,100,30);
	main_panel.add(label_h);
	
	JLabel label_a = new JLabel("Длина основания:"); // Отображение текста или изображения
	label_a.setBounds(215,280,115,30);
	main_panel.add(label_a);
	
	final JTextField field_h = new JTextField();
	field_h.setBounds(50,310,100,30);
	main_panel.add(field_h);
	
	final JTextField field_a = new JTextField();
	field_a.setBounds(215,310,115,30);
	main_panel.add(field_a);
	
	JLabel label_d = new JLabel("Вывод:"); // Отображение текста или изображения
    label_d.setBounds(140,340,115,30);
    main_panel.add(label_d);

    final JTextField field_d = new JTextField();
    field_d.setBounds(140,370,190,30);
    field_d.setEditable(false);
    main_panel.add(field_d);

    JButton button_rasch = new JButton("Расчитать"); // добавляем кнопку
    button_rasch.setBounds(15,360,100,40);
    button_rasch.addActionListener(new ListenerButton() 
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            Float a = (float) 0;
            Float b = (float) 0;
            try {
                a = Float. parseFloat(field_a.getText());
                b = Float. parseFloat(field_h.getText());
            } catch (NumberFormatException e1) {
                JOptionPane.showMessageDialog(main_GUI,"Неправильно введены данные","Ошибка",JOptionPane.WARNING_MESSAGE);
            } finally {
            float S = a*b/2;
            String s = Float.toString(S);
            field_d.setText(s);
            }
        }

    });
    main_panel.add(button_rasch);
	
	main_GUI.setJMenuBar(menuBar);
	
	main_GUI.setVisible(true);
	
	main_GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // закрытие окна JFrame и процесса Java
	}
	
	public static void main(String[] args) throws IOException { // интересные заметки: http://www.mstu.edu.ru/study/materials/java/
		new subversion();
		
	}
	
}