package co.gyeongmin.abst;

import java.util.List;

/**
 * Created by gyeongmin on 3/24/16.
 */
public class PageDescription {

    private final String view;
    private final String title;
    private List<String> css;
    private List<String> headerJS;
    private List<String> footerJS;

    public PageDescription(String view, String title, PageFiller pf) {
        this.view = view;
        this.title = title;
        pf.fillPage(css, headerJS, footerJS);
    }

    public String getView() {
        return view;
    }

    public String getTitle() {
        return title;
    }

    public List<String> getCss() {
        return css;
    }

    public void setCss(List<String> css) {
        this.css = css;
    }

    public List<String> getHeaderJS() {
        return headerJS;
    }

    public void setHeaderJS(List<String> headerJS) {
        this.headerJS = headerJS;
    }

    public List<String> getFooterJS() {
        return footerJS;
    }

    public void setFooterJS(List<String> footerJS) {
        this.footerJS = footerJS;
    }
}
