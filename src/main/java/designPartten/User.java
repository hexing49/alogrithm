package designPartten;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @Author hexing37
 * @Version 1.0
 * @Date Created in 2021/12/6 20:30
 * @Description
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User implements Serializable {
    String name;

    String gender;

    String age;

    String test;

    String test2;
}
