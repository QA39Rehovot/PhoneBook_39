package manager;

import models.Contact;
import models.User;
import org.testng.annotations.DataProvider;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProviderData {

    @DataProvider
    public Iterator<Object[]> userDTO(){ // Data Transfer Object = DTO
        List<Object[]> list = new ArrayList<>();
        list.add(new Object[]{
                User.builder()
                .email("abc@def.com")
                .password("$Abcdef12345")
                .build()
        });
        list.add(new Object[]{
                User.builder()
                        .email("abc@def.com")
                        .password("$Abcdef12345")
                        .build()
        });
        list.add(new Object[]{
                User.builder()
                        .email("abc@def.com")
                        .password("$Abcdef12345")
                        .build()
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> contactDTO() { // Data Transfer Object = DTO
        List<Object[]> list = new ArrayList<>();
        int i = (int) (System.currentTimeMillis() / 1000) % 3600;
        list.add(new Object[]{
                Contact.builder()
                        .name("Jack_" + i)
                        .lastName("Sparrow")
                        .phone("123456" + i)
                        .address("Rehovot")
                        .description("Pirate")
                        .email("jack_" + i + "@mail.com")
                        .build()
        });
        list.add(new Object[]{
                Contact.builder()
                        .name("Jack_" + i)
                        .lastName("Sparrow")
                        .phone("123456" + i)
                        .address("Rehovot")
                        .description("Pirate")
                        .email("jack_" + i + "@mail.com")
                        .build()
        });
        return list.iterator();
    }

    @DataProvider
    public Iterator<Object[]> registrationCSV() throws IOException { // Data Transfer Object = DTO
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(
                new FileReader(new File("src/test/resources/reg_dataset.csv")));
        String line = reader.readLine();
        while (line != null) {
            String[] split = line.split(",");
            list.add(new Object[]{
                    User.builder()
                            .email(split[0])
                            .password(split[1])
                            .build()
            });
            line = reader.readLine();
        }
        reader.close();
        return list.iterator();
    }
}
