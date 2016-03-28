package co.gyeongmin.abst;

import org.springframework.ui.Model;

public abstract class LayoutController {
    public String layoutCall(PageDescription pageDescription, Model model) {
        model.addAttribute("PDESC", pageDescription);
        return "layout/application";
    }
}
