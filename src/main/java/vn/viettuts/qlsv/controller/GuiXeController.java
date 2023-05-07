package vn.viettuts.qlsv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import vn.viettuts.qlsv.dao.GuiXeDao;
import vn.viettuts.qlsv.entity.Xe;
import vn.viettuts.qlsv.view.GuiXeView;

public class GuiXeController {
    private GuiXeDao guiXeDao;
    private GuiXeView guiXeView;

    public GuiXeController(GuiXeView view) {
        this.guiXeView = view;
        guiXeDao = new GuiXeDao();

        view.addAddStudentListener(new AddStudentListener());
        view.addReturnXeListener(new TotalStudentListener());
        view.addDeleteStudentListener(new DeleteStudentListener());
        view.addClearListener(new ClearStudentListener());
        view.addListStudentSelectionListener(new ListStudentSelectionListener());
        view.addTraXeListener(new TraXeListener());
    }

    public void showStudentView() {
        List<Xe> xeList = guiXeDao.getListStudents();
        guiXeView.setVisible(true);
        guiXeView.showListStudents(xeList);
    }

    /**
     * Lớp AddStudentListener
     * chứa cài đặt cho sự kiện click button "Add"
     *
     * @author viettuts.vn
     */
    class AddStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Xe xe = guiXeView.getStudentInfo();
            if (xe != null) {
                guiXeDao.add(xe);
                guiXeView.showXe(xe);
                guiXeView.showListStudents(guiXeDao.getListStudents());
//                studentView.showMessage("Thêm thành công!");
            }
        }
    }

    /**
     * Lớp EditStudentListener
     * chứa cài đặt cho sự kiện click button "Edit"
     *
     * @author viettuts.vn
     */
    class TotalStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Xe xe = guiXeView.getStudentInfo();
            if (xe != null) {
                var now = new Date();
                try {
                    var thoiGianGui = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").parse(xe.getThoiGian());

                    // Calculate the difference between two dates
                    var difference = now.getTime() - thoiGianGui.getTime();
                    var hoursBetween = (difference / (1000 * 60 * 60));
                    var totalMoney = 0;

                    if (hoursBetween < 24) {
                        totalMoney = 3000;
                        if (now.getHours() > 16) {
                            totalMoney = 5000;
                        }
                    } else if (hoursBetween < 24 * 7) {
                        totalMoney = 10000;
                    } else if (hoursBetween < 24 * 30) {
                        totalMoney = 200000;
                    } else {
                        totalMoney = 500000;
                    }


                    guiXeDao.delete(xe);
                    guiXeView.clearStudentInfo();
                    guiXeView.showListStudents(guiXeDao.getListStudents());
                    guiXeView.showTotalMoney(totalMoney);
                } catch (ParseException ex) {
                    throw new RuntimeException(ex);
                }

            }
        }
    }

    /**
     * Lớp DeleteStudentListener
     * chứa cài đặt cho sự kiện click button "Delete"
     *
     * @author viettuts.vn
     */
    class DeleteStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            Xe xe = guiXeView.getStudentInfo();
            if (xe != null) {
                guiXeDao.delete(xe);
                guiXeView.clearStudentInfo();
                guiXeView.showListStudents(guiXeDao.getListStudents());
                guiXeView.showMessage("Xóa thành công!");
            }
        }
    }

    /**
     * Lớp ClearStudentListener
     * chứa cài đặt cho sự kiện click button "Clear"
     *
     * @author viettuts.vn
     */
    class ClearStudentListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            guiXeView.clearStudentInfo();
        }
    }

    /**
     * Lớp ListStudentSelectionListener
     * chứa cài đặt cho sự kiện chọn student trong bảng student
     *
     * @author viettuts.vn
     */
    class ListStudentSelectionListener implements ListSelectionListener {
        public void valueChanged(ListSelectionEvent e) {
            guiXeView.fillStudentFromSelectedRow();
        }
    }

    class TraXeListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String id = guiXeView.getTraXeId();
            var xe = guiXeDao.getById(id);

            if (xe != null) {
                guiXeView.showXe(xe);
            }
        }
    }
}
