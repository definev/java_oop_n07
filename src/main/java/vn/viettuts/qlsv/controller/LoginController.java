package vn.viettuts.qlsv.controller;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import vn.viettuts.qlsv.dao.UserDao;
import vn.viettuts.qlsv.entity.User;
import vn.viettuts.qlsv.view.LoginView;
import vn.viettuts.qlsv.view.GuiXeView;

public class LoginController {
    private UserDao userDao;
    private LoginView loginView;
    private GuiXeView guiXeView;
    
    public LoginController(LoginView view) {
        this.loginView = view;
        this.userDao = new UserDao();
        view.addLoginListener(new LoginListener());
    }
    
    public void showLoginView() {
        loginView.setVisible(true);
    }
    
    /**
     * Lớp LoginListener 
     * chứa cài đặt cho sự kiện click button "Login"
     * 
     * @author viettuts.vn
     */
    class LoginListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            final boolean isLogin = true;
//            User user = loginView.getUser();
//            if (userDao.checkUser(user)) {
            if (isLogin) {
                // nếu đăng nhập thành công, mở màn hình quản lý sinh viên
                guiXeView = new GuiXeView();
                GuiXeController guiXeController = new GuiXeController(guiXeView);
                guiXeController.showStudentView();
                loginView.setVisible(false);
            } else {
                loginView.showMessage("username hoặc password không đúng.");
            }
        }
    }
}
