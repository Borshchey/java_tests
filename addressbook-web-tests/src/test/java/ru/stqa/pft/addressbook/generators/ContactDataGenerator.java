package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import ru.stqa.pft.addressbook.model.ContactData;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;


public class ContactDataGenerator {

    @Parameter(names = "-c", description = "Group count")
    public int count;

    @Parameter(names = "-f", description = "Target file")
    public String file;

    @Parameter(names = "-d", description = "Data format")
    public String format;


    public static void main(String[] args) throws IOException {
      ContactDataGenerator generator = new ContactDataGenerator();
      JCommander jCommander = JCommander.newBuilder().addObject(generator).build();
      try {
        jCommander.parse(args);
      } catch (ParameterException ex) {
        jCommander.usage();
        return;
      }
      generator.run();
    }

    private void run() throws IOException {
      List<ContactData> contacts = generateContacts(count);
      if (format.equals("json")) {
        saveAsJson(contacts, new File(file));
      } else {
        System.out.println("Unrecognized format " + format);
      }
    }

    private void saveAsJson(List<ContactData> contacts, File file) throws IOException {
      Gson gson = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().create();
      String json = gson.toJson(contacts);
      try (Writer writer = new FileWriter(file)) {
        writer.write(json);
      }
    }

    private List<ContactData> generateContacts(int count) {
      List<ContactData> contacts = new ArrayList<ContactData>();
      for (int i = 0; i < count; i++) {
        contacts.add(new ContactData()
                .withFirstname(String.format("First_Name %s", i + 1))
                .withLastname(String.format("Last_Name %s", i + 1))
                .withAddress(String.format("Some address %s", i + 1))
                .withMobilePhone("89001002030")
                .withWorkPhone("89001002030")
                .withEmail(String.format("mail_%s@test.com", i + 1))
                .withEmail2(String.format("mail2_%s@test.com", i + 1)));
                //.withGroup("Group_Name 1"));
      }
      return contacts;
    }

  }
