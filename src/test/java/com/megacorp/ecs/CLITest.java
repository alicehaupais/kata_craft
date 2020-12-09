package com.megacorp.ecs;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CLITest {

    ByteArrayOutputStream buffer;
    String content = "";

    @Before
    public void setUp() {
        buffer = new ByteArrayOutputStream();

        System.setOut(new PrintStream(buffer));
    }

    @After
    public void tearDown() {
        System.setOut(new PrintStream(new FileOutputStream(FileDescriptor.out)));
    }

    @Test
    public void main_works() {
        // Given
        String[] args = new String[0];
        String myString = "quit\n";
        InputStream is = new ByteArrayInputStream(myString.getBytes());

        System.setIn(is);

        // When
        CLI.main(args);

        content = buffer.toString();

        // Then
        assertThat(content).isEqualToNormalizingNewlines("\n" +
                "--------------------------------------------------------------------------------\n" +
                "          Welcome to Efficent Command System 2.0\n" +
                "--------------------------------------------------------------------------------\n" +
                "\n" +
                "Enter command : \n" +
                "--------------------------------------------------------------------------------\n" +
                "          System stopped\n" +
                "--------------------------------------------------------------------------------\n" +
                "\n"
        );
    }

    @Test
    public void help_works() {
        // Given
        String[] args = new String[0];
        String myString = "help\nquit\n";
        InputStream is = new ByteArrayInputStream(myString.getBytes());

        System.setIn(is);

        // When
        CLI.main(args);

        content = buffer.toString();

        // Then
        assertThat(content).isEqualToNormalizingNewlines("\n" +
                "--------------------------------------------------------------------------------\n" +
                "          Welcome to Efficent Command System 2.0\n" +
                "--------------------------------------------------------------------------------\n" +
                "\n" +
                "Enter command : \n" +
                "Unknown command\n" +
                "The available commands are the following : \n" +
                "\n" +
                "quit - quit the program\n" +
                "order - create a new command\n" +
                "help - displays the help\n" +
                "\n" +
                "Enter command : \n" +
                "--------------------------------------------------------------------------------\n" +
                "          System stopped\n" +
                "--------------------------------------------------------------------------------\n" +
                "\n");
    }

    @Test
    public void empty_command() {
        // Given
        String[] args = new String[0];
        String myString = "order\nquit\nstop\nquit\n";
        InputStream is = new ByteArrayInputStream(myString.getBytes());

        System.setIn(is);

        // When
        CLI.main(args);

        content = buffer.toString();

        // Then
        assertThat(content).isEqualToNormalizingNewlines("\n" +
                "--------------------------------------------------------------------------------\n" +
                "          Welcome to Efficent Command System 2.0\n" +
                "--------------------------------------------------------------------------------\n" +
                "\n" +
                "Enter command : \n" +
                "--------------------------------------------------------------------------------\n" +
                "          Order Menu\n" +
                "--------------------------------------------------------------------------------\n" +
                "\n" +
                "New order created.\n" +
                "Add new elements to your order\n" +
                "\n" +
                "What do you want to add to order: \n" +
                "Nothing added\n" +
                "\n" +
                "Enter order command : \n" +
                "Quit Order Menu\n" +
                "\n" +
                "Enter command : \n" +
                "--------------------------------------------------------------------------------\n" +
                "          System stopped\n" +
                "--------------------------------------------------------------------------------\n" +
                "\n");
    }
}
