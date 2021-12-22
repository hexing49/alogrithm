package designPartten;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

/**
 * @Author hexing37
 * @Version 1.0
 * @Date Created in 2021/12/6 20:30
 * @Description
 */
@Data
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = -1;
    String name;

    String gender;
}
