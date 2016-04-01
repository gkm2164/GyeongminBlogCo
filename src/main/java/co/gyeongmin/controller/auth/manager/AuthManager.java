package co.gyeongmin.controller.auth.manager;

import co.gyeongmin.controller.auth.entity.AuthObject;

import javax.servlet.http.HttpSession;

/**
 * Created by USER on 2016-04-01.
 */
public class AuthManager {
    public static class SessionAuthBox {
        private Integer id;
        private Integer hashCode;

        SessionAuthBox(Integer userId, AuthObject authObject) {
            this.id = userId;
            this.hashCode = authObject.hashCode();
        }
    }

    public static void createSession(Integer id, AuthObject authObject, HttpSession session) {
        session.setAttribute("AuthBox", new SessionAuthBox(id, authObject));
    }

    public static void destroySession(HttpSession session) {
        session.removeAttribute("AuthBox");
    }

    public static Integer getUserID(HttpSession session) {
        Object authBox = session.getAttribute("AuthBox");

        if (authBox == null)
            return null;
        if (!(authBox instanceof SessionAuthBox)) {
            throw new IllegalStateException("Session is not valid");
        }

        return ((SessionAuthBox)authBox).id;
    }

    public static boolean isLoggedIn(HttpSession session) {
        return session.getAttribute("AuthBox") != null;
    }
}
