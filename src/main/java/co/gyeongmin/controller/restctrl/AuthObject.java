package co.gyeongmin.controller.restctrl;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Created by gyeongmin on 3/28/16.
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthObject {
    private String id;
    private String password;
}
