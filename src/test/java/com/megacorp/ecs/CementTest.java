package com.megacorp.ecs;

import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CementTest {

    Cement cement;

    @Before
    public void setUp() {
        cement = new Cement();
    }

    @Test
    public void should_render_1_bag_and_0_box_when_command_contains_1_bag(){
        // Given
        int bagQuantity = 1;
        String expectedQuantity = "0 box and 1 bag";
        // When
        String result = cement.calculateQuantity(bagQuantity);
        // Then
        assertThat(result).isEqualTo(expectedQuantity);
    }

    @Test
    public void should_render_3_bag_and_0_box_when_command_contains_3_bag(){
        // Given
        int bagQuantity = 3;
        String expectedQuantity = "0 box and 3 bag";
        // When
        String result = cement.calculateQuantity(bagQuantity);
        // Then
        assertThat(result).isEqualTo(expectedQuantity);
    }

     @Test
    public void should_render_1_box_and_0_bag_when_command_contains_4_bag(){
        // Given
        int bagQuantity = 4;
        String expectedQuantity = "1 box and 0 bag";
        // When
        String result = cement.calculateQuantity(bagQuantity);
        // Then
        assertThat(result).isEqualTo(expectedQuantity);
    }

    @Test
    public void should_render_1_box_2_bag_when_command_contains_6_bag(){
        // Given
        int bagQuantity = 6;
        String expectedQuantity = "1 box and 2 bag";
        // When
        String result = cement.calculateQuantity(bagQuantity);
        // Then
        assertThat(result).isEqualTo(expectedQuantity);
    }

    @Test
    public void should_render_exception_when_command_contains_0_bag(){
        // Given
        int bagQuantity = 0;
        String expectedMessage = "No bag added!";
        // When
        String result = cement.calculateQuantity(bagQuantity);
        // Then
        assertThat(result).isEqualTo(expectedMessage);
    }

    // <String, Integer>
    // new CementException
}
