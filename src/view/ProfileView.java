package view;

import controller.ProfileController;
import model.BookModel;
import java.util.List;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import javax.swing.table.TableRowSorter;
import java.util.Comparator;

public class ProfileView {
    JFrame frame = new JFrame("Profile");

    /*JPanel panel1 = new JPanel();
    JPanel panel2 = new JPanel();

    JButton deleteButton = new JButton("Delete");
    JButton updateButton = new JButton("Update");*/

    //-------------------------------------------------
    // SEARCH
    //-------------------------------------------------

    JTable table =new JTable();
    JScrollPane scrollPane = new JScrollPane(table);


    JMenuBar menuBar=new JMenuBar();
    JLabel labelParam1=new JLabel("Choose book category: ");
    JMenu category= new JMenu ("All");
    JMenuItem all= new JMenuItem ("All");
    JMenuItem fiction =new JMenuItem("Fiction");
    JMenuItem mystery =new JMenuItem("Mystery");
    JMenuItem scienceFiction =new JMenuItem("Science Fiction");
    JMenuItem fantasy =new JMenuItem("Fantasy");
    JMenuItem romance =new JMenuItem("Romance");
    JMenuItem adventure =new JMenuItem("Adventure");
    JMenuItem horror =new JMenuItem("Horror");
    JMenuItem dystopia =new JMenuItem("Dystopian");
    JMenuItem historicalFiction =new JMenuItem("Historical Fiction");
    JMenuItem thriller =new JMenuItem("Thriller");
    JMenuItem history =new JMenuItem("History");
    JMenuItem philosophy =new JMenuItem("Philosophy");
    JMenuItem children =new JMenuItem("Children");

    JLabel labelParam2=new JLabel("Find: ");
    JTextField textFieldParam2=new JTextField();

    JButton searchButton=new JButton("Search");
    JButton myCart=new JButton("My Cart");

    JMenu myProfile= new JMenu ("My Profile");
    JMenuItem delete =new JMenuItem("Delete");
    JMenuItem update =new JMenuItem("Update");

    JMenuItem logOut=new JMenuItem("Log out");


    JLabel labelTitle = new JLabel("Book title");

    JLabel labelStock = new JLabel("Left in stock: ");
    JLabel labelStockAmount = new JLabel();

   JButton addToCart=new JButton("Add to cart");
    ProfileController profileController;

    public ProfileView(){

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(900, 600);

        category.add(all);
        category.add(fiction);
        category.add(mystery);
        category.add(scienceFiction);
        category.add(fantasy);
        category.add(romance);
        category.add(adventure);
        category.add(horror);
        category.add(dystopia);
        category.add(historicalFiction);
        category.add(thriller);
        category.add(history);
        category.add(philosophy);
        category.add(children);

        myProfile.add(delete);
        myProfile.add(update);
        myProfile.add(logOut);

        all.addActionListener(e->category.setText(all.getText()));
        fiction.addActionListener(e->category.setText(fiction.getText()));
        mystery.addActionListener(e->category.setText(mystery.getText()));
        scienceFiction.addActionListener(e->category.setText(scienceFiction.getText()));
        fantasy.addActionListener(e->category.setText(fantasy.getText()));
        romance.addActionListener(e->category.setText(romance.getText()));
        adventure.addActionListener(e->category.setText(adventure.getText()));
        horror.addActionListener(e->category.setText(horror.getText()));
        dystopia.addActionListener(e->category.setText(dystopia.getText()));
        historicalFiction.addActionListener(e->category.setText(historicalFiction.getText()));
        thriller.addActionListener(e->category.setText(thriller.getText()));
        history.addActionListener(e->category.setText(history.getText()));
        philosophy.addActionListener(e->category.setText(philosophy.getText()));
        children.addActionListener(e->category.setText(children.getText()));

        all.addActionListener(e->profileController.categorySelected(all.getText()));
        fiction.addActionListener(e->profileController.categorySelected(fiction.getText()));
        mystery.addActionListener(e->profileController.categorySelected(mystery.getText()));
        scienceFiction.addActionListener(e->profileController.categorySelected(scienceFiction.getText()));
        fantasy.addActionListener(e->profileController.categorySelected(fantasy.getText()));
        romance.addActionListener(e->profileController.categorySelected(romance.getText()));
        adventure.addActionListener(e->profileController.categorySelected(adventure.getText()));
        horror.addActionListener(e->profileController.categorySelected(horror.getText()));
        dystopia.addActionListener(e->profileController.categorySelected(dystopia.getText()));
        historicalFiction.addActionListener(e->profileController.categorySelected(historicalFiction.getText()));
        thriller.addActionListener(e->profileController.categorySelected(thriller.getText()));
        history.addActionListener(e->profileController.categorySelected(history.getText()));
        philosophy.addActionListener(e->profileController.categorySelected(philosophy.getText()));
        children.addActionListener(e->profileController.categorySelected(children.getText()));

        searchButton.addActionListener(e-> profileController.searchButtonClicked());

        delete.addActionListener(e -> profileController.delete());
        update.addActionListener(e -> profileController.update());
        logOut.addActionListener(e -> profileController.logOut());
        table.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                DefaultTableModel model=(DefaultTableModel) table.getModel();

                String title= (String) model.getValueAt(table.getSelectedRow(),0);

            labelTitle.setText(title);
            labelStockAmount.setText(String.valueOf(profileController.getStockAmount(title)));
            }
        });
        menuBar.setBounds(0,0,frame.getWidth(),30);
        menuBar.add(labelParam1);
        menuBar.add(category);
        menuBar.add(myProfile);
        menuBar.add(myCart);

        labelParam2.setBounds(720,20,50,20);
        textFieldParam2.setBounds(775,20,100,20);
        searchButton.setBounds(775,45,100,20);
labelTitle.setBounds(720,75,200,20);
labelStock.setBounds(720,100,100,20);
labelStockAmount.setBounds(800,100,100,20);
addToCart.setBounds(720,125,100,20);
        scrollPane.setBounds(10,10,700,300);

        JLabel labelPane =new JLabel();
        labelPane.setBounds(0,0,700,300);
        labelPane.add(scrollPane);
        labelPane.add(labelParam2);
        labelPane.add(textFieldParam2);
        labelPane.add(searchButton);
        labelPane.add(labelTitle);
        labelPane.add(labelStock);
        labelPane.add(labelStockAmount);
        labelPane.add(addToCart);

        JPanel panel = new JPanel();

       frame.setJMenuBar(menuBar);

        frame.setContentPane(labelPane);

    }
    public String getCategory() {
        return category.getText();
    }

    public void setVisibility(boolean isVisible){
        frame.setVisible(isVisible);
    }

    public String getSearchText() {
        return textFieldParam2.getText();
    }

    public void showMessage(String message, int option){
        if( option == 0) {
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.ERROR_MESSAGE);
        }
        if(option ==1){
            JOptionPane.showMessageDialog(frame, message, "Swing Tester", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public ProfileController getPersonController() {
        return profileController;
    }

    public void setProfileController(ProfileController profileController) {
        this.profileController = profileController;
    }

    public void displayData(List<BookModel>books){
        String[] coll={"Title","Author","Genre","Price"};

        DefaultTableModel model=new DefaultTableModel(coll,0);
        for (BookModel book : books) {
            Object[] row = {book.getTitle(), book.getAuthor(), book.getGenre(), book.getPrice()};
            model.addRow(row);

        }

        TableRowSorter sorter= new TableRowSorter(model);

        sorter.setComparator(3, Comparator.comparingInt((Integer price) -> price).reversed());

        table.setModel(model);
        table.setRowSorter(sorter);

    }

    public void displayData(List<BookModel>books, String searchText){
        String[] coll={"Title","Author","Genre","Price"};

        DefaultTableModel model=new DefaultTableModel(coll,0);
        for (BookModel book : books) {
            Object[] row = {book.getTitle(), book.getAuthor(), book.getGenre(), book.getPrice()};
            model.addRow(row);

        }

        TableRowSorter sorter= new TableRowSorter(model);

        sorter.setComparator(3, Comparator.comparingInt((Integer price) -> price).reversed());
        sorter.setRowFilter(new BookModel.MyRowFilter(searchText));
        table.setModel(model);
        table.setRowSorter(sorter);

    }
}

