package co.gyeongmin.abst;

import java.util.List;

/**
 * Created by USER on 2016-03-25.
 */
public interface PageResourceFiller {
    void fill(List<String> css, List<String> headerJS, List<String> footerJS);
}
