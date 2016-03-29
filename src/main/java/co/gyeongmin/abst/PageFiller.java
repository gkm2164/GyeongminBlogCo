package co.gyeongmin.abst;

import java.util.List;

/**
 * Created by gyeongmin on 3/24/16.
 */
public interface PageFiller {
    void fillPage(List<String> css, List<String> headerJS, List<String> footerJS);
}
