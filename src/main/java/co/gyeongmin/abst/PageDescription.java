package co.gyeongmin.abst;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by USER on 2016-03-25.
 */
public class PageDescription {
    private final String view;
    private final String title;
    private final List<String> cssList;
    private final List<String> hjsList;
    private final List<String> fjsList;

    public PageDescription(String view, String title, PageResourceFiller prf) {
        this.view = view;
        this.title = title;
        this.cssList = new ArrayList<>();
        this.hjsList = new ArrayList<>();
        this.fjsList = new ArrayList<>();

        prf.fill(cssList, hjsList, fjsList);
    }

    public String getView() {
        return view;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getCssList() {
        return cssList;
    }

    public List<String> getHjsList() {
        return hjsList;
    }

    public List<String> getFjsList() {
        return fjsList;
    }
}
