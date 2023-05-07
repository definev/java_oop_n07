package vn.viettuts.qlsv.dao;

import java.util.*;

import vn.viettuts.qlsv.entity.Xe;
import vn.viettuts.qlsv.entity.XeXML;
import vn.viettuts.qlsv.utils.FileUtils;
import vn.viettuts.qlsv.utils.RandomStringGenerator;

/**
 * StudentDao class
 *
 * @author viettuts.vn
 */
public class GuiXeDao {
    private static final String STUDENT_FILE_NAME = "student.xml";
    private List<Xe> listXes;

    public GuiXeDao() {
        this.listXes = readListStudents();
        if (listXes == null) {
            listXes = new ArrayList<Xe>();
        }
    }

    /**
     * Lưu các đối tượng student vào file student.xml
     *
     * @param xes
     */
    public void writeListStudents(List<Xe> xes) {
        XeXML xeXML = new XeXML();
        xeXML.setStudent(xes);
        FileUtils.writeXMLtoFile(STUDENT_FILE_NAME, xeXML);
    }

    /**
     * Đọc các đối tượng student từ file student.xml
     *
     * @return list student
     */
    public List<Xe> readListStudents() {
        List<Xe> list = new ArrayList<Xe>();
        XeXML xeXML = (XeXML) FileUtils.readXMLFile(
                STUDENT_FILE_NAME, XeXML.class);
        if (xeXML != null) {
            list = xeXML.getStudent();
        }
        return list;
    }


    /**
     * thêm student vào listStudents và lưu listStudents vào file
     *
     * @param xe
     */
    public void add(Xe xe) {
        xe.setId(RandomStringGenerator.generate());
        listXes.add(xe);
        writeListStudents(listXes);
    }

    /**
     * cập nhật student vào listStudents và lưu listStudents vào file
     *
     * @param xe
     */
    public void edit(Xe xe) {
        int size = listXes.size();
        for (int i = 0; i < size; i++) {
            if (listXes.get(i).getId() == xe.getId()) {
                listXes.get(i).setName(xe.getBienSo());
                listXes.get(i).setThoiGian(xe.getThoiGian());
                listXes.get(i).setKhuVuc(xe.getKhuVuc());
                writeListStudents(listXes);
                break;
            }
        }
    }

    /**
     * xóa student từ listStudents và lưu listStudents vào file
     *
     * @param xe
     */
    public boolean delete(Xe xe) {
        boolean isFound = false;
        int size = listXes.size();
        for (int i = 0; i < size; i++) {
            if (Objects.equals(listXes.get(i).getId(), xe.getId())) {
                xe = listXes.get(i);
                isFound = true;
                break;
            }
        }
        if (isFound) {
            listXes.remove(xe);
            writeListStudents(listXes);
            return true;
        }
        return false;
    }

    /**
     * sắp xếp danh sách student theo name theo tứ tự tăng dần
     */
    public void sortStudentByName() {
        Collections.sort(listXes, new Comparator<Xe>() {
            public int compare(Xe xe1, Xe xe2) {
                return xe1.getBienSo().compareTo(xe2.getBienSo());
            }
        });
    }

    public List<Xe> getListStudents() {
        return listXes;
    }

    public void setListStudents(List<Xe> listXes) {
        this.listXes = listXes;
    }

    public Xe getById(String id) {
        for (Xe xe : listXes) {
            if (Objects.equals(xe.getId(), id)) {
                return xe;
            }
        }
        return null;
    }
}