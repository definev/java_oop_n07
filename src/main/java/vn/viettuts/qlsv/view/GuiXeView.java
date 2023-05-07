package vn.viettuts.qlsv.view;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.Format;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import vn.viettuts.qlsv.entity.Xe;

public class GuiXeView extends JFrame implements ActionListener, ListSelectionListener {
    private static final long serialVersionUID = 1L;
    private JButton addXeBtn;
    private JButton totalPriceBtn;
    private JButton deleteXeBtn;
    private JButton clearBtn;
    private JTable studentTable;

    private JLabel thoiGianContent;
    private JLabel totalMoneyLabel;

    private JTextField idField;
    private JTextField bienSoField;

    private JTextField traXeField;
    private JButton traXeBtn;

    private JComboBox<String> khuVucComboBox;

    private final String[] columnNames = new String[]{"ID", "Biển số", "Thời gian", "Khu vực"};

    private Object data = new Object[][]{};

    public GuiXeView() {
        initComponents();
    }

    private void initComponents() {
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        // khởi tạo các phím chức năng
        addXeBtn = new JButton("Add");
        totalPriceBtn = new JButton("Trả");
        deleteXeBtn = new JButton("Xóa");
        clearBtn = new JButton("Clear");
        // khởi tạo bảng student
        JScrollPane jScrollPaneStudentTable = new JScrollPane();
        studentTable = new JTable();

        // khởi tạo các label
        JLabel idLabel = new JLabel("Id");
        JLabel nameLabel = new JLabel("Biển số");
        JLabel khuVucLabel = new JLabel("Khu vực");
        JLabel thoiGianLabel = new JLabel("Thời gian");
        thoiGianContent = new JLabel("");

        totalMoneyLabel = new JLabel("");


        // khởi tạo các trường nhập dữ liệu cho student
        idField = new JTextField(15);
        idField.setEditable(false);
        bienSoField = new JTextField(15);

        String[] khuVuc = {"A", "B", "C"};
        khuVucComboBox = new JComboBox<>(khuVuc);

        JLabel traXeLabel = new JLabel("Id xe");
        traXeField = new JTextField(15);
        traXeBtn = new JButton("Trả xe");

        // cài đặt các cột và data cho bảng student
        studentTable.setModel(new DefaultTableModel((Object[][]) data, columnNames));
        jScrollPaneStudentTable.setViewportView(studentTable);
        jScrollPaneStudentTable.setPreferredSize(new Dimension(600, 300));

        // tạo spring layout
        SpringLayout layout = new SpringLayout();
        // tạo đối tượng panel để chứa các thành phần của màn hình quản lý Student
        JPanel panel = new JPanel();
        panel.setSize(800, 420);
        panel.setLayout(layout);
        panel.add(jScrollPaneStudentTable);

        panel.add(addXeBtn);
        panel.add(totalPriceBtn);
        panel.add(deleteXeBtn);
        panel.add(clearBtn);

        panel.add(idLabel);
        panel.add(nameLabel);
        panel.add(khuVucLabel);
        panel.add(thoiGianLabel);
        panel.add(thoiGianContent);
        panel.add(totalMoneyLabel);

        panel.add(idField);
        panel.add(bienSoField);


        panel.add(traXeLabel);
        panel.add(traXeField);
        panel.add(traXeBtn);
        panel.add(khuVucComboBox);

        // cài đặt vị trí các thành phần trên màn hình login
        layout.putConstraint(SpringLayout.WEST, idLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idLabel, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, nameLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, nameLabel, 40, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, khuVucLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, khuVucLabel, 70, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, thoiGianLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, thoiGianLabel, 100, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, thoiGianContent, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, thoiGianContent, 100, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, idField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, idField, 10, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, bienSoField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, bienSoField, 40, SpringLayout.NORTH, panel);
        khuVucComboBox.setBounds(100, 70, 100, 20);
        layout.putConstraint(SpringLayout.WEST, khuVucComboBox, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, khuVucComboBox, 70, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, jScrollPaneStudentTable, 300, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, jScrollPaneStudentTable, 10, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, addXeBtn, 20, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, addXeBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, totalPriceBtn, 60, SpringLayout.WEST, addXeBtn);
        layout.putConstraint(SpringLayout.NORTH, totalPriceBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, deleteXeBtn, 60, SpringLayout.WEST, totalPriceBtn);
        layout.putConstraint(SpringLayout.NORTH, deleteXeBtn, 270, SpringLayout.WEST, totalPriceBtn);

        layout.putConstraint(SpringLayout.NORTH, clearBtn, 240, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, clearBtn, 80, SpringLayout.WEST, deleteXeBtn);

        layout.putConstraint(SpringLayout.NORTH, deleteXeBtn, 240, SpringLayout.NORTH, panel);

        layout.putConstraint(SpringLayout.WEST, traXeLabel, 10, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, traXeLabel, 270, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, traXeField, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, traXeField, 270, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, traXeBtn, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, traXeBtn, 300, SpringLayout.NORTH, panel);
        layout.putConstraint(SpringLayout.WEST, totalMoneyLabel, 100, SpringLayout.WEST, panel);
        layout.putConstraint(SpringLayout.NORTH, totalMoneyLabel, 330, SpringLayout.NORTH, panel);

        this.add(panel);
        this.pack();
        this.setTitle("Phần mềm trông giữ xe");
        this.setSize(800, 420);
        // disable Edit and Delete buttons
        totalPriceBtn.setEnabled(false);
        deleteXeBtn.setEnabled(false);
        // enable Add button
        addXeBtn.setEnabled(true);
    }

    public void showMessage(String message) {
        JOptionPane.showMessageDialog(this, message);
    }

    /**
     * hiển thị list student vào bảng studentTable
     *
     * @param list
     */
    public void showListStudents(List<Xe> list) {
        int size = list.size();

        Object[][] students = new Object[size][4];
        for (int i = 0; i < size; i++) {
            students[i][0] = list.get(i).getId();
            students[i][1] = list.get(i).getBienSo();
            students[i][2] = list.get(i).getThoiGian();
            students[i][3] = list.get(i).getKhuVuc();
        }

        studentTable.setModel(new DefaultTableModel(students, columnNames));
    }

    public void fillStudentFromSelectedRow() {
        // lấy chỉ số của hàng được chọn
        try {
            int row = studentTable.getSelectedRow();
            if (row >= 0) {
                idField.setText(studentTable.getModel().getValueAt(row, 0).toString());
                bienSoField.setText(studentTable.getModel().getValueAt(row, 1).toString());
                khuVucComboBox.setSelectedItem(studentTable.getModel().getValueAt(row, 3).toString());
                var formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = null;
                date = formatter.parse(studentTable.getModel().getValueAt(row, 2).toString());

                thoiGianContent.setText(DateFormat.getDateInstance().format(date));
                // enable Edit and Delete buttons
                totalPriceBtn.setEnabled(true);
                deleteXeBtn.setEnabled(true);
                // disable Add button
                addXeBtn.setEnabled(false);
            }
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * xóa thông tin student
     */
    public void clearStudentInfo() {
        idField.setText("");
        bienSoField.setText("");
        khuVucComboBox.setSelectedIndex(0);
        // disable Edit and Delete buttons
        totalPriceBtn.setEnabled(false);
        deleteXeBtn.setEnabled(false);
        // enable Add button
        addXeBtn.setEnabled(true);
        totalMoneyLabel.setText("");
    }

    /**
     * hiện thị thông tin student
     *
     * @param xe
     */
    public void showXe(Xe xe) {
        try {
            idField.setText(String.valueOf(xe.getId()));
            bienSoField.setText(xe.getBienSo());
            khuVucComboBox.setSelectedItem(xe.getKhuVuc());
            var formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            var date = formatter.parse(xe.getThoiGian());
            thoiGianContent.setText(DateFormat.getDateInstance().format(date));
            // enable Edit and Delete buttons
            totalPriceBtn.setEnabled(true);
            deleteXeBtn.setEnabled(true);
            // disable Add button
            addXeBtn.setEnabled(false);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }

    }

    /**
     * lấy thông tin student
     *
     * @return
     */
    public Xe getStudentInfo() {
        // validate student
        if (!validateName()) {
            return null;
        }
        try {
            Xe xe = new Xe();
            xe.setId(idField.getText().trim());
            xe.setName(bienSoField.getText().trim());
            var thoiGian = new Date();
            Format formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            String s = formatter.format(thoiGian);
            xe.setThoiGian(s);
            xe.setKhuVuc(String.valueOf(khuVucComboBox.getSelectedItem()));
            return xe;
        } catch (Exception e) {
            showMessage(e.getMessage());
        }
        return null;
    }

    private boolean validateName() {
        String name = bienSoField.getText();
        if (name == null || "".equals(name.trim())) {
            bienSoField.requestFocus();
            showMessage("Biển số không được để trống");
            return false;
        }
        return true;
    }


    public void actionPerformed(ActionEvent e) {
    }

    public void valueChanged(ListSelectionEvent e) {
    }

    public void addAddStudentListener(ActionListener listener) {
        addXeBtn.addActionListener(listener);
    }

    public void addReturnXeListener(ActionListener listener) {
        totalPriceBtn.addActionListener(listener);
    }

    public void addTraXeListener(ActionListener listener) {
        traXeBtn.addActionListener(listener);
    }

    public void addDeleteStudentListener(ActionListener listener) {
        deleteXeBtn.addActionListener(listener);
    }

    public void addClearListener(ActionListener listener) {
        clearBtn.addActionListener(listener);
    }

    public void addListStudentSelectionListener(ListSelectionListener listener) {
        studentTable.getSelectionModel().addListSelectionListener(listener);
    }

    public String getTraXeId() {
        return traXeField.getText();
    }

    public void showTotalMoney(int totalMoney) {
        totalMoneyLabel.setText("Tổng tiền: " + totalMoney + " VND");
    }
}
