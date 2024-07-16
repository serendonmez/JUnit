package Day16_getScreenShot;

import com.github.javafaker.Faker;
import org.junit.jupiter.api.Test;

public class deneme {
    public static void main(String[] args) {
        Faker faker=new Faker();
        String randomGender= faker.demographic().sex();
        System.out.println(randomGender);
    }
}
